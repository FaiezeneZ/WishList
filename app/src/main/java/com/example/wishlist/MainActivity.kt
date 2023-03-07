package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var wishListAdapter : RecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvAdapter = findViewById<RecyclerView>(R.id.rv_wishlist)
        lateinit var itemInfo : WishlishtData
        lateinit var itemInfos : MutableList<WishlishtData>
        wishListAdapter = RecycleViewAdapter(mutableListOf())

        val itemName = findViewById<EditText>(R.id.tv_item)
        val itemPrice = findViewById<EditText>(R.id.tv_price)
        val itemLink = findViewById<EditText>(R.id.tv_link)
        val submitBtn = findViewById<Button>(R.id.btn_submit)

        submitBtn.setOnClickListener{
            if (itemName.text.isNullOrEmpty() || itemPrice.text.isNullOrEmpty() || itemLink.text.isNullOrEmpty())
                Toast.makeText(
                    this,
                    "Enter all the Information",
                    Toast.LENGTH_SHORT
                ).show()

            else
            {
                var itemInfo = WishlishtData(itemName.text.toString(), itemPrice.text.toString(), itemLink.text.toString())
                //itemInfo.item= itemName.text.toString()
                //itemInfo.price = itemPrice.text.toString()
                //itemInfo.link = itemLink.text.toString()
                //itemInfos.addToList(itemInfo)

                wishListAdapter.addToList(itemInfo)
                rvAdapter.adapter = wishListAdapter
                rvAdapter.layoutManager = LinearLayoutManager(this)

                itemName.text.clear()
                itemPrice.text.clear()
                itemLink.text.clear()
            }

        }
    }
}