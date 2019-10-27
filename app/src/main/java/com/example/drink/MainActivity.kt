package com.example.drink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.drink_list)
        initDATA()

        list.layoutManager = LinearLayoutManager (this)
        list.adapter = RecyclerViewAdapter(this,items)
    }

    private fun initDATA(){
        val name = resources.getStringArray(R.array.drink_name)
        val image = resources.obtainTypedArray(R.array.drink_image)

        items.clear()

        for (i in name.indices) {
            items.add(
                Item(name[i],
                    image.getResourceId(i,0)))
        }
        image.recycle()
    }
}
