package com.example.howvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.howvi.databinding.ActivityTelaArtistasBinding
import com.google.firebase.firestore.FirebaseFirestore

class TelaArtistasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaArtistasBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaArtistasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarUlimoArtista()
        binding.btnNovoArtistas.setOnClickListener {
            startActivity(Intent(this, TelaAdicionarArtistasActivity::class.java))
        }
    }
    private fun recuperarUlimoArtista(){
        db.collection("artistas").document("haMpEShQPYfg56rx9KSA").get()
            .addOnCompleteListener{artista ->
                if(artista.isSuccessful){
                    val nome = artista.result.get("nome").toString()
                    val funcao = artista.result.get("funcao").toString()
                    binding.txtArtistaNome.setText(nome)
                    binding.txtArtistaFuncao.setText(funcao)
                }
            }
    }
}