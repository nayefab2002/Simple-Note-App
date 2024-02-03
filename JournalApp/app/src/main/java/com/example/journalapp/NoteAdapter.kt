package com.example.journalapp

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import values.Note

class NoteAdapter(private val mainActivity: MainActivity,private val noteList: List<Note>):RecyclerView.Adapter<NoteAdapter.ListItemHolder>() {
    override fun getItemCount(): Int {

        return noteList.size
    }
    inner class ListItemHolder(view:View):RecyclerView.ViewHolder(view),View.OnClickListener{
        internal var title=view.findViewById<View>(R.id.textViewTitle) as TextView
        internal var description=view.findViewById<View>(R.id.textViewDescription) as TextView
        internal var status=view.findViewById<View>(R.id.textViewStatus) as TextView
        init{
            view.isClickable=true
            view.setOnClickListener(this)
        }
        override fun onClick(view:View){
            mainActivity.showNote(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.noteitem,parent, false)
        return ListItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {

        val note=noteList[position]
        holder.title.text=note.title
        holder.description.text=note.description!!.substring(0,20)
        when{
            note.idea->holder.status.text="Idea"
            note.priority->holder.status.text="Priority"
            note.goal->holder.status.text="Goal"
            note.toDo->holder.status.text="To-Do"

        }
    }

}