package com.androidarchitecture.data

import android.arch.lifecycle.LiveData
import com.androidarchitecture.entity.Task

/**
 * Created by binary on 5/22/17.
 */
interface TaskDataSource {

    fun getAllTask(): LiveData<List<Task>>

    fun saveTask(taskName:String)

}