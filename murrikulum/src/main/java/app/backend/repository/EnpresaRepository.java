package app.backend.repository;


import org.springframework.data.repository.CrudRepository;

import app.backend.model.Enpresa;

public interface EnpresaRepository extends CrudRepository<Enpresa, Long> {
}
