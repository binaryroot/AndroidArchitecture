package com.androidarchitecture.data.repository

import com.androidarchitecture.data.local.AppDatabase
import com.androidarchitecture.data.local.task.TaskLocalAPI
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by binary on 5/22/17.
 */
@Singleton
class TaskRepositoryFactory @Inject constructor(private var appDatabase: AppDatabase) {

    fun createTaskLocalAPI(): TaskLocalAPI {
        return appDatabase.taskDao()
    }
}