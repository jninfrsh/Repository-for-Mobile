package com.example.mangan.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mangan.R
import androidx.recyclerview.widget.RecyclerView
import com.example.mangan.domain.Categorydomain

class homepage2 : AppCompatActivity() {
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewCategoryList: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage2)

        recyclerViewCategory();
    }

    private fun recyclerViewCategory() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCategoryList=findViewById(R.id.recyclerview);
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerViewCategoryList.layoutManager = linearLayoutManager
        TODO("Not yet implemented")

        class CategoryDomain(val title: String, val pic: String)
        val category: ArrayList<CategoryDomain> = ArrayList()
        category.add(CategoryDomain(title = "Adobo", pic = "ad"))
        category.add(CategoryDomain(title = "Beef Steak", pic = "bs"))
        category.add(CategoryDomain(title = "Sisg", pic = "ss"))
        category.add(CategoryDomain(title = "Chop Suey", pic = "cs"))
        category.add(CategoryDomain(title = "Gising-Gising", pic = "gs"))

    }
}