package com.androidarchitecture.data

import android.arch.lifecycle.LiveData
import com.androidarchitecture.entity.Task

interface TaskDataSource {

    fun getAllTask(): LiveData<List<Task>>

    fun saveTask(taskName:String)
}