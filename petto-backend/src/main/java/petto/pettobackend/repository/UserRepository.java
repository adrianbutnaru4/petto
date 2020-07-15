package petto.pettobackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {}
