package bookstore.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bookstore.DTOs.LibroDTO;
import bookstore.Entities.LibroEntity;
import bookstore.Repositories.LibroRepository;

@Service
public class LibroService implements ViewService<LibroDTO>{
	
	private LibroRepository repository;
	
	// --- Constructor ---
	public LibroService(LibroRepository repository) {
		this.repository = repository;
	}

	// --- CRUD Method - GetAll
	@Transactional
	public List<LibroDTO> findAll() throws Exception {
		List<LibroEntity> libros = repository.findAll();
		List<LibroDTO> lista = new ArrayList<LibroDTO>();
		try {
			for(LibroEntity libro : libros){
				
				LibroDTO dto = new LibroDTO();				
				dto.setId(libro.getId());
				dto.setTitulo(libro.getTitulo());
				dto.setAutor(libro.getAutor());
				dto.setImagen(libro.getImagen());
				dto.setDescripcion(libro.getDescripcion());
				dto.setPrecio(libro.getPrecio());
				
				lista.add(dto);
			}
			return lista;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// --- CRUD Method - FindById
	@Transactional
	public LibroDTO findById(int id) throws Exception {
		
		Optional<LibroEntity> libroOptional = repository.findById(id);
		
		try {			
			LibroDTO dto = new LibroDTO();
			LibroEntity libro = libroOptional.get();
			
			dto.setId(id);
			dto.setTitulo(libro.getTitulo());
			dto.setAutor(libro.getAutor());
			dto.setImagen(libro.getImagen());
			dto.setDescripcion(libro.getDescripcion());
			dto.setPrecio(libro.getPrecio());			
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// --- CRUD Method - Save
	@Transactional
	public LibroDTO save(LibroDTO dto) throws Exception {
		
		LibroEntity libro = new LibroEntity();		
		libro.setId(dto.getId());
		libro.setTitulo(dto.getTitulo());
		libro.setAutor(dto.getAutor());
		libro.setImagen(dto.getImagen());
		libro.setDescripcion(dto.getDescripcion());
		libro.setPrecio(dto.getPrecio());
		
		try {			
			libro = (LibroEntity) repository.save(libro);
			dto.setId(libro.getId());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	// --- CRUD Method - Update
	@Transactional
	public LibroDTO update(LibroDTO dto, int id) throws Exception {
		
		Optional<LibroEntity> libroOptional = repository.findById(id);
		
		try {			
			LibroEntity libro = libroOptional.get();			
			libro.setId(id);
			libro.setTitulo(dto.getTitulo());
			libro.setAutor(dto.getAutor());
			libro.setImagen(dto.getImagen());
			libro.setDescripcion(dto.getDescripcion());
			libro.setPrecio(dto.getPrecio());
			
			repository.save(libro);
			dto.setId(libro.getId());			
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// --- CRUD Method - Delete
	@Transactional
	public boolean delete(int id) throws Exception {
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
				
			} else {
				throw new Exception();
			}		

		} catch (Exception e) {
			throw new Exception();
		}
	}
	
}
