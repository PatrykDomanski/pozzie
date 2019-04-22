package Pozzie.services;

import Pozzie.model.KeyWord;
import org.springframework.stereotype.Service;

@Service
public interface PositionCheckerService {
    public int checkPosition(String keyWord, String url);
}
