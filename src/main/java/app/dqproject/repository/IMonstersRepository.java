package app.dqproject.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.dqproject.models.GrottoMap;
import app.dqproject.models.Monster;

@Repository
public interface IMonstersRepository extends MongoRepository<Monster, ObjectId>{
	Optional<Monster> findByType(String type);
}
