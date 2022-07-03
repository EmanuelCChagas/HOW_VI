package com.example.howvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.howvi.databinding.ActivityMainBinding
import com.example.howvi.databinding.ActivityTelaLoginBinding
import com.google.firebase.firestore.FirebaseFirestore

class TelaLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaLoginBinding
    //private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val email = binding.inputAppEmail.text.toString()
            val senha = binding.inputAppSenha.text.toString()

            //checagem para verificar se o email esta vazio ou não
           // if (email.isEmpty() || senha.isEmpty()) {
           //     Toast.makeText(this, "Prencha todos os campos!", Toast.LENGTH_SHORT).show()
           // } else {
                verificarUsuario(email, senha)
           // }
        }
    }

    private fun verificarUsuario(email:String, senha:String){
        //verificar usuário no BackEnd
        //por enquanto apenas entrar na aplicação
        startActivity(Intent(this, TelaInicioActivity::class.java))
    }
}