package com.androidarchitecture.data.repository

import com.androidarchitecture.data.local.AppDatabase
import com.androidarchitecture.data.local.task.TaskLocalAPI

class TaskRepositoryFactory constructor(private var appDatabase: AppDatabase) {

    fun createTaskLocalAPI(): TaskLocalAPI {
        return appDatabase.taskDao()
    }
}