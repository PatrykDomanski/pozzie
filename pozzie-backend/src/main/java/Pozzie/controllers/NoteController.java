package Pozzie.controllers;

import Pozzie.model.Note;
import Pozzie.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/notes/{id}")
    @ResponseBody
    public Iterable<Note> getNotes(@PathVariable("id") int id){
        return noteService.showAllNotes(id);
    }

}
