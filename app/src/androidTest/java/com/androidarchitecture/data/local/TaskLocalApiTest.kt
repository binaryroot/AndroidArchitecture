package com.androidarchitecture.data.local

import android.arch.persistence.room.Room
import android.support.test.runner.AndroidJUnit4
import org.junit.runner.RunWith
import android.support.test.InstrumentationRegistry
import com.androidarchitecture.data.local.task.TaskLocalAPI
import com.androidarchitecture.entity.Task
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*;


/**
 * Created by binary on 6/3/17.
 */
@RunWith(AndroidJUnit4::class)
class TaskLocalApiTest {

    private lateinit var taskLocalAPI: TaskLocalAPI
    private lateinit var appDatabase: AppDatabase

    @Before
    fun createDB() {
        val context = InstrumentationRegistry.getTargetContext()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        taskLocalAPI = appDatabase.taskDao()
    }

    @Test
    fun testEmptyDB() {
        assertEquals(taskLocalAPI.getAllTask().value,null)
    }

    @Test
    fun testAddValue() {
        taskLocalAPI.saveTask(Task("test_task"))
        taskLocalAPI.getAllTask().observeForever {
            if(it==null) {
                throw IllegalArgumentException()
            } else {
                assertEquals(it.size, 1)
            }
        }
    }

    @Test
    fun testRemove() {
        val task = Task("test_task")
        task.uid = 1
        taskLocalAPI.saveTask(task)
        taskLocalAPI.removeTask(task)
        taskLocalAPI.getAllTask().observeForever {
            if(it==null) {
                throw IllegalArgumentException()
            } else {
                assertEquals(it.size, 0)
            }
        }
    }
}