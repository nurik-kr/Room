package com.example.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EtDao {

    @Insert
    fun insertEtData(data: ETdata)

    @Query("SELECT *  FROM ETdata")
    fun getAllEtData():List<ETdata>

    @Delete
    fun delete(data: ETdata) {

    }
}