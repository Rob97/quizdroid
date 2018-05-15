package edu.washington.sseera.quizdroid

import android.app.Application
import android.util.Log


//THIS WAS NEVER TESTED AND WAS STILL IN DEVELOPMENT MODE WHEN SUBMITTED
data class Topic(val title : String, val shortDescription : String,
                 val longDescription : String, val questions : List<Quiz>)

data class Quiz(val question : String, val answers : Array<String>,
                val answerIndex : Int)

interface TopicRepository {
    fun getTopics() : List<Topic>
    fun getTopic(num : Int) : Topic
}


class QuizApp : Application(), TopicRepository   {



    override fun onCreate() {
        super.onCreate()
        Log.i("QuizApp", "QuizApp is working")


        val mathQuestions = arrayOf("What is one plus one?", "What is two plus two?", "What is three minus one?")
        val mathAnswers = arrayOf("1","2","3","4")
        val mathDescription = "Basic Math Questions"

        val physicsQuestions = arrayOf("Does gravity exist?", "Is Ice in gaseous state?")
        val physicsAnswers = arrayOf("Yes","No","Maybe","I don't know")
        val physicsDescription = "Basic Physics Questions"

        val marvelQuestions = arrayOf("Is Batman in Iron Man 2?", "Is Captain America Cool?")
        val marvelAnswers = arrayOf("No","Yes","Maybe","I don't know")
        val marvelDescription = "Basic Marvel Questions"

        val mathQ1 = Quiz(mathQuestions[0], mathAnswers, 1)
        val mathQ2 = Quiz(mathQuestions[1], mathAnswers, 3)
        val mathQ3 = Quiz(mathQuestions[2], mathAnswers, 1)

        val physicsQ1 = Quiz(physicsQuestions[0], physicsAnswers, 0)
        val physicsQ2 =Quiz(physicsQuestions[1], physicsAnswers, 1)


        val marvelQ1 =Quiz(marvelQuestions[0], marvelAnswers, 0)
        val marvelQ2 =Quiz(marvelQuestions[1], marvelAnswers, 2)

        val topic1Quiz = listOf(mathQ1, mathQ2, mathQ3)
        val topic2Quiz = listOf(physicsQ1, physicsQ2)
        val topic3Quiz = listOf(marvelQ1, marvelQ2)

        val topic1 = Topic("Math", mathDescription, "Questions regarding the world of Mathematics", topic1Quiz)
        val topic2 = Topic("Physics", physicsDescription, "Questions regarding the world of Physics", topic2Quiz)
        val topic3 = Topic("Marvel Super Heroes", marvelDescription, "Questions regarding the world of Marvel", topic3Quiz)

       var topics = listOf(topic1, topic2, topic3);


    }


}


