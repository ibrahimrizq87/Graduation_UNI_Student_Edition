package com.uni.unistudent.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment

import com.uni.unistudent.databinding.ActivitySignUpBinding

import android.widget.*
import androidx.activity.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.uni.unistudent.R

import com.uni.unistudent.viewModel.AuthViewModel
import com.uni.unistudent.viewModel.FireStorageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val viewModel: AuthViewModel by viewModels()
    private val fireStorageViewModel: FireStorageViewModel by viewModels()
    private lateinit var auth: FirebaseAuth
    private lateinit var grade: String
    private lateinit var section: String
    val TAG = "SignUp"
    private lateinit var progressPar: ProgressBar
    private lateinit var dep: String
    private lateinit var userImageUri: Uri
    private lateinit var imageView: ImageView

    companion object {
        const val IMAGE_REQUEST_CODE = 100
    }



    public fun nextFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {

            setCustomAnimations(
                R.anim.enter_right_to_left,
                R.anim.exist_right_to_left,
                R.anim.enter_left_to_right,
                R.anim.exist_left_to_right
            )

            replace(
                R.id.fragment_container,
                fragment
            ).commit()
        }
    }    public fun previousFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {

            setCustomAnimations(
                R.anim.enter_left_to_right,
                R.anim.exist_left_to_right,
                R.anim.enter_right_to_left,
                R.anim.exist_right_to_left
            )

            replace(
                R.id.fragment_container,
                fragment
            ).commit()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nextFragment(FragmentSignUpMainData())
        binding.close.setOnClickListener {
            finish()
        }

        grade = ""
        dep = ""
        section = ""
        userImageUri = Uri.EMPTY
        //----------------
        auth = Firebase.auth
        //----------------
/*
        progressPar = binding.progressBarSignIn

        imageView = binding.signUserImage

        binding.signUserImage.setOnClickListener{
            pickImageFromGallery()
        }*/


        // spinners code
        // grade spinner
/*
        val gradeList = resources.getStringArray(R.array.grades)
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.grades,R.layout.spinner_item)
        val gradeSpinner = findViewById<Spinner>(R.id.grade_spinner)
        gradeSpinner.adapter=adapter

        gradeSpinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0 : AdapterView<*>?, p1: View?, p2:Int, p3: Long) {
                grade =gradeList[p2]
                binding.gradeText.text = grade
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }*/


// departement spinner


/*
        val depList = resources.getStringArray(R.array.departement)
        val depAdapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.departement,R.layout.spinner_item)
        val depSpinner = findViewById<Spinner>(R.id.dep_spinner)
        depSpinner.adapter=depAdapter

        depSpinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0 : AdapterView<*>?, p1: View?, p2:Int, p3: Long) {
                dep =depList[p2]
                binding.depText.text = dep
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }*/

// section spinner
/*
        val sectionList = resources.getStringArray(R.array.Section)
        val sectionAdapter: ArrayAdapter<CharSequence> =
            ArrayAdapter.createFromResource(this, R.array.Section, R.layout.spinner_item)
        val sectionSpinner = findViewById<Spinner>(R.id.section_spinner)
        sectionSpinner.adapter = sectionAdapter

        sectionSpinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0 : AdapterView<*>?, p1: View?, p2:Int, p3: Long) {
                section =sectionList[p2]
                binding.sectionText.text = section
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
*/


/*
        binding.signUpBt.setOnClickListener {
            val email=binding.signEmailAddress.text.toString()
            val password = binding.signPassword.text.toString()
            val code = binding.signCode.text.toString()
            val fullName = binding.signName.text.toString()


            if (userImageUri !=  Uri.EMPTY){
                if (email.isNotEmpty()&&password.isNotEmpty() &&code.isNotEmpty()&&fullName.isNotEmpty()&&grade.isNotEmpty()){
                    if (password.length == 14  ) {
                        viewModel.Register(
                            email, password, UserStudent.kt(
                                fullName, "", code, password, grade, section,dep
                            )
                        )
                        observeSignUp()

                    }else{
                        Toast.makeText(this,"make sure to write the 14 number of the national id",
                            Toast.LENGTH_SHORT).show()

                    }
                }else{
                    Toast.makeText(this,"all data are required", Toast.LENGTH_SHORT).show()

                }
            }else{
                Toast.makeText(this,"make sure to choose picture", Toast.LENGTH_SHORT).show()
            }
        }


*/


    }


// observing the registration function to check if it run properly
/* private fun observeSignUp(){
     lifecycleScope.launchWhenCreated {
         viewModel.register.collectLatest { state ->
             when (state) {
                 is Resource.Loading -> {
                     progressPar.visibility=View.VISIBLE

                 }
                 is Resource.Success -> {
                     progressPar.visibility=View.INVISIBLE
                     Toast.makeText(this@SignUp,state.result, Toast.LENGTH_LONG).show()
                     val userId = auth.currentUser?.uid
                     if (userId !=null){
                         fireStorageViewModel.addUri(userId,userImageUri)
                         observeUploadedImage()
                     }

                     startActivity(Intent(this@SignUp, HomeScreen::class.java))
                 }
                 is Resource.Failure -> {
                     progressPar.visibility=View.INVISIBLE
                     Toast.makeText(this@SignUp,state.exception.toString(),
                         Toast.LENGTH_LONG).show()
                 }
                 else->{}
             }
         }

     }
 }
*/
/*
    // observing the upload function to check if it run properly
    private fun observeUploadedImage() {
        lifecycleScope.launchWhenCreated {
            fireStorageViewModel.addUri.collectLatest {
                when (it) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        Log.e(TAG, "it.result ")

                    }
                    is Resource.Failure -> {

                        Toast.makeText(this@SignUp, it.exception.toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                    else -> {}
                }

            }
        }

    }


    // pick an image from the gallery
    private fun pickImageFromGallery(){
        val intent = Intent (Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK)
        {
            userImageUri = data?.data!!
            imageView.setImageURI(userImageUri)
        }
    }
    //-----------------------------------------------
*/



    // if the user is registered go to the home page
    // if there is no user registered delete user session
/*
    override fun onStart() {
        super.onStart()
        viewModel.getSessionStudent {user->
            if (user !=null && auth.currentUser !=null){
                startActivity(Intent(this, HomeScreen::class.java))

            }else if((user !=null && auth.currentUser ==null)){
                viewModel.logOut {
                    Log.e(TAG, "shared preferences deleted ")
                }
            }
        }}*/

 */
}