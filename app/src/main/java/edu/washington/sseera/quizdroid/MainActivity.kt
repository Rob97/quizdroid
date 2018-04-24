package edu.washington.sseera.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.util.Log
import android.content.Intent


class MainActivity : AppCompatActivity() {
  val classes = arrayOf("Math", "Physics", "Marvel Super Heroes")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<ListView>(R.id.listView)
        val topicOverviewIntent = Intent(this, TopicOverview::class.java)
        val mathQuestionsAndAnswers = arrayOf(mapOf("question" to "What is one plus one?","answers" to arrayListOf<String>("1","2","3","4"), "correctAnswer" to "4"))
        val mathQuestions = arrayOf("What is one plus one?")
        val mathAnswers = arrayOf("1","2","3","4")
        val mathCorrectAnswers = arrayOf("4")
        val mathDescription = "Basic Math Questions"
        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, classes)
        listView.adapter = adapter

        listView.setOnItemClickListener ({parent,v,position, id ->
            Log.i("MainActivity", "This is the parent var ${parent.toString()}")
            Log.i("MainActivity", "This is the v var ${v.toString()}")
            Log.i("MainActivity", "This is the position var ${position.toString()}")
            Log.i("MainActivity", "This is the id var ${id.toString()}")
            Log.i("MainActivity", "You've selected ${classes[position]}")
            if(classes[position].equals("Math")){
                intent.putExtra("questionsAndAnswers", mathQuestionsAndAnswers);
                intent.putExtra("questions", mathQuestions);
                intent.putExtra("answers", mathAnswers);
                intent.putExtra("correctAnswers", mathCorrectAnswers);
                intent.putExtra("topic","${classes[position]}" )
                intent.putExtra("description", mathDescription)
                startActivity(topicOverviewIntent)


            }
            if(classes[position].equals("Physics")){
                startActivity(topicOverviewIntent)

            }
            if(classes[position].equals("Marvel Super Heroes")){
                startActivity(topicOverviewIntent)

            }
        })

    }
}
