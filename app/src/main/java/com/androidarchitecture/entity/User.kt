package com.androidarchitecture.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by binary on 5/18/17.
 */
@Entity
class User  {
    @PrimaryKey
    @SerializedName("user_id")
    var uid: Int = 0

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    var firstName: String? = null

    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    var lastName: String? = null

    @ColumnInfo(name = "login")
    @SerializedName("login")
    var login: String? = null
}