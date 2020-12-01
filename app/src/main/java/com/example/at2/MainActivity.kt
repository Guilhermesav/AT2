package com.example.at2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.at2.Model.Playlist
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ToAddMusicScreen.setOnClickListener{
            var nomeDono = editTxtName.text.toString()


            if (nomeDono.isBlank())
            {
                Toast.makeText(this,"Por favor insira seu nome",Toast.LENGTH_SHORT).show()
            }
            else
            {
                var intent = Intent(this,PlaylistActivity::class.java)
                var playlist = Playlist(nomeDono,"musicas")

                intent.putExtra("playlist",playlist)

                startActivity(intent)

            }

        }
    }
}