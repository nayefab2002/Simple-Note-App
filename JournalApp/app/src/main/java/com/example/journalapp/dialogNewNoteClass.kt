//package com.example.noteapp
package com.example.journalapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import values.Note

class dialogNewNoteClass:DialogFragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder=AlertDialog.Builder(requireActivity())
        val inflater=requireActivity().layoutInflater
        val dialogView=inflater.inflate(R.layout.new_dialog_note,null)
        //Now get the reference to each of the ui widgets from the xml-->Inflater means turing xml into kotlin object or instance
        val editText=dialogView.findViewById(R.id.titleText) as EditText
        val editDescription=dialogView.findViewById(R.id.descriptionText) as EditText
        val checkBoxIdea=dialogView.findViewById(R.id.ideaBox) as CheckBox
        val checkBoxtodo=dialogView.findViewById(R.id.toDoBox) as CheckBox
        val checkBoxGoal=dialogView.findViewById(R.id.goalBox) as CheckBox
        val checkBoxPriority=dialogView.findViewById(R.id.priorityBox) as CheckBox
        val buttonSave=dialogView.findViewById(R.id.buttonSave) as Button
        val buttonCancel=dialogView.findViewById(R.id.buttonCancel) as Button
        //Now use the builder to set the view or content
        builder.setView(dialogView).setMessage("Add a new note")
        buttonCancel.setOnClickListener{
            dismiss()
        }

        buttonSave.setOnClickListener{
            val newNote=Note()
            newNote.title=editText.text.toString()
            newNote.description=editDescription.text.toString()
            newNote.goal=checkBoxGoal.isChecked
            newNote.idea=checkBoxIdea.isChecked
            newNote.priority=checkBoxPriority.isChecked
            newNote.toDo=checkBoxtodo.isChecked

            //Get a reference to mainactivity
            val callingActivity=activity as MainActivity?
            callingActivity!!.createNewNote(newNote)
            dismiss()
        }

        return builder.create()
    }
}