package Pozzie.services;

import Pozzie.model.KeyWord;
import Pozzie.model.Project;
import org.springframework.stereotype.Service;

@Service
public interface KeyWordService {
    public String addKeyword(Project project, String keyword);
    public String editKeyword(int id, String keyword);
    public String deleteKeyword(int id);
    public Iterable<KeyWord> getAllKeywords();
}
