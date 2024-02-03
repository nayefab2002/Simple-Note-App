//package com.example.noteapp
package com.example.journalapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import values.Note


class dialog_show_note:DialogFragment() {
    private var note: Note?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(requireActivity())
        val inflater=requireActivity().layoutInflater
        val dialogView=inflater.inflate(R.layout.show_saved_notes,null)
        //Get all the reference of the widgets/ ui elements from the xml
        val txtTitle=dialogView.findViewById(R.id.txtTitle) as TextView
        val txtDescription=dialogView.findViewById(R.id.txtdescription) as TextView
        txtTitle.text=note!!.title
        txtDescription.text=note!!.description

        val txtPriority=dialogView.findViewById<View>(R.id.txtPriority) as TextView
        val txttodo=dialogView.findViewById<View>(R.id.txttodo) as TextView
        val txtIdea=dialogView.findViewById<View>(R.id.txtIdea) as TextView
        val txtgoal=dialogView.findViewById<View>(R.id.txtGoal) as TextView
        if(!note!!.idea){txtIdea.visibility= View.GONE}
        if(!note!!.priority){txtPriority.visibility=View.GONE}
        if(!note!!.toDo){txttodo.visibility=View.GONE}
        if(!note!!.goal){txtgoal.visibility=View.GONE}
        builder.setView(dialogView).setMessage("Your Note!")
        val buttonOk=dialogView.findViewById(R.id.buttonOk) as Button
        buttonOk.setOnClickListener{
            dismiss()
        }
        return builder.create()
    }
    //Receive a note from MainActivity class
    fun recvNoteSelected(note: Note){
        this.note=note
    }
}