package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {}
