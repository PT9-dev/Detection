package com.example.detection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.detection.databinding.FragmentGameOverBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GameOverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameOverFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater, R.layout.fragment_game_over, container, false)
        binding.tryAgainButton.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_gameOverFragment2_to_gameFragment)
        }

        return  binding.root
    }
}