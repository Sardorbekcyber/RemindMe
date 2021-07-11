package com.turbosoft.remindme.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.turbosoft.remindme.room.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(taskDao: TaskDao) : ViewModel() {

    val tasks = taskDao.getAllTasks().asLiveData()


}