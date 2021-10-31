package com.example.notesapproom.Database

import androidx.lifecycle.LiveData

class NoteRepository (private val notedao: noteDao) {

    val getNotes: LiveData<List<Notes>> = notedao.getAllNotes()

    suspend fun insert(note: Notes){
        notedao.insert(note)
    }

    suspend fun update(note: Notes){
        notedao.update(note)
    }

    suspend fun delete(note: Notes){
        notedao.delete(note)
    }

}