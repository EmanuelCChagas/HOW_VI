package com.example.howvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.howvi.databinding.ActivityTelaAdicionarArtistasBinding
import com.google.firebase.firestore.FirebaseFirestore

class TelaAdicionarArtistasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaAdicionarArtistasBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaAdicionarArtistasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvarArtista.setOnClickListener {
            val nome =  binding.inputNomeArtista.text.toString()
            val funcao = binding.inputFuncArtista.text.toString()
            if (nome.isEmpty() || funcao.isEmpty()) {
                    Toast.makeText(this, "Há campos não preenchidos!", Toast.LENGTH_SHORT).show()
                 } else {
                salvarArtistas(nome, funcao)
            }
        }
    }

    public fun salvarArtistas(nome:String,funcao:String){
        val mapArtista = hashMapOf(
            "nome" to nome,
            "funcao" to funcao
        )

        db.collection("artistas").document("haMpEShQPYfg56rx9KSA")
            .set(mapArtista).addOnCompleteListener{ insercao ->
                if(insercao.isSuccessful){
                    Toast.makeText(this,"Artista Cadastrado com Sucesso",Toast.LENGTH_SHORT).show()
                    limparCampos()
                }
            }.addOnFailureListener(){
                Toast.makeText(this,"Não foi possível cadastrar artista",Toast.LENGTH_SHORT).show()
            }
    }

    public fun limparCampos(){
        binding.inputNomeArtista.setText("")
        binding.inputFuncArtista.setText("")
    }
}