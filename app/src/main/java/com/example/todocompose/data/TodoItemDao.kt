//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import androidx.room.Update
//import com.example.todocompose.data.TodoItem
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface TodoItemDao {
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//
//    suspend fun insert(item: TodoItem)
//
//    @Update
//    suspend fun update(todoItem: TodoItem)
//
//    @Delete
//    suspend fun delete(todoItem: TodoItem)
//
//    @Query("SELECT * from todoItems WHERE id = :id")
//    fun getItem(id: Int): Flow<TodoItem>
//
//    @Query("SELECT * from todoItems ORDER BY title ASC")
//    fun getAllItems(): Flow<List<TodoItem>>
//}
