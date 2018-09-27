package com.example.amanzholt.lesson3

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val item = intent.getParcelableExtra<ListItem>("item")

        titleText.text = item.title
        dateText.text = item.date
    }
}