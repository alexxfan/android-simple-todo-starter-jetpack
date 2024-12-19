//package com.example.todocompose.data
//
//import kotlinx.coroutines.flow.Flow
//
//interface TodoItemsRepository {
//    /**
//     * Retrieve all the items from the the given data source.
//     */
//    fun getAllItemsStream(): Flow<List<TodoItem>>
//
//    /**
//     * Retrieve an item from the given data source that matches with the [id].
//     */
//    fun getItemStream(id: Int): Flow<TodoItem?>
//
//    /**
//     * Insert item in the data source
//     */
//    suspend fun insertItem(todoItem: TodoItem)
//
//    /**
//     * Delete item from the data source
//     */
//    suspend fun deleteItem(todoItem: TodoItem)
//
//    /**
//     * Update item in the data source
//     */
//    suspend fun updateItem(todoItem: TodoItem)
//
//}