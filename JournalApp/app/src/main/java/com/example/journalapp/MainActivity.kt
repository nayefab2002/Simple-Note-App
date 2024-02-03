package com.example.journalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import values.Note

class MainActivity : AppCompatActivity() {
    private var noteList=ArrayList<Note>()
    private var recyclerView: RecyclerView?=null
    private var adapter:NoteAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val floatingButton=findViewById<FloatingActionButton>(R.id.fab)
        floatingButton.setOnClickListener{
                view ->
            //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //.setAction("Action", null).show()
            val newdialog=dialogNewNoteClass()
            newdialog.show(supportFragmentManager,"")
        }
        adapter= NoteAdapter(this,noteList)
        recyclerView=findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView!!.layoutManager= LinearLayoutManager(applicationContext)
        recyclerView!!.itemAnimator= DefaultItemAnimator()
        recyclerView!!.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        recyclerView!!.adapter=adapter
    }
    fun createNewNote(n: Note) {
        noteList.add(n)
        adapter!!.notifyDataSetChanged() //This lets our adapter know there has been new note added
    }
    fun showNote(notePos:Int){
        val dialog=dialog_show_note()
        dialog.recvNoteSelected(noteList[notePos])
        dialog.show(supportFragmentManager,"")
    }
}