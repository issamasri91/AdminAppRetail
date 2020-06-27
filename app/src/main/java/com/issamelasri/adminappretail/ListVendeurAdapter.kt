package com.issamelasri.adminappretail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ListVendeurAdapter:  RecyclerView.Adapter<ListVendeurAdapter.ClientViewModel>() {
    private var clients = mutableListOf<Vendeur>()
    var listener: RecyclerClickListener? = null


    class ClientViewModel(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClientViewModel(
        LayoutInflater.from(parent.context).inflate(
            R.layout.example_item,
            parent, false
        )
    )

    override fun getItemCount() = clients.size

    override fun onBindViewHolder(holder: ClientViewModel, position: Int) {

        holder.view.email_text.text = clients[position].email
        holder.view.deleteImageButton.setOnClickListener {
            listener?.onRecyclerItemClicked(it, clients[position])
        }
    }

    fun addClient(client: Vendeur) {
        if (!clients.contains(client)) {
            clients.add(client)
        } else {
            val index = clients.indexOf(client)
            if (client.isDeleted) {
                clients.removeAt(index)
            } else {
                clients[index] = client
            }
        }
        notifyDataSetChanged()
    }

    fun setClients(clients: List<Vendeur>) {
        this.clients = clients as MutableList<Vendeur>
        notifyDataSetChanged()
    }
}

