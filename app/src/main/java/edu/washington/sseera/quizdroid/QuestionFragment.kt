package edu.washington.sseera.quizdroid

//import android.app.Fragment
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
import android.widget.*
import edu.washington.sseera.quizdroid.QuestionFragment.OnFragmentInteractionListener




class QuestionFragment : Fragment() {

    companion object {

        fun newInstance(): OverviewFragment {
            return OverviewFragment()
        }
    }
    val TAG = "OverviewFragment"

    //Initializing callback
    var mCallback: OnFragmentInteractionListener? = null

    // Container Activity must implement this interface
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(selectedAnswer: String)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
        try {
            mCallback = activity as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener")
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        val view1 = inflater?.inflate(R.layout.activity_question_fragment, container, false) as View
        val submitButton = view1!!.findViewById<Button>(R.id.submitButton)
        val question = view1?.findViewById<TextView>(R.id.question)
        val answer1 = view1?.findViewById<RadioButton>(R.id.answer1)
        val answer2 = view1?.findViewById<RadioButton>(R.id.answer2)
        val answer3 = view1?.findViewById<RadioButton>(R.id.answer3)
        val answer4 = view1?.findViewById<RadioButton>(R.id.answer4)
        val radioGroup = view1?.findViewById<RadioGroup>(R.id.answers)
        var selectedAnswer: CharSequence? = null

        if (getArguments() != null) {

            var answers = getArguments()!!.getStringArray("Answers");
            Log.i("QuestionsPage", answers[0])
            question?.setText(getArguments()?.getString("Question"));
            answer1?.setText(answers[0])
            Log.i("Answer1", answer1.text.toString())
            answer2?.setText(answers[1])
            answer3?.setText(answers[2])
            answer4?.setText(answers[3])

        }

        radioGroup?.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            submitButton!!.visibility = View.VISIBLE
            if(answer1!!.isChecked){
                Log.i("QuestionsPage", "ANSWER ONE SELECTED")
                selectedAnswer = answer1.text.toString()
                Log.i("QuestionsPage", selectedAnswer.toString())


            }
            if(answer2!!.isChecked){
                selectedAnswer = answer2.text.toString()

            }
            if(answer3!!.isChecked){
                selectedAnswer = answer3.text.toString()

            }
            if(answer4!!.isChecked){
                selectedAnswer = answer4.text.toString()

            }
//            var mCallback: OnFragmentInteractionListener? = null
//            if (mCallback != null && selectedAnswer != null) {
//               mCallback.onFragmentInteraction(selectedAnswer.toString());
//                  QuestionFragment.OnFragmentInteractionListener?.let{
//            }
        })

        submitButton?.setOnClickListener({ view ->
            val intent = Intent(activity, FragmentHolders::class.java)
            intent.putExtra("SelectedAnswer", selectedAnswer);
            intent.putExtra("IsQuestionFragmentLoaded", false)
            intent.putExtra("IsAnswerFragmentLoaded", true)
            intent.putExtra("IsOverviewFragmentLoaded", false)

            activity?.onBackPressed()
        })

        return inflater!!.inflate(R.layout.activity_question_fragment, container, false)
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

        val submitButton = view?.findViewById<Button>(R.id.submitButton)
        val question = view?.findViewById<TextView>(R.id.question)
        val answer1 = view?.findViewById<RadioButton>(R.id.answer1)
        val answer2 = view?.findViewById<RadioButton>(R.id.answer2)
        val answer3 = view?.findViewById<RadioButton>(R.id.answer3)
        val answer4 = view?.findViewById<RadioButton>(R.id.answer4)
        val radioGroup = view?.findViewById<RadioGroup>(R.id.answers)
        var selectedAnswer: CharSequence? = null


        if (getArguments() != null) {

            var answers = getArguments()?.getStringArray("Answers");
            question?.setText(getArguments()?.getString("Question"));
            answer1?.setText(answers!![0])
            answer2?.setText(answers!![1])
            answer3?.setText(answers!![2])
            answer4?.setText(answers!![3])

        }
        submitButton!!.visibility = View.INVISIBLE
        radioGroup?.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            submitButton!!.visibility = View.VISIBLE
            if(answer1!!.isChecked){
                Log.i("QuestionsPage", "ANSWER ONE SELECTED")
                selectedAnswer = answer1.toString()
                Log.i("QuestionsPage", selectedAnswer.toString())

            }
            if(answer2!!.isChecked){
                selectedAnswer = answer2.toString()

            }
            if(answer3!!.isChecked){
                selectedAnswer = answer3.toString()

            }
            if(answer4!!.isChecked){
                selectedAnswer = answer4.toString()

            }

        })

        submitButton?.setOnClickListener({ view ->

//            var mCallback: OnFragmentInteractionListener? = null
//            if (mCallback != null && selectedAnswer != null) {
//                mCallback.onFragmentInteraction(selectedAnswer.toString());
                //  QuestionFragment.OnFragmentInteractionListener?.let{
//            }
            val intent = Intent(activity, FragmentHolders::class.java)
            intent.putExtra("SelectedAnswer", selectedAnswer);
            intent.putExtra("IsQuestionFragmentLoaded", false)
            intent.putExtra("IsAnswerFragmentLoaded", true)
            intent.putExtra("IsOverviewFragmentLoaded", false)
            activity?.onBackPressed()
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
