package app.dqproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.dqproject.models.GrottoMap;

@Repository
public interface IGrottoRepository extends MongoRepository<GrottoMap, Integer>{
	
}
