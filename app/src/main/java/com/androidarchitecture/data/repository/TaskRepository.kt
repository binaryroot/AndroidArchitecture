package com.androidarchitecture.data.repository

import android.arch.lifecycle.LiveData
import com.androidarchitecture.core.executor.ThreadExecutor
import com.androidarchitecture.data.TaskDataSource
import com.androidarchitecture.entity.Task
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by binary on 5/22/17.
 */
@Singleton
class TaskRepository @Inject constructor(taskRepositoryFactory: TaskRepositoryFactory , val threadExecutor: ThreadExecutor) : TaskDataSource {

    private val taskLocalAPI = taskRepositoryFactory.createTaskLocalAPI()

    override fun getAllTask(): LiveData<List<Task>> {
        return taskLocalAPI.getAllTask()
    }

    override fun saveTask(taskName: String) {
        threadExecutor.execute { taskLocalAPI.saveTask(Task(taskName)) }
    }
}