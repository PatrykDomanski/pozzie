package Pozzie.services;

import Pozzie.model.Note;
import Pozzie.model.Project;
import Pozzie.model.Type;
import Pozzie.model.User;
import Pozzie.repositories.NoteRepository;
import Pozzie.repositories.ProjectRepository;
import Pozzie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addNote(Project project, Date date, Type type, String content) {
        Note note = new Note();
        note.setDate(date);
        note.setType(type);
        note.setContent(content);
        noteRepository.save(note);
        return "Added";
    }

    @Override
    public String editNote(int id, Date date, Type type, String content) {
        Note note = noteRepository.findById(id)
                .orElse(null);
        if(note == null){
            return "Error";
        }
        note.setDate(date);
        note.setType(type);
        note.setContent(content);
        return "Edited";
    }

    @Override
    public String deleteNote(int id) {
        /*Note note = noteRepository.findById(id)
                .orElse(null);
        if(note == null){
            return "Error";
        }*/
        noteRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Iterable<Note> showAllNotes(int id) {
        User user = userRepository.findById(id).orElse(null);
        return user.getProject().getNotes();
    }
}
