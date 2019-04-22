package Pozzie.services;

import Pozzie.model.Type;
import Pozzie.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public String addType(String name) {
        Type type = new Type();
        type.setName(name);
        typeRepository.save(type);
        return "Added";
    }

    @Override
    public String editType(int id, String name) {
        Type type = typeRepository.findById(id)
                .orElse(null);
        if(type == null){
            return "Error";
        }
        type.setName(name);
        typeRepository.save(type);
        return "Edited";
    }

    @Override
    public String deleteType(int id) {
        typeRepository.deleteById(id);
        return "Deleted";
    }
}
