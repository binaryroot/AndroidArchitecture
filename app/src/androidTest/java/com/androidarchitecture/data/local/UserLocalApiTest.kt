package com.androidarchitecture.data.local

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import com.androidarchitecture.data.local.user.UserLocalAPI
import com.androidarchitecture.entity.User
import org.junit.Assert.*;
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by binary on 6/3/17.
 */
@RunWith(AndroidJUnit4::class)
class UserLocalApiTest {

    private lateinit var userLocalAPI: UserLocalAPI
    private lateinit var appDatabase: AppDatabase

    @Before
    fun createDB() {
        val context = InstrumentationRegistry.getTargetContext()
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        userLocalAPI = appDatabase.userDao()
    }

    @Test
    fun testEmptyDB() {
        assertEquals(userLocalAPI.findById(0), null)
    }

    @Test
    fun testSaveUser() {
        val id = 2;
        val user = User();
        user.uid = id;
        userLocalAPI.saveUser(user)
        assertEquals(userLocalAPI.findById(id)?.uid, id)
    }

    @Test
    fun testSaveUserByName() {
        val name = "Nazar";
        val user = User();
        user.firstName = name;
        userLocalAPI.saveUser(user)
        assertEquals(userLocalAPI.findByName(name)?.firstName, name)
    }

    @Test
    fun testSaveUserConflict() {
        val id = 2;
        val name = "binary"
        val secondName = "root"
        val user = User();
        user.uid = id;
        user.firstName = name
        userLocalAPI.saveUser(user)
        user.firstName = secondName
        userLocalAPI.saveUser(user)
        assertEquals(userLocalAPI.findById(id)?.firstName, secondName)
    }
}