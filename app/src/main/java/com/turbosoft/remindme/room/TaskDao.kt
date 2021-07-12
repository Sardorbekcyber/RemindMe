package com.turbosoft.remindme.room

import androidx.room.*
import com.turbosoft.remindme.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query(
        "SELECT * FROM tasks_table WHERE name LIKE '%' || :searchQuery || '%' ORDER BY isImportant DESC"
    )
    fun getTasks(searchQuery: String): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

}