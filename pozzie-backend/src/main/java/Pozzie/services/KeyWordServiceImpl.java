package Pozzie.services;

import Pozzie.model.KeyWord;
import Pozzie.model.Position;
import Pozzie.model.Project;
import Pozzie.repositories.KeyWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class KeyWordServiceImpl implements KeyWordService {

    @Autowired
    private KeyWordRepository keyWordRepository;

    @Override
    public String addKeyword(Project project, String keyword) {
        KeyWord keyWord = new KeyWord();
        Set<Position> positions = new HashSet<Position>();
        keyWord.setKeyword(keyword);
        keyWord.setProject(project);
        keyWord.setPositions(positions);
        keyWordRepository.save(keyWord);
        return "Added";
    }

    @Override
    public String editKeyword(int id, String keyword) {
        KeyWord keyWord = keyWordRepository.findById(id)
                .orElse(null);;
        if(keyWord == null){
            return "Error";
        }
        keyWord.setKeyword(keyword);
        keyWordRepository.save(keyWord);
        return "Edited";
    }

    @Override
    public String deleteKeyword(int id) {
        /*KeyWord keyWord = keyWordRepository.findById(id)
                .orElse(null);
        if(keyWord == null){
            return "Error";
        }*/
        keyWordRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Iterable<KeyWord> getAllKeywords() {
        return keyWordRepository.findAll();
    }
}
