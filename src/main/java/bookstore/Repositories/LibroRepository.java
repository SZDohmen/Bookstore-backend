package bookstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bookstore.Entities.LibroEntity;

public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {

}
