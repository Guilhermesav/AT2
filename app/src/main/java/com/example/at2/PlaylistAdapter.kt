package com.example.at2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaylistAdapter(var listaMusicas:List<String> = listOf()) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {

        val card =  LayoutInflater.from(parent.context).inflate(R.layout.card_playlist,parent,false)
        return PlaylistViewHolder(card)
    }

    override fun getItemCount() = listaMusicas.size

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.musicaTextView.text = listaMusicas[position]
    }
    class PlaylistViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){

        val musicaTextView: TextView = itemView.findViewById(R.id.musicTextView)
    }
    fun mudarDados(musicas:List<String>){

        listaMusicas = musicas

        notifyDataSetChanged()

    }
}