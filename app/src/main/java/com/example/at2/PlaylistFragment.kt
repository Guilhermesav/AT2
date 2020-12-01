@file:Suppress("DEPRECATION")

package com.example.at2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.at2.ViewModel.PlaylistViewModel
import com.example.at2.PlaylistAdapter
import kotlinx.android.synthetic.main.fragment_playlist.*


@Suppress("DEPRECATION")
class PlaylistFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playlist, container, false)
    }
    var playlistViewModel: PlaylistViewModel? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        activity?.let {
            playlistViewModel = ViewModelProviders.of(it)
                .get(PlaylistViewModel::class.java)
        }
        configurarRecyclerView()
        subscribe()
    }
    private fun configurarRecyclerView(){

        listMusic.layoutManager =   LinearLayoutManager(activity)
        listMusic.adapter = PlaylistAdapter()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun subscribe(){
        playlistViewModel!!.playlistLiveData!!.observe(this, Observer {lista->
            if (lista != null){
                val adapter = listMusic.adapter

                if (adapter is PlaylistAdapter){
                    adapter.mudarDados(lista)
                }
            }
        })
    }
}