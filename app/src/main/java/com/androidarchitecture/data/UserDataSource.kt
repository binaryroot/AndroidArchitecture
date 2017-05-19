package com.androidarchitecture.data

import android.arch.lifecycle.LiveData;
import com.androidarchitecture.entity.User

/**
 * Created by binary on 5/18/17.
 */
interface UserDataSource {

    fun loadUserInfoById(userId : Int) : LiveData<User>

}