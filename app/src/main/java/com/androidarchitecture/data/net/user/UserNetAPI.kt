package com.androidarchitecture.data.net.user

import android.arch.lifecycle.LiveData
import com.androidarchitecture.entity.User

/**
 * Created by binary on 5/18/17.
 */
interface UserNetAPI {

    fun loadUserById(userId: Int) : LiveData<User>

}