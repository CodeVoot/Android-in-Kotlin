package com.example.roomarchitecture

import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

interface ContactDao {

    @Insert
    suspend fun insert(contact: Contact)

    @Query("SELECT * FROM Contact")
    suspend fun getAllContacts(): List<Contact>

}