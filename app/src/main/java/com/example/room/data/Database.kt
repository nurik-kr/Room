package com.example.room.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ETdata::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun getEtDao(): EtDao

}