package Pozzie.services;

import Pozzie.model.KeyWord;
import Pozzie.model.Position;
import Pozzie.model.User;
import Pozzie.repositories.PositionRepository;
import Pozzie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Position> getAllPositions() {
        return (List<Position>) positionsRepository.findAll();
    }

    @Override
    public List<Position> getAllUserPositions(int id) {
        User user = userRepository.findById(id)
                .orElse(null);
        if(user == null){
            return null;
        }
        return user.getKeywords();
    }

    @Override
    public String addPosition(int id, Date date, int position, String url, KeyWord keyword) {
        Position newPosition = new Position();
        /*User user = userRepository.findById(id)
                .orElse(null);
        if(user == null){
            return "Error";
        }*/
        newPosition.setId(id);
        newPosition.setKeyWord(keyword);
        newPosition.setDate(date);
        newPosition.setPosition(position);
        newPosition.setUrl(url);
        positionsRepository.save(newPosition);
        return "Added";
    }
}
