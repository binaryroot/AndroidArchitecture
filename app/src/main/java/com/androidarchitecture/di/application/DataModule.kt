package com.androidarchitecture.di.application

import com.androidarchitecture.data.TaskDataSource
import com.androidarchitecture.data.UserDataSource
import com.androidarchitecture.data.repository.TaskRepository
import com.androidarchitecture.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by binary on 5/18/17.
 */
@dagger.Module
class DataModule {

    @dagger.Provides
    @javax.inject.Singleton
    fun providerUserDataSource(userRepository: com.androidarchitecture.data.repository.UserRepository) : com.androidarchitecture.data.UserDataSource = userRepository

    @dagger.Provides
    @javax.inject.Singleton
    fun providerTaskDataSource(taskRepository: com.androidarchitecture.data.repository.TaskRepository) : com.androidarchitecture.data.TaskDataSource = taskRepository

}