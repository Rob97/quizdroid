package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class answerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_view)
        var questionsLeft: Int =  0;

        val finishIntent = Intent(this, TopicOverview::class.java)
        val questionIntent = Intent(this, QuestionPage::class.java)
        val nextButton = findViewById(R.id.nextButton) as Button
        val finishButton = findViewById(R.id.finishButton) as Button


        if(questionsLeft > 0 ){

            nextButton.visibility = View.VISIBLE
            finishButton.visibility = View.INVISIBLE

        }else{
            nextButton.visibility = View.INVISIBLE
            finishButton.visibility = View.VISIBLE
        }

        finishButton.setOnClickListener({ view ->
            questionsLeft = 1
            startActivity(finishIntent)

        })

        nextButton.setOnClickListener({ view ->
            startActivity(questionIntent)
            questionsLeft--
        })
    }
}
