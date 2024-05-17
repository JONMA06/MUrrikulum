package app.backend.repository;

import org.springframework.data.repository.CrudRepository;

import app.backend.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
