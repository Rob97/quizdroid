package edu.washington.sseera.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.util.Log
import android.content.Intent


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val listView = findViewById<ListView>(R.id.listView)

        val intent = Intent(this, FragmentHolders::class.java)
       // val mathQuestionsAndAnswers = arrayListOf(mapOf("question" to "What is one plus one?","answers" to arrayListOf<String>("1","2","3","4"), "correctAnswer" to "4"))

        val app = QuizApp
        val topics = app.topics
        val topicsList = listOf(topics[0].title, topics[1].title, topics[2].title)

        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, topicsList)
        listView.adapter = adapter

            listView.setOnItemClickListener({ parent, v, position, id ->
                var value = listView.getItemAtPosition(position).toString()
                Log.i("Main Activity", value)
                intent.putExtra("topic",value)

                intent.putExtra("IsQuestionFragmentLoaded", true)
                intent.putExtra("IsAnswerFragmentLoaded", false)
                intent.putExtra("IsOverviewFragmentLoaded", false)

                startActivity(intent)
            })




    }



}
