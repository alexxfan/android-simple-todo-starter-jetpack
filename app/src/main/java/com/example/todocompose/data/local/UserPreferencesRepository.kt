//package com.example.todocompose.data.local
//
//import android.util.Log
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.booleanPreferencesKey
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.emptyPreferences
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.catch
//import kotlinx.coroutines.flow.map
//import java.io.IOException
//
//class UserPreferencesRepository(private val dataStore: DataStore<Preferences>) {
//
//    companion object {
//        private val IS_GRID_LAYOUT = booleanPreferencesKey("is_grid_layout")
//        private const val TAG = "UserPreferencesRepo"
//    }
//
//    // Read layout preference
//    val isGridLayout: Flow<Boolean> = dataStore.data
//        .catch { exception ->
//            if (exception is IOException) {
//                Log.e(TAG, "Error reading preferences.", exception)
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }
//        .map { preferences ->
//            preferences[IS_GRID_LAYOUT] ?: true // Default to Grid layout
//        }
//
//    // Save layout preference
//    suspend fun saveLayoutPreference(isGridLayout: Boolean) {
//        dataStore.edit { preferences ->
//            preferences[IS_GRID_LAYOUT] = isGridLayout
//        }
//    }
//}
