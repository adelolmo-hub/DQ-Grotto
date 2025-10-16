package app.dqproject.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.dqproject.models.User;

public interface IUserRepository extends MongoRepository<User, String>{

	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}
