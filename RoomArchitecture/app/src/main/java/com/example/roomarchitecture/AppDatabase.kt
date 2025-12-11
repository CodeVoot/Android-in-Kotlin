package com.example.roomarchitecture

import android.arch.persistence.room.*

// Here I am marking the class as a Room Database
// where Employee and Contact are the data classes which showcases the two diff-diff tables

@Database(entities = arrayOf(Employee::class,Contact::class), version = 1)
abstract class AppDatabase :RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
    abstract fun contactDao(): ContactDao
}