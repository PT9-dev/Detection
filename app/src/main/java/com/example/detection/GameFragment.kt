package com.example.detection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.detection.databinding.FragmentGameBinding


/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    data class Question(var text:String, var answers: List<String>)


        private val questions = mutableListOf(
        Question("What is the color of the jetpack?", listOf("Green", "Blue", "Red", "White")),
        Question(text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")),
        Question(text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")),
        Question(text = "Inflate layout in fragments?",
            answers = listOf("onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout")),
        Question(text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")),
        Question(text = "Android vector format?",
            answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
        Question(text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
        Question(text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
        Question(text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
        )

    lateinit var binding: FragmentGameBinding
    lateinit var currentQuestion: Question
    lateinit var  answers: MutableList<String>
    private var questionIndex: Int = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)


        setFirstQuestion()

        binding.game = this

        binding.submitButton.setOnClickListener { view: View ->
            val passed = submitLogic()
            if (passed == 1)
            view.findNavController().navigate(R.id.action_gameFragment_to_gameWonFragment)
            else if(passed == 0)
            view.findNavController().navigate(R.id.action_gameFragment_to_gameOverFragment2)
            else
                binding.invalidateAll()

        }
        return binding.root
    }

    private fun submitLogic(): Int {
        questionIndex++
        val checkedId = binding.questionRadioGroup.checkedRadioButtonId
        val answerIndex: Int = when(checkedId){
            R.id.firstAnsRadioButton -> 0
            R.id.secondAnsRadioButton -> 1
            R.id.thirdAnsRadioButton -> 2
            R.id.forthAnsRadioButton -> 3
            else -> -1
        }

        // If no answer is given or an incorrect answer is given
        // GameOver
        if (answerIndex == -1 || answers[answerIndex] != currentQuestion.answers[0])
            return 0

        if (questionIndex >= numQuestions) return 1

        setQuestions(questionIndex)
        return -1

    }

    // randomize question and set the first question

    private fun setFirstQuestion() {
        questions.shuffle()
        questionIndex = 0
        setQuestions(questionIndex)
    }

    private fun setQuestions(index: Int){
        currentQuestion = questions[index]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(
            R.string.title_android_trivia_question, questionIndex+1, numQuestions)

    }
}