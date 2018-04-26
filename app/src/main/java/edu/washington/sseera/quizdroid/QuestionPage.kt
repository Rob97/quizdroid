package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.util.Log
import android.widget.RadioGroup


class QuestionPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_page)

        val answerIntent = Intent(this, answerView::class.java)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val question = findViewById<TextView>(R.id.question)
        val answer1 = findViewById<RadioButton>(R.id.answer1)
        val answer2 = findViewById<RadioButton>(R.id.answer2)
        val answer3 = findViewById<RadioButton>(R.id.answer3)
        val answer4 = findViewById<RadioButton>(R.id.answer4)
        val radioGroup = findViewById<RadioGroup>(R.id.answers)
        var selectedAnswer: CharSequence? = null


        var qandA = intent.extras
        var answers = qandA.getStringArray("answers")
        var correctAnswer =  qandA.getString("correctAnswers")

        Log.i("Question Page", qandA.toString())
        var questions = qandA.getString("questions")
        question.text = questions


        if(answers.size == 4) {
            answer1.text = answers[0]
            answer2.text = answers[1]
            answer3.text = answers[2]
            answer4.text = answers[3]
        }
        submitButton.visibility = View.INVISIBLE
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            submitButton.visibility = View.VISIBLE
            if(answer1.isChecked){
                Log.i("QuestionsPage", "ANSWER ONE SELECTED")
                selectedAnswer = answers[0].toString()
                Log.i("QuestionsPage", selectedAnswer.toString())

            }
            if(answer2.isChecked){
                selectedAnswer = answers[1].toString()

            }
            if(answer3.isChecked){
                selectedAnswer = answers[2].toString()

            }
            if(answer4.isChecked){
                selectedAnswer = answers[3].toString()

            }
        })


            submitButton.setOnClickListener({ view ->

                    answerIntent.putExtra("selectedAnswer", selectedAnswer)

                answerIntent.putExtra("correctAnswers", correctAnswer)
                startActivity(answerIntent)
            })





    }
}
