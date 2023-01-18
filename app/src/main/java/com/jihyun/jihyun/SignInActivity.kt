package com.jihyun.jihyun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.jihyun.jihyun.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var signInBinding: ActivitySignInBinding
    private var savedID = ""
    private var savedPassword = ""
    private var savedMBTI = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        savedID = intent.getStringExtra("ID").toString()
        savedPassword = intent.getStringExtra("Password").toString()
        savedMBTI = intent.getStringExtra("MBTI").toString()

        Log.d("checkID", savedID + " / " + savedPassword + " / " + savedMBTI)

        signInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)

        signInBinding.btnSignInSignUp.setOnClickListener {
            val signInIntent = Intent(this, SignUpActivity::class.java)
            startActivity(signInIntent)
        }
    }
}