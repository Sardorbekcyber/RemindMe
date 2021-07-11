package com.turbosoft.remindme.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tasks_table")
data class Task(
    @PrimaryKey (autoGenerate = true)
    val id : Int = 0,
    val name: String,
    val isImportant: Boolean = false,
    val isCompleted: Boolean = false,
    val timeCreated : Long = System.currentTimeMillis()
)