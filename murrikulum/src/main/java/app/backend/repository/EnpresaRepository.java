package app.backend.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import app.backend.model.Enpresa;

public interface EnpresaRepository extends CrudRepository<Enpresa, Long> {
    Optional<Enpresa> findByUserId(Long userId);
}
