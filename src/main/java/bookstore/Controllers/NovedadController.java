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

import bookstore.DTOs.NovedadDTO;
import bookstore.Services.NovedadService;

@RestController
@RequestMapping("api/bookstore")
@CrossOrigin(origins="*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class NovedadController implements ViewController<NovedadDTO>{

	NovedadService service;
	
	// --- Constructor ---
	public NovedadController(NovedadService service) {
		this.service = service;
	}

	// --- CRUD Method - GetAll
	@GetMapping("/admin/informes/")
	@Transactional
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en cargar informes");
		}
	}	

	// --- CRUD Method - GetOne
	@GetMapping("/admin/informes/{id}")
	@Transactional
	@Override
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Noticia no encontrada");
		}
	}

	// --- CRUD Method - Post
	@PostMapping("/admin/informes/")
	@Transactional
	public ResponseEntity post(@RequestBody NovedadDTO dto) {
		try {			
			return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en cargar nueva noticia");
		}
	}

	// --- CRUD Method - Put
	@PutMapping("/admin/informes/{id}")
	@Transactional
	public ResponseEntity put(@RequestBody NovedadDTO dto, @PathVariable int id) {
		try {
			service.update(dto, id);
			return ResponseEntity.status(HttpStatus.OK).body("Noticia actualizada");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en actualizar noticia");
		}
	}

	// --- CRUD Method - Delete
	@DeleteMapping("/admin/informes/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {
			service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Noticia eliminada");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en eliminar noticia");
		}
	}

}
