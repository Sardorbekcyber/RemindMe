package com.turbosoft.remindme.room

import android.os.Parcel
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.turbosoft.remindme.di.ApplicationScope
import com.turbosoft.remindme.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database (entities = [Task::class], version = 1)
abstract class TasksDatabase : RoomDatabase(){

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val applicationScope: CoroutineScope,
        @ApplicationScope private val tasksDatabase: Provider<TasksDatabase>
    ) : RoomDatabase.Callback(){

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao  = tasksDatabase.get().taskDao()
            applicationScope.launch{
                dao.insertTask(Task(name = "Wash the dishes"))
                dao.insertTask(Task(name = "Create Algo interview Prep", isImportant = true))
                dao.insertTask(Task(name = "Android Interview Prep"))
                dao.insertTask(Task(name = "Physical Training", isCompleted = true))
                dao.insertTask(Task(name = "Turin subjects"))
                dao.insertTask(Task(name = "Cooking", isCompleted = true))

            }
        }
    }

}