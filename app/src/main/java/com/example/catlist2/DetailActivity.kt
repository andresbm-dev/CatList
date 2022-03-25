package com.example.catlist2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.net.URI

class DetailActivity : AppCompatActivity() {
    lateinit var url_:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val informacion = intent.getStringExtra("INFORMACION")
        val url = intent.getStringExtra("URL")
        val name = intent.getStringExtra("NAME")
        val photo = intent.getStringExtra("PHOTO")

        val info = findViewById<TextView>(R.id.tvdescription)
        url_ = findViewById(R.id.tvurl)
        val name_ = findViewById<TextView>(R.id.tvname)
        val photo_ = findViewById<ImageView>(R.id.ivphoto)

        info.text = informacion
        url_.text = url
        name_.text = name
        Picasso.get().load(photo).into(photo_);
        println("$url")

        navegacionLink(url)

    }

    private fun navegacionLink(url:String?) {
        url_.setOnClickListener {
            val link = Uri.parse(url)
            println(link)
            val intent = Intent(Intent.ACTION_VIEW, link)
            startActivity(intent)

        }
    }
}