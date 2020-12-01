@file:Suppress("DEPRECATION")

package com.example.at2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.at2.Model.Playlist
import com.example.at2.ViewModel.PlaylistViewModel

class PlaylistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlist)

        var playlist = intent.getSerializableExtra("playlist") as Playlist

        var playlistViewModel = ViewModelProviders.of(this).get(PlaylistViewModel::class.java)

        playlistViewModel.playlist = Playlist(playlist.dono, playlist.musicasFavoritas)

    }
}