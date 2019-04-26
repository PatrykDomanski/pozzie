package Pozzie.services;

import org.springframework.stereotype.Service;

@Service
public interface PositionCheckerService {
    public int checkPosition(String keyWord, String url);
    public String checkAllPositions();
}
