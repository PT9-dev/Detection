package com.example.detection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.detection.databinding.FragmentGameWonBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GameWonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameWonFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.action_gameWonFragment_to_gameFragment)
        }
        return binding.root
    }


}