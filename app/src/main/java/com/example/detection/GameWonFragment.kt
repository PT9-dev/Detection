package com.example.detection

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.detection.databinding.FragmentGameWonBinding



class GameWonFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false)

        setHasOptionsMenu(true)

        binding.nextMatchButton.setOnClickListener {view:View->
            view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }


        Toast.makeText(context, "You can share your success :)", Toast.LENGTH_LONG).show()
        (activity as AppCompatActivity).supportActionBar?.title = "Game Won"
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.win_share_menu, menu)

        if(null == startShareIntent().resolveActivity(requireActivity().packageManager))
            menu.findItem(R.id.share).isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareSuccess() {
        startActivity(startShareIntent())
    }

    private fun startShareIntent(): Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())

        return ShareCompat.IntentBuilder.from(requireActivity())
            .setText(getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
            .setType("text/plain")
            .intent
    }
}