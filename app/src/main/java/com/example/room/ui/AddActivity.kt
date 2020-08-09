package com.example.room.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.room.MyApp
import com.example.room.R
import com.example.room.RecyclerView.Room.AdapterRV
import com.example.room.data.Database
import com.example.room.data.ETdata
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class AddActivity : AppCompatActivity() {

    private var db: Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupClicks()
        db = MyApp.app?.getDB()
    }

    private fun setupClicks() {
        btn_save.setOnClickListener {
            db?.getEtDao()?.insertEtData(fetchData())
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


    private fun fetchData(): ETdata {
        return ETdata(
            et_name = et_name.text.toString(),
            et_opisanie = et_opisanie.text.toString()
        )
    }
}