package com.androidarchitecture.di

import javax.inject.Qualifier

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity