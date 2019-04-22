package Pozzie.services;

import Pozzie.model.KeyWord;
import Pozzie.model.Position;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface PositionService {
    public List<Position> getAllPositions();
    public List<Position> getAllUserPositions(int id);
    public String addPosition(int id, Date date, int position, String url, KeyWord keyword);

}
