package com.jihyun.jihyun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.jihyun.jihyun.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUpBinding: ActivitySignUpBinding
    private var idEnabled = false
    private var passwordEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        signUpBinding.etSignUpId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                var idStr: String = signUpBinding.etSignUpId.text.toString()

                if (idStr.length in 6..10) {
                    idEnabled = true

                    Log.d("SignUp", "id Check!")
                } else {
                    idEnabled = false
                }

                if (idEnabled && passwordEnabled) {
                    signUpBinding.btnSignUpSignUp.isEnabled = true
                }
            }
        })

        signUpBinding.etSignUpPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                var passwordStr: String = signUpBinding.etSignUpPassword.text.toString()

                if (passwordStr.length in 8..12) {
                    passwordEnabled = true

                    Log.d("SignUp", "password Check!")
                } else {
                    passwordEnabled = false
                }

                if (idEnabled && passwordEnabled) {
                    signUpBinding.btnSignUpSignUp.isEnabled = true
                }
            }
        })

        signUpBinding.btnSignUpSignUp.setOnClickListener {
            val signUpIntent = Intent(this, SignInActivity::class.java)
            signUpIntent.putExtra("ID", signUpBinding.etSignUpId.text.toString())
            signUpIntent.putExtra("Password", signUpBinding.etSignUpPassword.text.toString())
            signUpIntent.putExtra("MBTI", signUpBinding.etSignUpMbti.text.toString())
            startActivity(signUpIntent)
        }

    }
}