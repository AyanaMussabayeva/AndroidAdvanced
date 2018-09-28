package com.example.amanzholt.lesson2

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var dataset: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            dataset = savedInstanceState.getParcelableArrayList("dataset")
        } else {
            dataset = ArrayList()
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recycler.layoutManager = GridLayoutManager(this, 3)
        } else {
            recycler.layoutManager = LinearLayoutManager(this)
        }

        recycler.adapter = UserAdapter(this, dataset)

        fab.setOnClickListener {
            dataset.add(User("Johny Depp", "Pirates of the Caribbean"))
            recycler.adapter.notifyDataSetChanged()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putParcelableArrayList("dataset", dataset)
    }
}
