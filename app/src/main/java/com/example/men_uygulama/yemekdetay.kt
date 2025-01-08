package com.example.men_uygulama

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.men_uygulama.databinding.ActivityMainBinding
import com.example.men_uygulama.databinding.ActivityYemekdetayBinding

class yemekdetay : AppCompatActivity() {
    lateinit var binding: ActivityYemekdetayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYemekdetayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var intent = intent
        var isim = intent.getStringExtra("name")
        var price = intent.getIntExtra("price",0)
        var image = intent.getIntExtra("image",0)

        binding.name.text = isim
        binding.fiyat.text = price.toString()
        binding.imageView2.setImageResource(image)
        }
    }
