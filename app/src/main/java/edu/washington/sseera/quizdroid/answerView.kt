package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class answerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer_view)
        var questionsLeft: Int =  0;

        val finishIntent = Intent(this, MainActivity::class.java)
        val questionIntent = Intent(this, QuestionPage::class.java)
        val nextButton = findViewById(R.id.nextButton) as Button
        val finishButton = findViewById(R.id.finishButton) as Button
        var correctAnswer = findViewById(R.id.correctAnswer) as TextView
        var selectedAnswer = findViewById(R.id.answerChoosen) as TextView
        var correctAnswerCount = findViewById(R.id.correctAnswerCount) as TextView
        var answers = getIntent().extras;
        var numberOfCorrectAnswers = 0;

        correctAnswer.setText(answers.getString("correctAnswers"))
        selectedAnswer.setText(answers.getString("selectedAnswer"))

        if(correctAnswer.text.equals(selectedAnswer.text)){
            numberOfCorrectAnswers++;
        }

        if(questionsLeft > 0 ){

            nextButton.visibility = View.VISIBLE
            finishButton.visibility = View.INVISIBLE

        }else{
            nextButton.visibility = View.INVISIBLE
            finishButton.visibility = View.VISIBLE
        }

        correctAnswerCount.setText("You have ${numberOfCorrectAnswers} out of 1 correct")

        finishButton.setOnClickListener({ view ->
            numberOfCorrectAnswers = 0;
            startActivity(finishIntent)

        })

        nextButton.setOnClickListener({ view ->
            startActivity(questionIntent)
            questionsLeft--
        })
    }
}
