package app.backend.repository;

import org.springframework.data.repository.CrudRepository;

import app.backend.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    static User findByErabiltzaileaAndPasahitza(String erabiltzailea, String pasahitza) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByErabiltzaileaAndPasahitza'");
    }
}
