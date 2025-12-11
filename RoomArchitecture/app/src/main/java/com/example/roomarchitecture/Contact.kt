package com.example.roomarchitecture

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true) val uId: Int = 0,
    @ColumnInfo(name="email_addr") var emailAddr : String
)
