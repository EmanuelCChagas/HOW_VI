package com.example.howvi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.howvi.databinding.ActivityTelaInicioBinding

class TelaInicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.getItemId()){
            R.id.itemArtistas -> abrirArtistas()
            R.id.itemEventos -> abrirEventos()
            R.id.itemBandas -> abrirBandas()
        }

        return super.onOptionsItemSelected(item)
    }


    public fun abrirEventos(){

    }
    public fun abrirArtistas(){
        startActivity(Intent(this, TelaArtistasActivity::class.java))
    }
    public fun abrirBandas(){
        startActivity(Intent(this, TelaBandasActivity::class.java))
    }
}