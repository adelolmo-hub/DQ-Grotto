package app.dqproject.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import app.dqproject.models.GrottoMap;

@Repository
public interface IGrottoRepository extends MongoRepository<GrottoMap, Integer>{
	@Query("{'boss': {$regex: ?0, $options: 'i'} }")
	List<GrottoMap> findAllByBoss(String boss);
}
