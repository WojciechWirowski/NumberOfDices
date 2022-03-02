package com.easv.cse27_b.numberofdices

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.easv.cse27_b.numberofdices.Models.DiceRecord
import com.easv.cse27_b.numberofdices.Models.History
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val random = Random()
    private var scores: MutableList<Int> = ArrayList()
    private var history: History = History(name = null, ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRoll.setOnClickListener{diceRoll()}
        btnHistory.setOnClickListener{history()}
    }

    private fun history(){
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("history", history)
        startActivity(intent)
    }

    private fun diceRoll(){

        val value = etName.text
        history.name = value.toString()
        val int = etDices.text.toString().toInt()

        for (i in 1..int){
            scores += random.nextInt(6)+1
        }
        history.list.addAll(scores)
        displayResult()
        println(history.name + history.list.toString())
    }

    private fun displayResult(){
        val arrayAdapter: ArrayAdapter<Int> = ArrayAdapter(this, android.R.layout.simple_list_item_1, scores)

        lvResults.adapter = arrayAdapter
    }
}

