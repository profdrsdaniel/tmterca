package com.example.recyclerview_menucontexto

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class DetalheProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_product)

        val productBundle = intent?.getSerializableExtra("produto") as Product?

        val name = findViewById<TextView>(R.id.tvProductName)
        val price = findViewById<TextView>(R.id.tvProductPrice)
        val img = findViewById<ImageView>(R.id.imgProduct)

        name.text = productBundle?.name
        price.text = productBundle?.price

        Glide
            .with(this)
            .load(productBundle?.urlImage)
            .centerCrop()
            .into(img)
    }
}