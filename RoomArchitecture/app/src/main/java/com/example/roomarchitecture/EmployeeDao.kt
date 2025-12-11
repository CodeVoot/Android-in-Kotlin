package com.example.roomarchitecture

import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

interface EmployeeDao {

    // suspend -- part of kotlin coroutines which is responsible for asynchronous programming
    @Insert
    suspend fun insert(employee: Employee)

    @Query("SELECT * FROM empl")
    suspend fun getAllEmployees(): List<Employee>
}