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
import kotlinx.android.synthetic.main.activity_overview_fragment.*


class OverviewFragment : Fragment() {

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
        val startButton = view.findViewById(R.id.beginButton) as Button
        val topicDescription = view.findViewById(R.id.description) as TextView
        val topicName = view.findViewById(R.id.topic) as EditText
        val numberOfQuestions = view.findViewById(R.id.numberOfQuestions) as TextView
        if (getArguments() != null) {
            var description = getArguments().getString("Description");
            topicDescription.setText(description);
            topicName.setText(getArguments().getString("Topic"))
            numberOfQuestions.setText(getArguments().getString("QuestionCount"))
        }
        startButton.setOnClickListener({ view ->
            activity.onBackPressed()
        })



        return inflater!!.inflate(R.layout.activity_overview_fragment, container, false)
//        val activity = activity
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view) as RecyclerView
//        recyclerView.layoutManager = GridLayoutManager(activity, 2)
//        recyclerView.adapter = RageComicAdapter(activity)
//        return view
    }

    fun replaceFragment(someFragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_holder, someFragment)
        transaction.addToBackStack(null)
        transaction.commit()
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
