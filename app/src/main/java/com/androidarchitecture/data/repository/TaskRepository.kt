package com.androidarchitecture.data.repository

import android.arch.lifecycle.LiveData
import com.androidarchitecture.core.executor.ThreadExecutor
import com.androidarchitecture.data.TaskDataSource
import com.androidarchitecture.entity.Task

class TaskRepository constructor(taskRepositoryFactory: TaskRepositoryFactory, private val mThreadExecutor: ThreadExecutor) : TaskDataSource {

    private val taskLocalAPI = taskRepositoryFactory.createTaskLocalAPI()

    override fun getAllTask(): LiveData<List<Task>> {
        return taskLocalAPI.getAllTask()
    }

    override fun saveTask(taskName: String) {
        mThreadExecutor.execute { taskLocalAPI.saveTask(Task(taskName)) }
    }
}