package com.example.room.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.MyApp
import com.example.room.R
import com.example.room.RecyclerView.Room.AdapterRV
import com.example.room.RecyclerView.Room.ItemRVlist
import com.example.room.data.Database
import com.example.room.data.ETdata
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemRVlist {

    private var db: Database? = null
    var adapter: AdapterRV? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = MyApp.app?.getDB()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val manager = GridLayoutManager(applicationContext, 2)
        RecyclerView.layoutManager = manager
        adapter = AdapterRV(this)
        RecyclerView.adapter = adapter
        val data = db?.getEtDao()?.getAllEtData()
        if (data != null) {
            adapter?.update(data)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate((R.menu.ad), menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(applicationContext, AddActivity::class.java)
        when (item.itemId) {
            R.id.add -> startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun btnDeleteClicked(data: ETdata) {
        db?.getEtDao()?.delete(data)
        val newData = db?.getEtDao()?.getAllEtData()
        if (newData!=null)
            adapter?.update(newData)
    }
}