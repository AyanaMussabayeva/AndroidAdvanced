package com.example.amanzholt.lesson3

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_category, container, false)

        val dataset = ArrayList<ListItem>()
        for (i in 1..15) {
            dataset.add(ListItem("Category Title " + i.toString(), "28-09-2018"))
        }

        val categoryRecycler = root.findViewById(R.id.categoryRecycler) as RecyclerView
        categoryRecycler.layoutManager = LinearLayoutManager(activity)
        categoryRecycler.adapter = NewsAndCategoryAdapter(activity!!, dataset)

        return root
    }
}