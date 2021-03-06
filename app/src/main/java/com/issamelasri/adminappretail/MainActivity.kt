package com.issamelasri.adminappretail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.issamelasri.adminappretail.stock.StockVendeur
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCreat.setOnClickListener {
            val i = Intent(this,CreateNewAccount::class.java)
            startActivity(i)
        }
        buttonStock.setOnClickListener {
            val i = Intent(this, StockVendeur::class.java)
            startActivity(i)
        }
        buttonVendeur.setOnClickListener {
            val i = Intent(this, ListeVendeur::class.java)
            startActivity(i)
        }
    }
}