package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_page.*

class FragmentHolders : AppCompatActivity() {

    var isOverviewFragmentLoaded = true
    var isQuestionFragmentLoaded = true
    var isAnswerFragmentLoaded = true

    val mathQuestions = arrayOf("What is one plus one?", "What is two plus two?", "What is three minus one?")
    val mathAnswers = arrayOf("1","2","3","4")
    val mathCorrectAnswers = arrayOf("2", "4", "2")
    val mathDescription = "Basic Math Questions"

    val physicsQuestions = arrayOf("Does gravity exist?", "Is Ice in gaseous state?")
    val physicsAnswers = arrayOf("Yes","No","Maybe","I don't know")
    val physicsCorrectAnswers = arrayOf("Yes", "No")
    val physicsDescription = "Basic Physics Questions"

    val marvelQuestions = arrayOf("Is Batman in Iron Man 2?", "Is Captain America Cool?")
    val marvelAnswers = arrayOf("No","Yes","Maybe","I don't know")
    val marvelCorrectAnswers = arrayOf("No", "Maybe")
    val marvelDescription = "Basic Marvel Questions"

    val topicListIntent = Intent(this, MainActivity::class.java)

    var topicStuff = getIntent().extras;
    var topic = topicStuff.getString("description");

    val bundle = Bundle() as Bundle;

    var questions = arrayOf("")
    var answers = arrayOf("")
    var correctAnswers =arrayOf("")
    var description = ""
    var questionsLeft = 0
    var arraySpot = 0
    var selectedAnswer = ""
    var numberOfCorrectAnswers = 0

    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_holders)

        if(topic.equals("Math")){
            questions = mathQuestions
            answers = mathAnswers
            correctAnswers = mathCorrectAnswers
            description = mathDescription
            questionsLeft = mathQuestions.size
        }else if (topic.equals("Physics")){
            questions = physicsQuestions
            answers = physicsAnswers
            correctAnswers = physicsCorrectAnswers
            description = physicsDescription
            questionsLeft = physicsQuestions.size
        }else{
            questions = marvelQuestions
            answers = marvelAnswers
            correctAnswers = marvelCorrectAnswers
            description = marvelDescription
            questionsLeft = marvelQuestions.size
        }

        showOverviewFragment()

        while(questionsLeft > 0) {
                showQuestionFragment()
                questionsLeft--
            if(selectedAnswer.equals(correctAnswers[arraySpot])){
                numberOfCorrectAnswers++
            }
                showAnswerFragment()
                arraySpot++

        }
        arraySpot = 0;
        startActivity(topicListIntent)

    }

    fun onFragmentInteraction(uri: String) {
        selectedAnswer = uri
    }
//    fun onFragmentInteractionCorrectAnswers(uri: Int) {
//        numberOfCorrectAnswers = uri
//    }
//    fun onFragmentInteraction(uri: String) {
//        selectedAnswer = uri
//    }

    fun showOverviewFragment(){
        bundle.putString("QuestionCount",questions.size.toString())
        bundle.putString("Description", description)
        bundle.putString("Topic", topic)
        val transaction = manager.beginTransaction()
        val fragment = OverviewFragment() as Fragment
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        //isOverviewFragmentLoaded = true
    }

    fun showQuestionFragment(){
        bundle.putString("Question",questions[arraySpot])
        bundle.putStringArray("Answers", answers)
        bundle.putString("Topic", topic)
        val transaction = manager.beginTransaction()
        val fragment = QuestionFragment() as Fragment
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
       // isQuestionFragmentLoaded = true
    }
    fun showAnswerFragment(){
        bundle.putInt("CorrectAnswersCount", numberOfCorrectAnswers )
        bundle.putInt("QuestionsLeft", questionsLeft)
        bundle.putInt("QuestionCount", questions.size)
        bundle.putString("SelectedAnswer", selectedAnswer)
        bundle.putString("correctAnswer", correctAnswers[arraySpot])
        val transaction = manager.beginTransaction()
        val fragment = AnswerFragment() as Fragment
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        //isAnswerFragmentLoaded = true
    }


}

