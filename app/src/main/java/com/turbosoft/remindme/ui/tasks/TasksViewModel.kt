package com.turbosoft.remindme.ui.tasks

import androidx.lifecycle.ViewModel
import com.turbosoft.remindme.room.TaskDao
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TasksViewModel @Inject constructor(private val taskDao: TaskDao) : ViewModel() {

}