package com.androidarchitecture.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by binary on 5/22/17.
 */
@Entity
class Task() {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("user_id")
    var uid: Int = 0

    @SerializedName("task")
    var task: String? = null

    constructor(task: String) : this() {
        this.task = task
    }
}