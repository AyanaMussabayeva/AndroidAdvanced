package com.example.amanzholt.lesson4

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_news.*

class AddNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)

        okBtn.setOnClickListener {

            //added current time, when posting news
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())

            val title = titleEditText.text.toString()
            val description = desccriptinEditText.text.toString()
            val news = News(0, title, currentDate, description) 

            setResult(Activity.RESULT_OK, Intent()
                    .putExtra("news", news))
            finish()
        }
    }
}
