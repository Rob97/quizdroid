package edu.washington.sseera.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
class MainActivity : AppCompatActivity() {
  val classes = arrayOf("Math, Physics, Marvel Super Heroes")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val listView = findViewById<ListView>(R.id.listView)

        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, classes)
        listView.adapter = adapter
    }
}
