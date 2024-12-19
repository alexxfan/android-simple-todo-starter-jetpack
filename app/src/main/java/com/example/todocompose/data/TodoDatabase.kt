//package com.example.todocompose.data
//
//import TodoItemDao
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(entities = [TodoItem::class], version = 1, exportSchema = false)
//abstract class TodoDatabase : RoomDatabase() {
//
//    abstract fun todoItemDao(): TodoItemDao
//
//    companion object {
//        @Volatile
//        private var Instance: TodoDatabase? = null
//
//        fun getDatabase(context: Context): TodoDatabase {
//            return Instance ?: synchronized(this) {
//                Room.databaseBuilder(context, TodoDatabase::class.java, "item_database")
//                    .build()
//                    .also { Instance = it }
//            }
//        }
//    }
//
//
//}