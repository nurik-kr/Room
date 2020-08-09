package com.example.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ETdata(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var et_name: String,
    var et_opisanie: String
)
