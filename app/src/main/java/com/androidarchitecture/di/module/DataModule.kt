package com.androidarchitecture.di.module

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
@Module
class DataModule {

    @Provides
    @Singleton
    fun providerUserDataSource(userRepository: UserRepository) : UserDataSource = userRepository

    @Provides
    @Singleton
    fun providerTaskDataSource(taskRepository: TaskRepository) : TaskDataSource = taskRepository

}