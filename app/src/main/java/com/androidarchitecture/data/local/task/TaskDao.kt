package com.androidarchitecture.data.local.task

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.androidarchitecture.entity.Task

/**
 * Created by binary on 5/22/17.
 */
@Dao
interface TaskDao : TaskLocalAPI {

    @Query("SELECT * FROM task")
    override fun getAllTask(): LiveData<List<Task>>

    @Insert
    override fun saveTask(task: Task)

}