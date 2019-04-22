package Pozzie.services;

import Pozzie.model.Note;
import Pozzie.model.Project;
import Pozzie.model.Type;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface NoteService {
    public String addNote(Project project, Date date, Type type, String content);
    public String editNote(int id, Date date, Type type, String content);
    public String deleteNote(int id);
    public Iterable<Note> showAllNotes(int id);
}
