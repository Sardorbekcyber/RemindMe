package com.turbosoft.remindme.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.turbosoft.remindme.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private val viewModel : TasksViewModel by viewModels()

}