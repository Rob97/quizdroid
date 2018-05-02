package edu.washington.sseera.quizdroid

import android.content.Intent
import android.support.v4.app.Fragment
//import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_question_page.*
import android.util.Log


class FragmentHolders : AppCompatActivity() {
//    var topicStuff = intent.extras;
//    topic = topicStuff.getString("topic");
//    Log.i("FragmentHOlder",topic)
//    isOverviewFragmentLoaded = intent.extras.getBoolean("IsOverviewFragmentLoaded")
//    isQuestionFragmentLoaded = topicStuff.getBoolean("IsQuestionFragmentLoaded")
//    isAnswerFragmentLoaded = topicStuff.getBoolean("IsAnswerFragmentLoaded")
    var isOverviewFragmentLoaded = "".toBoolean()
    var isQuestionFragmentLoaded = "".toBoolean()
    var isAnswerFragmentLoaded = "".toBoolean()

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

   // val topicListIntent = Intent(this, MainActivity::class.java)



    val bundle = Bundle() as Bundle;
    var topic = ""
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
        Log.i("FragmentHoldersgetInten", intent.extras.toString())
        var topicStuff = intent.extras;
        topic = topicStuff.getString("topic");
        Log.i("FragmentHolder",topic)
         isOverviewFragmentLoaded = topicStuff.getBoolean("IsOverviewFragmentLoaded")
         isQuestionFragmentLoaded = topicStuff.getBoolean("IsQuestionFragmentLoaded")
         isAnswerFragmentLoaded = topicStuff.getBoolean("IsAnswerFragmentLoaded")

        if(topic.equals("Math")){
            Log.i("InMath",topic)
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

        if(isOverviewFragmentLoaded) {
            showOverviewFragment()
        }else {
            while (questionsLeft > 0) {
                if (isQuestionFragmentLoaded) {
                    showQuestionFragment()
                    questionsLeft--
                }
                if (isAnswerFragmentLoaded) {
                    if (selectedAnswer.equals(correctAnswers[arraySpot])) {
                        numberOfCorrectAnswers++
                    }
                    showAnswerFragment()
                    arraySpot++
                }
            }
        }






//        arraySpot = 0;
//        startActivity(topicListIntent)

    }
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(selectedAnswer: String)
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
        Log.i("PrintBundle", bundle.toString())
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = OverviewFragment()
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
//        isOverviewFragmentLoaded = true
    }

    fun showQuestionFragment(){
        bundle.putString("Question",questions[arraySpot])
        bundle.putStringArray("Answers", answers)
        bundle.putString("Topic", topic)
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = QuestionFragment()
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
//        isQuestionFragmentLoaded = true
    }
    fun showAnswerFragment(){
        bundle.putInt("CorrectAnswersCount", numberOfCorrectAnswers )
        bundle.putInt("QuestionsLeft", questionsLeft)
        bundle.putInt("QuestionCount", questions.size)
        bundle.putString("SelectedAnswer", selectedAnswer)
        bundle.putString("correctAnswer", correctAnswers[arraySpot])
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = AnswerFragment()
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
//        isAnswerFragmentLoaded = true
    }


}

