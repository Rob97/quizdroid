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
        val topicOverviewInent = Intent(this, TopicOverview::class.java)

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
                startActivity(topicOverviewInent)


            }
            if(classes[position].equals("Physics")){
                startActivity(topicOverviewInent)

            }
            if(classes[position].equals("Marvel Super Heroes")){
                startActivity(topicOverviewInent)

            }
        })

    }
}
