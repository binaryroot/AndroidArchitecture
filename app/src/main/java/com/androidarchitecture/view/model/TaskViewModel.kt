package com.androidarchitecture.view.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.androidarchitecture.data.TaskDataSource
import com.androidarchitecture.entity.Task
import javax.inject.Inject

/**
 * Created by binary on 5/22/17.
 */
class TaskViewModel : ViewModel() {

    @Inject
    lateinit var taskDataSource: TaskDataSource

    private var tasks: MutableLiveData<List<Task>>? = null

    //region UserViewModel
    fun getTasks(): LiveData<List<Task>>? {
        if (tasks == null) {
            tasks = MutableLiveData()
            loadTasks()
        }
        return tasks
    }

    fun addTask(task: String) {
        taskDataSource.saveTask(task)
    }
    //endregion

    //region UtilityAPI
    private fun loadTasks() {
        taskDataSource.getAllTask().observeForever {
            tasks?.postValue(it)
        }
    }
    //endregion
}