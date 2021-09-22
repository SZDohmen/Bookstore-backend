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

import bookstore.DTOs.LibroDTO;
import bookstore.Services.LibroService;

@RestController
@RequestMapping("api/bookstore")
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class LibroController implements ViewController<LibroDTO>{
	
	LibroService service;

	// --- Constructor ---
	public LibroController(LibroService service) {
		this.service = service;
	}
	
	// --- CRUD Method - GetAll
	@GetMapping("/admin/catalogo/")
	@Transactional
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en cargar catálogo");
		}
	}
	
	// --- CRUD Method - GetOne
	@GetMapping("/admin/catalogo/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Libro no encontrado");
		}
	}

	// --- CRUD Method - Post
	@PostMapping("/admin/catalogo/")
	@Transactional
	public ResponseEntity post(@RequestBody LibroDTO dto) {
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en cargar nuevo libro");
		}
	}
	
	// --- CRUD Method - Put
	@PutMapping("/admin/catalogo/{id}")
	@Transactional
	public ResponseEntity put(@RequestBody LibroDTO dto, @PathVariable int id) {
		try {
			service.update(dto, id);
			return ResponseEntity.status(HttpStatus.OK).body("Libro actualizado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en actualizar libro");
		}
	}

	// --- CRUD Method - Delete
	@DeleteMapping("/admin/catalogo/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Libro eliminado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en eliminar libro");
		}
	}
}
