@file:Suppress("DEPRECATION")

package com.example.at2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.at2.ViewModel.PlaylistViewModel
import kotlinx.android.synthetic.main.fragment_add_music1.*
import kotlinx.android.synthetic.main.fragment_add_music2.*

@Suppress("DEPRECATION")
class AddMusicFragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_music2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var playlistViewModel: PlaylistViewModel? = null

        activity?.let {
            playlistViewModel = ViewModelProviders.of(it)
                .get(PlaylistViewModel::class.java)
        }

        var playlist = playlistViewModel!!.playlist
        var musica = txtAddMusic.text.toString()
        var listMusica = listOf(musica)
        ToAddMoreMusic2.setOnClickListener {


            if (musica.isBlank()) {
                Toast.makeText( activity, "Por favor insira uma musica antes de adicionar mais",
                    Toast.LENGTH_LONG
                ).show()

            } else {

                playlistViewModel!!.playlistLiveData!!.value = listMusica
                findNavController().navigate(R.id.addMusicFragment1)
            }
        }

        ToPlaylist.setOnClickListener {
            var musica = txtAddMusic.text.toString()
            var listMusica = listOf(musica)
            if (musica.isBlank()) {
                findNavController().navigate(R.id.playlistFragment2)

            } else {
                playlistViewModel!!.playlistLiveData!!.value = listMusica
                findNavController().navigate(R.id.playlistFragment2)
            }
        }
    }
}
