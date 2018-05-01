package edu.washington.sseera.quizdroid

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_topic_overview.*


class AnswerFragment : Fragment() {

    companion object {

        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }
    val TAG = "OverviewFragment"
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
//        val startButton = findViewById(R.id.beginButton) as Button
//        val topicDescription = findViewById(R.id.description) as TextView
//        val topicName = findViewById(R.id.topic) as EditText

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
//        val finishIntent = Intent(this, MainActivity::class.java)
//        val questionIntent = Intent(this, QuestionPage::class.java)
        val nextButton = view.findViewById(R.id.nextButton) as Button
        val finishButton = view.findViewById(R.id.finishButton) as Button
        var correctAnswerText = view.findViewById(R.id.correctAnswer) as TextView
        var selectedAnswerText = view.findViewById(R.id.answerChoosen) as TextView
        var correctAnswerCount = view.findViewById(R.id.correctAnswerCount) as TextView
        var selectedAnswer = getArguments().getString("SelectedAnswer");
        var numberOfCorrectAnswers = getArguments().getInt("CorrectAnswersCount");
        var correctAnswer = getArguments().getString("CorrectAnswer")
        var questionsLeft = getArguments().getInt("QuestionCount")
        var questionsCount = getArguments().getInt("QuestionCount")



        correctAnswerText.setText(correctAnswer)
        selectedAnswerText.setText(selectedAnswer)
        correctAnswerCount.setText(numberOfCorrectAnswers)

//        if(correctAnswer.equals(selectedAnswer)){
//            numberOfCorrectAnswers++;
//        }

        if(questionsLeft > 0 ){

            nextButton.visibility = View.VISIBLE
            finishButton.visibility = View.INVISIBLE

        }else{
            nextButton.visibility = View.INVISIBLE
            finishButton.visibility = View.VISIBLE
        }

        correctAnswerCount.setText("You have ${numberOfCorrectAnswers} out of ${questionsCount} correct")

        finishButton.setOnClickListener({ view ->
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
           // startActivity(finishIntent)

        })

        nextButton.setOnClickListener({ view ->

                activity.onBackPressed()

        })

        return inflater!!.inflate(R.layout.activity_answer_fragment, container, false)
//
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }

}
