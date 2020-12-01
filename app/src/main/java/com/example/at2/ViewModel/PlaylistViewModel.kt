package com.example.at2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.at2.Model.Playlist


class PlaylistViewModel : ViewModel(){
    var playlist: Playlist? = null
    var playlistLiveData: MutableLiveData<List<String>>? = null
}