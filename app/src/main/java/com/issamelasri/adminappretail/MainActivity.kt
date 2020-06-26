package com.issamelasri.adminappretail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            val i = Intent(this,AjouterNewStock::class.java)
            startActivity(i)
        }
        buttonVendeur.setOnClickListener {

        }
    }
}