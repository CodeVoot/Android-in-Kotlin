package com.example.roomarchitecture

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "empl")
data class Employee(
    @PrimaryKey(autoGenerate = true) val uId: Int = 0,
    @ColumnInfo(name="first_name") val firstName: String,
    @ColumnInfo(name="last_name") val lastName: String
)
