package Pozzie.repositories;

import Pozzie.model.KeyWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyWordRepository extends CrudRepository<KeyWord, Integer> {
}
