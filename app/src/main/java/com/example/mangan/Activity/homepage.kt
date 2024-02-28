package com.example.mangan.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mangan.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView



class homepage : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        recyclerView = findViewById(R.id.recyclerview)
        adapter = MyAdapter()
        recyclerView.adapter = adapter

        val dataSource = ArrayList<String>()
        dataSource.add("Item 1")
        dataSource.add("Item 2")
        dataSource.add("Item 3")
        dataSource.add("Item 4")
        dataSource.add("Item 5")
        dataSource.add("Item 6")

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter.data = dataSource
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = MyAdapter()

    }

    class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        var data = ArrayList<String>()

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.itemView.findViewById<TextView>(R.id.textView).text = data[position]
        }

        override fun getItemCount(): Int {
            return data.size
        }
    }
}
