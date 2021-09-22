package bookstore.Controllers;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookstore.DTOs.UsuarioDTO;
import bookstore.Services.UsuarioService;

@RestController
@RequestMapping("api/bookstore")
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UsuarioController implements ViewController<UsuarioDTO>{

	UsuarioService service;

	// --- Constructor ---
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	// --- CRUD Method - GetAll
	@GetMapping("/admin/usuarios/")
	@Transactional
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en cargar usuarios");
		}
	}	
	
	// --- CRUD Method - GetOne
	@GetMapping("/admin/usuarios/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
		}
	}
	
	// --- CRUD Method - GetByMail
	@GetMapping("/admin/usuarios/mail/{mail}")
	@Transactional
	public ResponseEntity getByMail(@PathVariable String mail) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findByMail(mail));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mail no encontrado");
		}
	}

	// --- CRUD Method - Post
	@PostMapping("/admin/usuarios/")
	@Transactional
	public ResponseEntity post(@RequestBody UsuarioDTO dto) {
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en cargar nuevo usuario");
		}
	}
	
	// --- CRUD Method - Put
	@PutMapping("/admin/usuarios/{id}")
	@Transactional
	public ResponseEntity put(@RequestBody UsuarioDTO dto, @PathVariable int id) {
		try {
			service.update(dto, id);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario actualizado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en actualizar usuario");
		}
	}

	// --- CRUD Method - Delete
	@DeleteMapping("/admin/usuarios/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en eliminar usuario");
		}
	}
}
