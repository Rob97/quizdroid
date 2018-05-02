package edu.washington.sseera.quizdroid




import kotlinx.android.synthetic.main.activity_question_page.*


import android.support.v4.app.Fragment
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
import kotlinx.android.synthetic.main.activity_overview_fragment.*


class OverviewFragment : Fragment() {

    companion object {

        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }
    val TAG = "OverviewFragment"


    val bundle = Bundle() as Bundle;
    var topic = ""
    var questions = arrayOf("")
    var answers = arrayOf("")
    var correctAnswers =arrayOf("")
    var description = ""
    var questionsLeft = questions.size
    var arraySpot = 0
    var selectedAnswer = ""
    var numberOfCorrectAnswers = 0
    var questionCount = 1

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        val view1 = inflater?.inflate(R.layout.activity_overview_fragment, container, false) as View


        val startButton = view1.findViewById<Button>(R.id.beginButton) as Button
        val topicDescription = view1.findViewById(R.id.description) as TextView
        val topicName = view1.findViewById(R.id.topic) as EditText
        val numberOfQuestions = view1.findViewById(R.id.numberOfQuestions) as TextView
        if (getArguments() != null) {

             topic = getArguments()!!.getString("Topic")
             questions = getArguments()!!.getStringArray("Questions")
             answers = getArguments()!!.getStringArray("Answers")
             correctAnswers = getArguments()!!.getStringArray("CorrectAnswers")
             description = getArguments()!!.getString("Description");
             questionsLeft = questions.size
             arraySpot = 0
             selectedAnswer = getArguments()!!.getString("SelectedAnswer");
             numberOfCorrectAnswers = getArguments()!!.getInt("CorrectAnswersCount");
             questionCount = questions.size







            topicDescription.setText(description);
            Log.i("Tag info Description", topicDescription.text.toString())
            topicName.setText(getArguments()?.getString("Topic"))
            numberOfQuestions.setText(questionCount.toString())
        }
        startButton.setOnClickListener({ view ->


            bundle.putString("Description", description)
            bundle.putString("Topic", topic)
            bundle.putStringArray("Questions",questions)
            bundle.putStringArray("Answers", answers)
            bundle.putString("Topic", topic)
            bundle.putInt("CorrectAnswersCount", numberOfCorrectAnswers )
            bundle.putInt("QuestionsLeft", questionsLeft)
            bundle.putString("SelectedAnswer", selectedAnswer)
            bundle.putStringArray("CorrectAnswers", correctAnswers)
            bundle.putInt("ArraySpot",arraySpot)


            val transaction = fragmentManager!!.beginTransaction()
            val fragment = QuestionFragment()
            fragment.arguments = bundle
            transaction.replace(R.id.fragment_holder, fragment)
            transaction.addToBackStack(null)
            transaction.commit()

//            val intent = Intent(activity, FragmentHolders::class.java)
//
//            intent.putExtra("IsQuestionFragmentLoaded", true)
//            intent.putExtra("IsAnswerFragmentLoaded", false)
//            intent.putExtra("IsOverviewFragmentLoaded", false)
//
//            startActivity(intent)
//            activity?.onBackPressed()
        })



        return inflater?.inflate(R.layout.activity_overview_fragment, container, false)
//        val activity = activity
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view) as RecyclerView
//        recyclerView.layoutManager = GridLayoutManager(activity, 2)
//        recyclerView.adapter = RageComicAdapter(activity)
//        return view
    }

    fun replaceFragment(someFragment: Fragment) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_holder, someFragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
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

        val startButton = view!!.findViewById<Button>(R.id.beginButton) as Button
        val topicDescription = view!!.findViewById(R.id.description) as TextView
        val topicName = view!!.findViewById(R.id.topic) as EditText
        val numberOfQuestions = view!!.findViewById(R.id.numberOfQuestions) as TextView
       if (getArguments() != null) {

           topic = getArguments()!!.getString("Topic")
           questions = getArguments()!!.getStringArray("Questions")
           answers = getArguments()!!.getStringArray("Answers")
           correctAnswers = getArguments()!!.getStringArray("CorrectAnswers")
           description = getArguments()!!.getString("Description");
           questionsLeft = questions.size
           arraySpot = 0
           selectedAnswer = getArguments()!!.getString("SelectedAnswer");
           numberOfCorrectAnswers = getArguments()!!.getInt("CorrectAnswersCount");
           questionCount = questions.size

//           Log.i("RECIVED DESCPRITION", description
//            )
            topicDescription.setText(description);
            //Log.i("Tag info Description", topicDescription.text.toString())
            topicName.setText(topic)
            numberOfQuestions.setText(questionCount.toString())
        }

        startButton.setOnClickListener({ view ->


            bundle.putString("Description", description)
            bundle.putString("Topic", topic)
            bundle.putStringArray("Questions",questions)
            bundle.putStringArray("Answers", answers)
            bundle.putString("Topic", topic)
            bundle.putInt("CorrectAnswersCount", numberOfCorrectAnswers )
            Log.i("QuestionLeft OFrag", questionsLeft.toString())
            bundle.putInt("QuestionsLeft", questionsLeft)
            bundle.putString("SelectedAnswer", selectedAnswer)
            bundle.putStringArray("CorrectAnswers", correctAnswers)
            bundle.putInt("ArraySpot",arraySpot)


            val transaction = fragmentManager!!.beginTransaction()
            val fragment = QuestionFragment()
            fragment.arguments = bundle
            transaction.replace(R.id.fragment_holder, fragment)
            transaction.addToBackStack(null)
            transaction.commit()


//            val intent = Intent(activity, FragmentHolders::class.java)
//
//            intent.putExtra("IsQuestionFragmentLoaded", true)
//            intent.putExtra("IsAnswerFragmentLoaded", false)
//            intent.putExtra("IsOverviewFragmentLoaded", false)
//            activity?.onBackPressed()

        })
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
