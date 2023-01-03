package com.example.appquiz_10130492_20221228

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity_10130492 : AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_10130492)
        val bundle = this.intent.extras
        title = findViewById(R.id.sec_title)
        description = findViewById(R.id.description_sec)
        back = findViewById(R.id.back)

        val info:InfoObj = bundle?.getSerializable("obj") as InfoObj
        title.text = info.name
        description.text = info.description
        back.setOnClickListener {
            finish()
        }
    }
}