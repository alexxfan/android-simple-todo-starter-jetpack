package com.example.todocompose

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.todocompose.data.local.UserPreferencesRepository


private const val LAYOUT_PREFERENCE_NAME = "layout_preferences"
private val Context.dataStore: DataStore<Preferences> by
preferencesDataStore(name = LAYOUT_PREFERENCE_NAME)

class ToDoApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var userPreferencesRepository: UserPreferencesRepository
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        userPreferencesRepository = UserPreferencesRepository(dataStore)
        container = DefaultAppContainer()
    }
}