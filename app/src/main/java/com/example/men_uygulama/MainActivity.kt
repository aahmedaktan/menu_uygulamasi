package com.example.men_uygulama

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.men_uygulama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var pizza = yemekler("Pizza",100,R.drawable.pizza)
        var hamburger = yemekler("Hamburger",150,R.drawable.hamburger)
        var tantuni = yemekler("Tantuni",100,R.drawable.tantuni)
        var kokorec = yemekler("Kokorec",100,R.drawable.kokorec)

        var yemeklerliste = ArrayList<yemekler>()
        yemeklerliste.add(pizza)
        yemeklerliste.add(hamburger)
        yemeklerliste.add(tantuni)
        yemeklerliste.add(kokorec)

        //adapter veri bağlamak için
        var adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,yemeklerliste.map { yemekler -> yemekler.name })
        binding.listView.adapter = adapter

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            var intent = Intent(this,yemekdetay::class.java)
            intent.putExtra("name",yemeklerliste.get(position).name)
            intent.putExtra("price",yemeklerliste.get(position).price)
            intent.putExtra("image",yemeklerliste.get(position).image)

            startActivity(intent)
        }

    }
}


