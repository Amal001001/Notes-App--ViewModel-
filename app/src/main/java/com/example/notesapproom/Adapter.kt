package com.example.notesapproom

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapproom.Database.Notes
import com.example.notesapproom.databinding.ItemRowBinding
//,private var items : ArrayList<Notes>
class Adapter (private val activity: MainActivity): RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    private var notes = emptyList<Notes>()
  class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
      return ItemViewHolder(
          ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = notes[position]
            holder.binding.apply {
                tv.text = item.note
                ibUpdate.setOnClickListener {
                    activity.raiseDialog(item.id,item.note)
                }
                ibDelete.setOnClickListener {
                    activity.deleteDialog(item)
                }
            }
    }
    override fun getItemCount() = notes.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(notes: List<Notes>){
        this.notes = notes
        notifyDataSetChanged()
    }
}