package com.uni.unistudent.ui

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import com.uni.unistudent.R
import com.uni.unistudent.classes.Attendance
import com.uni.unistudent.classes.Lecture
import com.uni.unistudent.classes.Section
import com.uni.unistudent.classes.user.UserStudent
import com.uni.unistudent.data.Resource
import com.uni.unistudent.databinding.ActivityScanBinding
import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FirebaseRealtimeModelView
import com.uni.unistudent.viewModel.FirebaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import java.io.IOException

@AndroidEntryPoint
class Scan : AppCompatActivity() {
    private val authViewModel: AuthViewModel by viewModels()

    private val viewModelRealTime: FirebaseRealtimeModelView by viewModels()
    private val viewModel: FirebaseViewModel by viewModels()

    private val requestCodeCameraPermission = 1001
    private lateinit var cameraSource: CameraSource
    private lateinit var barcodeDetector: BarcodeDetector
    private var scannedValue = ""
    private lateinit var binding: ActivityScanBinding
    private var isPermissionDenied = false
    private lateinit var customDialog: CustomDialog
    var course=""
    var dep=""
    var section=""
    var id=""
    lateinit var currentUser:UserStudent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentUser=UserStudent()
        authViewModel.getSessionStudent { user ->
            if (user != null) {
                currentUser = user
            } else {
                Toast.makeText(
                    this,
                    "error on loading user data please refresh the current screen ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        val intent = intent
        course = intent.getStringExtra("course")!!
        dep = intent.getStringExtra("dep")!!
        section = intent.getStringExtra("section")!!
        id = intent.getStringExtra("id")!!
        Log.e("scan","$course ")
        binding.icBack.setOnClickListener { finish() }
        customDialog = CustomDialog(this)


        val permission =
            ContextCompat.checkSelfPermission(this@Scan, android.Manifest.permission.CAMERA)
        if (permission != PackageManager.PERMISSION_GRANTED
        ) {
            askForCameraPermission()
        } else {
            setupControls()
        }

        val aniSlide: Animation = AnimationUtils.loadAnimation(this@Scan, R.anim.scanner_animation)
        binding.barcodeLine.startAnimation(aniSlide)
    }

    private fun observeAddedAttendance() {
        lifecycleScope.launchWhenCreated {
            viewModel.addAttendance.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        Toast.makeText(this@Scan, state.result, Toast.LENGTH_LONG)
                            .show()
                        finish()

                    }
                    is Resource.Failure -> {
                        Toast.makeText(this@Scan, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                    else -> {}
                }
            }

        }
    }

    private fun setupControls() {
        barcodeDetector =
            BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.ALL_FORMATS).build()

        cameraSource = CameraSource.Builder(this, barcodeDetector)
            .setRequestedPreviewSize(250, 350)
            .setAutoFocusEnabled(true) //you should add this feature
            .build()

        binding.cameraSurfaceView.holder.addCallback(object : SurfaceHolder.Callback {
            @SuppressLint("MissingPermission")
            override fun surfaceCreated(holder: SurfaceHolder) {
                try {//Start preview after 1s delay

                    cameraSource.start(holder)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            @SuppressLint("MissingPermission")
            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
                try {
                    cameraSource.start(holder)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource.stop()
            }
        })


        barcodeDetector.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {
                Toast.makeText(applicationContext, "Scanner has been closed", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val barcodes = detections.detectedItems
                if (barcodes.size() == 1) {
                    scannedValue = barcodes.valueAt(0).rawValue
                    //TODO @walid CHECK QR HERE
                    if (scannedValue.contains('@')) {
                        val strings = scannedValue.split('@')
                        if (strings.size == 3) {
                            val hallId = strings[0]
                            val code = strings[1]
                            val x = strings[2]

                            runOnUiThread {
                                binding.barcodeLine.startAnimation(
                                    AnimationUtils.loadAnimation(
                                        this@Scan,
                                        R.anim.scanner_animation_stop
                                    )
                                )
                                cameraSource.stop()

                                viewModelRealTime.getAttendanceCode(hallId, x.toInt())
                                observeAttendanceCodeValidation()

                            }


                        } else {
                            runOnUiThread {
                                customDialog.showNotOurCode()
                            }
                        }
                    } else {
                        runOnUiThread {
                            customDialog.showNotOurCode()
                        }
                    }
                }
            }

        })
    }

    private fun observeAttendanceCodeValidation() {
        lifecycleScope.launchWhenCreated {
            viewModelRealTime.getAttendanceCode.collectLatest { state ->
                when (state) {
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                       if(state.result){
                           if (section=="no"){
                               viewModel.addLectureAttendance(
                                   Lecture(
                                       id,
                                       course,
                                       "",
                                       "",
                                       dep,
                                       "",
                                       "",
                                       "",
                                       "",
                                       false), Attendance(
                                       "",
                                       currentUser.name
                                       ,
                                       currentUser.code

                                   )
                               )
                           }else{
                               viewModel.addSectionAttendance(  Section(
                                   id,
                                   course,
                                   "",
                                   "",
                                   "",
                                   section,
                                   dep,
                                   "",
                                   "",
                                   "",
                                   false), Attendance(
                                   "",
                                   currentUser.name
                                   ,
                                   currentUser.code

                               ))
                           }
                           observeAddedAttendance()
                       }else{
                           Toast.makeText(this@Scan,"please try again with the right code", Toast.LENGTH_LONG)
                               .show()
                       }
                    }
                    is Resource.Failure -> {
                        Toast.makeText(this@Scan, state.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                    else -> {}
                }
            }

        }
    }

    private fun askForCameraPermission() {
        ActivityCompat.requestPermissions(
            this@Scan,
            arrayOf(android.Manifest.permission.CAMERA),
            requestCodeCameraPermission
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == requestCodeCameraPermission && grantResults.isNotEmpty()) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                setupControls()
                setContentView(binding.root)
                val aniSlide: Animation =
                    AnimationUtils.loadAnimation(this@Scan, R.anim.scanner_animation)
                binding.barcodeLine.startAnimation(aniSlide)

            } else {
                isPermissionDenied = true
                Toast.makeText(applicationContext, R.string.permissionDenied, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        if (!isPermissionDenied) {
            cameraSource.stop()
        }

    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

    }

}