package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView


class QuestionPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_page)

        val answerIntent = Intent(this, answerView::class.java)
        val submitButton = findViewById(R.id.submitButton) as Button
        val question = findViewById(R.id.question) as TextView
        val answer1 = findViewById(R.id.answer1) as RadioButton
        val answer2 = findViewById(R.id.answer2) as RadioButton
        val answer3 = findViewById(R.id.answer3) as RadioButton
        val answer4 = findViewById(R.id.answer4) as RadioButton
        var selectedAnswer: RadioButton? = null;
        var correctAnswer = "";

        var qandA = getIntent().getExtras();

        question.setText(qandA.getString("questions"))
        correctAnswer = qandA.getString("correctAnswers")
        answer1.setText(qandA.getString("answers")[0].toString())
        answer2.setText(qandA.getString("answers")[1].toString())
        answer3.setText(qandA.getString("answers")[2].toString())
        answer4.setText(qandA.getString("answers")[3].toString())

        if(answer1.isActivated){
            selectedAnswer = answer1;
        }
        if(answer2.isActivated){
            selectedAnswer = answer2;
        }
        if(answer3.isActivated){
            selectedAnswer = answer3;
        }
        if(answer4.isActivated){
            selectedAnswer = answer4;
        }

        if(selectedAnswer != null){
            submitButton.visibility = View.VISIBLE
            submitButton.setOnClickListener({ view ->
                intent.putExtra("selectedAnswer", selectedAnswer.text);
                intent.putExtra("correctAnswers", correctAnswer);
                startActivity(answerIntent)
            })

        }else{
            submitButton.visibility = View.INVISIBLE
        }




    }
}
