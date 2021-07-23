package com.example.mymvvmretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mymvvmretrofit.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        var name = binding.username.text.toString()
        var upassword = binding.password.text.toString()
        val Uname = "test@android.com"
        val Upassword = "123456"

        binding.signin.setOnClickListener {
           if (username.text.isEmpty()) {
                username.error = "plese enter user name"
            }
            if (password.text.isEmpty()) {
                password.error = "please enter user password"
            }
            if (!username.text.isEmpty() && !password.text.isEmpty()) {
                checkvalidate()
            }
        }
    }

    fun checkvalidate(){
        val name=binding.username.text.toString()
        val password=binding.password.text.toString()
        val Uname="test@android.com"
        val Upassword="123456"

        if (name.equals(Uname) && password.equals(Upassword)){
            Toast.makeText(this,"sucessfull login",Toast.LENGTH_LONG).show()
            val intent=Intent(this,DatePickerActivity::class.java)
            startActivity(intent)
        }
         else {
            Toast.makeText(this,"please check username and password ",Toast.LENGTH_LONG).show()
        }

    }

}
