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

//        if (savedInstanceState == null) {
//            supportFragmentManager
//                    .beginTransaction()
//                    .add(R.id.ConstraintLayout, OverviewFragment.newInstance(), "rageComicList")
//                    .commit()
//        }


        val listView = findViewById<ListView>(R.id.listView)
       // val topicOverviewIntent = Intent(this, TopicOverview::class.java)
        val intent = Intent(this, FragmentHolders::class.java)
       // val mathQuestionsAndAnswers = arrayListOf(mapOf("question" to "What is one plus one?","answers" to arrayListOf<String>("1","2","3","4"), "correctAnswer" to "4"))


        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, classes)
        listView.adapter = adapter

//        listView.setOnItemClickListener ({parent,v,position, id ->
//            Log.i("MainActivity", "This is the parent var ${parent.toString()}")
//            Log.i("MainActivity", "This is the v var ${v.toString()}")
//            Log.i("MainActivity", "This is the position var ${position.toString()}")
//            Log.i("MainActivity", "This is the id var ${id.toString()}")
//            Log.i("MainActivity", "You've selected ${classes[position]}")
//            if(classes[position].equals("Math")){
//              //  intent.putExtra("questionsAndAnswers", mathQuestionsAndAnswers);
//                intent.putExtra("questions", mathQuestions[0]);
//                intent.putExtra("answers", mathAnswers);
//                intent.putExtra("correctAnswers", mathCorrectAnswers[0]);
//                intent.putExtra("topic","${classes[position]}" )
//                intent.putExtra("description", mathDescription)
//                startActivity(topicOverviewIntent)
//            }

            listView.setOnItemClickListener({ parent, v, position, id ->

                intent.putExtra("topic", listView.getItemAtPosition(position).toString())
//                intent.putExtra("questions", mathQuestions[0]);
//                intent.putExtra("answers", mathAnswers);
//                intent.putExtra("correctAnswers", mathCorrectAnswers[0]);
//                intent.putExtra("description", mathDescription)
                startActivity(intent)



            if(classes[position].equals("Physics")){


                intent.putExtra("topic", listView.getItemAtPosition(position).toString())
//                intent.putExtra("questions", physicsQuestions[0]);
//                intent.putExtra("answers", physicsAnswers);
//                intent.putExtra("correctAnswers", physicsCorrectAnswers[0]);
//                intent.putExtra("description", physicsDescription)
                startActivity(intent)

            }
            if(classes[position].equals("Marvel Super Heroes")){


                intent.putExtra("topic", listView.getItemAtPosition(position).toString())
//                intent.putExtra("questions", marvelQuestions[0]);
//                intent.putExtra("answers", marvelAnswers);
//                intent.putExtra("correctAnswers", marvelCorrectAnswers[0]);
//                intent.putExtra("description", marvelDescription)
                startActivity(intent)

            }
        })

    }



}
