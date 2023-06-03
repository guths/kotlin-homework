package com.example.aula_extra_tarefa

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Button

class MusicFragment : Fragment() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_music, container, false)
        val btnPlay = rootView.findViewById<Button>(R.id.btnPlay)
        val btnPause = rootView.findViewById<Button>(R.id.btnPause)
        val btnStop = rootView.findViewById<Button>(R.id.btnStop)

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audio)

        btnPlay.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        btnPause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }

        btnStop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.prepare()
            }
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer.release()
    }
}