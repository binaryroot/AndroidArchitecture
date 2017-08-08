package com.androidarchitecture.di.activity

import java.lang.annotation.Retention
import javax.inject.Qualifier

import javax.inject.Scope

//import java.lang.annotation.RetentionPolicy.RUNTIME

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity