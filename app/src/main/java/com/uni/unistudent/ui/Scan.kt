package com.uni.unistudent.ui

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import com.uni.unistudent.R
import com.uni.unistudent.databinding.ActivityScanBinding
import java.io.IOException

class Scan : AppCompatActivity() {
    private val requestCodeCameraPermission = 1001
    private lateinit var cameraSource: CameraSource
    private lateinit var barcodeDetector: BarcodeDetector
    private var scannedValue = ""
    private lateinit var binding: ActivityScanBinding
    private var isPermissionDenied = false
    private lateinit var customDialog: CustomDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

    private fun setupControls() {
        barcodeDetector =
            BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.ALL_FORMATS).build()

        cameraSource = CameraSource.Builder(this, barcodeDetector)
            .setRequestedPreviewSize(250, 250)
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
                                Toast.makeText(
                                    this@Scan,
                                    "hall = $hallId code= $code x = $x",
                                    Toast.LENGTH_SHORT
                                ).show()

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