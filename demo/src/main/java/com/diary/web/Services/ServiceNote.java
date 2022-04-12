package com.diary.web.Services;

import com.diary.web.Entities.Notes;
import com.diary.web.Entities.User;
import com.diary.web.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceNote {
    @Autowired
    private NoteRepository Repository;

    public boolean saveNote(String noteName, String noteDes) {
        Notes byEmail = Repository.findByNoteName(noteName);
        if(byEmail == null) {
            Notes notes = new Notes(noteName,noteDes);
            Repository.save(notes);
            return true;
        }
        return false;
    }

    public Notes getNotes(String noteName) {
        return Repository.findByNoteName(noteName);
    }


    public boolean updateNote(String oldNoteName, String newNoteName, String newNoteDes){
        Notes note = Repository.findByNoteName(oldNoteName);
        if(note != null){
            if((!newNoteName.equals("")) && (!newNoteDes.equals(""))){
                note.setNoteName(newNoteName);
                note.setNoteDes(newNoteDes);
                Repository.save(note);
                return true;
            }
            else if((newNoteName.equals("")) && (!newNoteDes.equals(""))){
                note.setNoteDes(newNoteDes);
                Repository.save(note);
                return true;
            }
            else if((!newNoteName.equals("")) && (newNoteDes.equals(""))){
                note.setNoteName(newNoteName);
                Repository.save(note);
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }


    public boolean deleteNote(String noteName){
        Notes note = Repository.findByNoteName(noteName);
        if(note != null){
            Repository.delete(note);
            return true;
        }
        return false;
    }
}
