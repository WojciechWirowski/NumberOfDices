package com.easv.cse27_b.numberofdices

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.easv.cse27_b.numberofdices.Models.BigHistory
import com.easv.cse27_b.numberofdices.Models.History
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private var records: MutableList<History> = ArrayList()
    private var bigHistory: BigHistory = MainActivity.bigHistory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btnBack.setOnClickListener{back()}
        btnClear.setOnClickListener{clean()}
        setList()
        //gatherInfo()
    }

    private fun back(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    private fun clean(){
        bigHistory.list?.clear()
        setList()
    }

//    private fun gatherInfo(){
//        val history = intent.getParcelableExtra<History>("history")
//        if (history != null) {
//            records.add(history)
//            println(history.name + history.list)
//        }
//        setList()
//    }

    private fun setList(){
        bigHistory.list?.addAll(records)
        val adapter = HistoryAdapter(this, bigHistory.list as ArrayList<History>)
        lvResultsSecond.adapter = adapter
    }
}

internal class HistoryAdapter(context: Context, private val history: ArrayList<History>): ArrayAdapter<History>(context,0,history){
    @SuppressLint("InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var v1: View? = convertView
        if (v1 == null){
            val mInflater = LayoutInflater.from(context)
            v1 = mInflater.inflate(R.layout.history_cell, null)
        }

        val resView: View = v1!!
        val f = history[position]

        val nameView = resView.findViewById<TextView>(R.id.tvName)
        val listView = resView.findViewById<TextView>(R.id.tvScore)

        nameView.text = f.name
        listView.text = f.list.toString()


        return resView
    }
}