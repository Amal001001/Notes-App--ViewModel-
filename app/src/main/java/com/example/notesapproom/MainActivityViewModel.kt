package com.example.notesapproom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapproom.Database.NoteDatabase
import com.example.notesapproom.Database.NoteRepository
import com.example.notesapproom.Database.Notes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application): AndroidViewModel(application) {
    private val repository: NoteRepository
    private val notes: LiveData<List<Notes>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        notes = repository.getNotes
    }

    fun readFromDB(): LiveData<List<Notes>> {
        return notes
    }

     fun insert(noteText: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(Notes(0, noteText))
            readFromDB()
        }
    }

     fun update(noteID: Int, noteText: String){
        CoroutineScope(Dispatchers.IO).launch {
            repository.update(Notes(noteID,noteText))
            readFromDB()
        }
    }

    fun delete(noteID: Int){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(Notes(noteID,""))
            readFromDB()
        }
    }

}