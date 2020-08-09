package com.example.room

import android.app.Application
import androidx.room.Room
import com.example.room.data.Database

class MyApp : Application() {

    private var db: Database? = null

    override fun onCreate() {
        super.onCreate()
        app = this
        db = Room.databaseBuilder(this, Database::class.java, "MY_DATABASE")
            .allowMainThreadQueries()
            .build()
    }

    fun getDB(): Database? = db

    companion object {
        var app: MyApp? = null
    }
}