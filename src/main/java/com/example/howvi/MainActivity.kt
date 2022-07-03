package com.example.howvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.howvi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //supportActionBar!!.hide()

        binding.btnFazerLogin.setOnClickListener{
            //ao clicar fazer login  abri o activy do login
                startActivity(Intent(this, TelaLoginActivity::class.java))
        }
        binding.btnCriarConta.setOnClickListener{
            //ao clicar criar conta abri o activy da conta
           // startActivity(Intent(this, TelaContaCriacaoActivity::class.java))
        }
    }
}