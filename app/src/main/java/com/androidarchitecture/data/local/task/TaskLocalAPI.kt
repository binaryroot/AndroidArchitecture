package com.androidarchitecture.data.local.task

import android.arch.lifecycle.LiveData
import com.androidarchitecture.entity.Task

/**
 * Created by binary on 5/22/17.
 */
interface TaskLocalAPI {

    fun getAllTask(): LiveData<List<Task>>

    fun saveTask(task: Task)

}