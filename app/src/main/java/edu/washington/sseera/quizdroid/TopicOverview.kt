package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.R.attr.key



class TopicOverview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topic_overview)
        val questionIntent = Intent(this, QuestionPage::class.java)
        val startButton = findViewById(R.id.beginButton) as Button
        val topicDescription = findViewById(R.id.description) as TextView
        val topicName = findViewById(R.id.topic) as EditText
       // val numberOfQuestions = findViewById(R.id.numberOfQuestions) as TextView
        var questions = ""
        var answers = arrayOf("")
        var correctAnswers =""

        var topicStuff = getIntent().extras;
        println("topicStuff  " + topicStuff)
        if (topicStuff != null) {
            topicDescription.setText(topicStuff.getString("description"));
            topicName.setText(topicStuff.getString("topic"))
//            numberOfQuestions.setText(topicStuff.getString("questions").length.toString())
            questions =  topicStuff.getString("questions")
            answers = topicStuff.getStringArray("answers")
             // = topicStuff.getStringArrayList("answers")
            correctAnswers = topicStuff.getString("correctAnswers")

        }
            startButton.setOnClickListener({ view ->
//                val b = Bundle()
//                b.putStringArrayList("answers", answers)

                intent.putExtra("questions", questions);
                intent.putExtra("answers", answers);
                intent.putExtra("correctAnswers", correctAnswers);
            startActivity(questionIntent)
        })
    }




}
