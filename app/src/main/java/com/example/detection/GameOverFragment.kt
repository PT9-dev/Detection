package com.example.detection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.createNavigateOnClickListener
import com.example.detection.databinding.FragmentGameOverBinding



class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater, R.layout.fragment_game_over, container, false)
        binding.tryAgainButton.setOnClickListener (
            createNavigateOnClickListener(R.id.action_gameOverFragment2_to_gameFragment)
        )
        (activity as AppCompatActivity).supportActionBar?.title = "Game Over"

        return  binding.root
    }
}