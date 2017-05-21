package com.androidarchitecture.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.androidarchitecture.data.local.task.TaskDao
import com.androidarchitecture.data.local.user.UserDao
import com.androidarchitecture.entity.Task
import com.androidarchitecture.entity.User

/**
 * Created by binary on 5/19/17.
 */
@Database(entities = arrayOf(User::class, Task::class), version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun taskDao(): TaskDao
}