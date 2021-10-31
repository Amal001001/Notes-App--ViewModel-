package com.example.notesapproom.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface noteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Notes)

    @Query("SELECT * FROM notes")
    fun getAllNotes(): LiveData<List<Notes>>

    @Update
    suspend fun update(note: Notes)

    @Delete
    suspend fun delete(note: Notes)

}