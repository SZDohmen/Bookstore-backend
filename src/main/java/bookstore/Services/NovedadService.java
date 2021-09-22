package bookstore.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bookstore.DTOs.NovedadDTO;
import bookstore.Entities.NovedadEntity;
import bookstore.Repositories.NovedadRepository;

@Service
public class NovedadService implements ViewService<NovedadDTO>{

	private NovedadRepository repository;
	
	// --- Constructor ---
	public NovedadService(NovedadRepository repository) {
		this.repository = repository;
	}
	
	// --- Methods ---
	
	// - FindAll ------------------------------------------------
	@Transactional
	public List<NovedadDTO> findAll() throws Exception {
		List<NovedadEntity> novedades = repository.findAll();
		List<NovedadDTO> lista = new ArrayList<NovedadDTO>();
		try {
			for (NovedadEntity novedad : novedades) {
				
				NovedadDTO dto = new NovedadDTO();
				
				dto.setId(novedad.getId());
				dto.setTitulo(novedad.getTitulo());
				dto.setImagen(novedad.getImagen());
				dto.setDescripcion(novedad.getDescripcion());
				
				lista.add(dto);
			}
			return lista;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// - FindById -----------------------------------------------
	@Transactional
	public NovedadDTO findById(int id) throws Exception {

		Optional<NovedadEntity> novedadOptional = repository.findById(id);
		
		try {
			NovedadDTO dto = new NovedadDTO();
			NovedadEntity novedad = novedadOptional.get();
			
			dto.setId(novedad.getId());
			dto.setTitulo(novedad.getTitulo());
			dto.setImagen(novedad.getImagen());
			dto.setDescripcion(novedad.getDescripcion());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}

	}

	// - Save ---------------------------------------------------
	@Transactional
	public NovedadDTO save(NovedadDTO dto) throws Exception {
		
		NovedadEntity novedad = new NovedadEntity();
		novedad.setId(dto.getId());
		novedad.setTitulo(dto.getTitulo());
		novedad.setImagen(dto.getImagen());
		novedad.setDescripcion(dto.getDescripcion());
		
		try {
			novedad = (NovedadEntity) repository.save(novedad);
			dto.setId(novedad.getId());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	// - Update -------------------------------------------------
	@Transactional
	public NovedadDTO update(NovedadDTO dto, int id) throws Exception {

		Optional<NovedadEntity> novedadOptional = repository.findById(id);
				
		try {
			NovedadEntity novedad = novedadOptional.get();
			novedad.setId(dto.getId());
			novedad.setTitulo(dto.getTitulo());
			novedad.setImagen(dto.getImagen());
			novedad.setDescripcion(dto.getDescripcion());
			
			repository.save(novedad);
			dto.setId(novedad.getId());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	
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
