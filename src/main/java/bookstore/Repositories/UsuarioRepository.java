package bookstore.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bookstore.Entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
	
	// --- Petition -> find mail from usuario table
	@Query("SELECT usuario FROM UsuarioEntity usuario WHERE usuario.mail = :mail")
	public Optional<UsuarioEntity> findByMail(@Param("mail") String mail);
}
