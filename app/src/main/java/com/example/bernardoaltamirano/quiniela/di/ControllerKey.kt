package com.example.bernardoaltamirano.quiniela.di

import com.bluelinelabs.conductor.Controller

import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by icaboalo on 01/02/18.
 */

@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ControllerKey(val value: KClass<out Controller>)
