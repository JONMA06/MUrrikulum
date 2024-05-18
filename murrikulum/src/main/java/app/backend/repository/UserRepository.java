package app.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByErabiltzaileaAndPasahitza(String erabiltzailea, String pasahitza);
}