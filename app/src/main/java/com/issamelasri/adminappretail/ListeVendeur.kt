package com.issamelasri.adminappretail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.issamelasri.adminappretail.stock.StockVendeur
import kotlinx.android.synthetic.main.activity_liste_vendeur.*

class ListeVendeur : AppCompatActivity(), RecyclerClickListener {

    private val adapter = ListVendeurAdapter()
    private val model: ViewModelUser by viewModels()

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_vendeur)
        //Recyceler
        adapter.listener = this
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

        model.fitchClients()
        model.getRealtimeUpdates()
        model.client.observe(this, Observer {
            adapter.addClient(it)
        })
        model.clients.observe(this, Observer {
            adapter.setClients(it)
        })

        model.result.observe(this, Observer {
            val message = if (it == null) {
                getString(R.string.Vendeur_suprime)
            } else {
                getString(R.string.erreur, it.message)
            }
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()

        })

    }

    var email = ""
    override fun onPause() {
        super.onPause()
        email = ""

    }

    override fun onRecyclerItemClicked(view: View, client: Vendeur) {
        view.setOnClickListener {
            val i = Intent(this, StockVendeur::class.java)
            email = client.email.replace("@", "").replace(".", "")
            i.putExtra(STOCK_CHILD, email)
            startActivity(i)
        }
    }


}