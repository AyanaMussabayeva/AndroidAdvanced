package com.example.amanzholt.lesson4

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread
import android.R.attr.data
import android.app.Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = this.getSharedPreferences("data", Context.MODE_PRIVATE)

        val myDB = NewsDatabase.getInstance(this)
        loadData(myDB!!)

        fab.setOnClickListener {
            startActivityForResult(Intent(this, AddNewsActivity::class.java), 1)
        }
    }

    fun loadData(myDB: NewsDatabase) {
        val dataset: ArrayList<News> = ArrayList()
        thread {
            val list = myDB.newsDao().getAll()
            for (i in 0..(list.size - 1)) {
                dataset.add(list[i])
            }

            onDataLoaded(dataset)
        }
    }

    fun onDataLoaded(dataset: ArrayList<News>) {
        runOnUiThread {
            newsRecycler.layoutManager = LinearLayoutManager(this)
            newsRecycler.adapter = NewsAdapter(this, dataset)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getParcelableExtra<News>("news")
                val myDB = NewsDatabase.getInstance(this)
                thread {
                    val list = myDB?.newsDao()?.getAll()
                    result?.id =  list!!.size + 1
                    myDB.newsDao().insert(result!!)

                    loadData(myDB)
                }
            }
        }
    }
}
