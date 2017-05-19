package com.androidarchitecture.data.local.user

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

import com.androidarchitecture.entity.User

/**
 * Created by binary on 5/19/17.
 */
@Dao
interface UserDao: UserLocalAPI {

    @Query("SELECT * FROM user WHERE first_name LIKE :arg0 LIMIT 1")
    override fun findByName(first: String): LiveData<User>

    @Query("SELECT * FROM user WHERE uid LIKE :arg0 LIMIT 1")
    override  fun findById(uid: Int): LiveData<User>
}
