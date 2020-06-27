package com.issamelasri.adminappretail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.FirebaseDatabase

class ListeVendeur : AppCompatActivity() {
    private lateinit var clientViewModel: ViewModelUser
    private val rootNode = FirebaseDatabase.getInstance().getReference(LIST_USER)
    private val adapter = ListVendeurAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_vendeur)
        clientViewModel = ViewModelUser()
        clientViewModel.client.observe(this, Observer {
            Toast.makeText(this,"hhhhh",Toast.LENGTH_LONG).show()
        })
    }

}