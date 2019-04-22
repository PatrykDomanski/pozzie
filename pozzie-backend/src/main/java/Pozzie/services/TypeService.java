package Pozzie.services;

import org.springframework.stereotype.Service;

@Service
public interface TypeService {
    public String addType(String name);
    public String editType(int id, String name);
    public String deleteType(int id);

}
