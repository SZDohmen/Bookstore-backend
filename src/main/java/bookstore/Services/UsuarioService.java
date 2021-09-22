package bookstore.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bookstore.DTOs.UsuarioDTO;
import bookstore.Entities.UsuarioEntity;
import bookstore.Repositories.UsuarioRepository;

@Service
public class UsuarioService implements ViewService<UsuarioDTO>{

	private UsuarioRepository repository;
	
	// --- Constructor ---
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	// --- CRUD Method - GetAll
	public List<UsuarioDTO> findAll() throws Exception {
		List<UsuarioEntity> usuarios = repository.findAll();
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		try {
			for(UsuarioEntity usuario : usuarios){
				
				UsuarioDTO dto = new UsuarioDTO();				
				dto.setId(usuario.getId());
				dto.setNombre(usuario.getNombre());
				dto.setApellido(usuario.getApellido());
				dto.setDireccion(usuario.getDireccion());
				dto.setTelefono(usuario.getTelefono());
				dto.setMail(usuario.getMail());
				dto.setPassword(usuario.getPassword());
				dto.setToken(usuario.getToken());
				
				lista.add(dto);
			}
			return lista;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// --- CRUD Method - FindById
	public UsuarioDTO findById(int id) throws Exception {

		Optional<UsuarioEntity> usuarioOptional = repository.findById(id);
		
		try {			
			UsuarioDTO dto = new UsuarioDTO();
			UsuarioEntity usuario = usuarioOptional.get();
			
			dto.setId(id);
			dto.setNombre(usuario.getNombre());
			dto.setApellido(usuario.getApellido());
			dto.setDireccion(usuario.getDireccion());
			dto.setTelefono(usuario.getTelefono());
			dto.setMail(usuario.getMail());
			dto.setPassword(usuario.getPassword());
			dto.setToken(usuario.getToken());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	// --- Find by Mail
	public UsuarioDTO findByMail(String mail) throws Exception {
		Optional<UsuarioEntity> usuarioRepo = repository.findByMail(mail);
		
		try {			
			UsuarioDTO dto = new UsuarioDTO();
			UsuarioEntity usuario = usuarioRepo.get();
						
			dto.setId(usuario.getId());
			dto.setNombre(usuario.getNombre());
			dto.setApellido(usuario.getApellido());
			dto.setDireccion(usuario.getDireccion());
			dto.setTelefono(usuario.getTelefono());
			dto.setMail(mail);
			dto.setPassword(usuario.getPassword());
			dto.setToken(usuario.getToken());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	// --- CRUD Method - Save
	public UsuarioDTO save(UsuarioDTO dto) throws Exception {

		UsuarioEntity usuario = new UsuarioEntity();		
		usuario.setId(dto.getId());
		usuario.setNombre(dto.getNombre());
		usuario.setApellido(dto.getApellido());
		usuario.setDireccion(dto.getDireccion());
		usuario.setTelefono(dto.getTelefono());
		usuario.setMail(dto.getMail());
		usuario.setPassword(dto.getPassword());
		usuario.setToken(dto.getToken());
		
		try {			
			usuario = (UsuarioEntity) repository.save(usuario);
			dto.setId(usuario.getId());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	// --- CRUD Method - Update
	public UsuarioDTO update(UsuarioDTO dto, int id) throws Exception {

		Optional<UsuarioEntity> usuarioOptional = repository.findById(id);
		
		try {
			UsuarioEntity usuario = usuarioOptional.get();		
			usuario.setId(dto.getId());
			usuario.setNombre(dto.getNombre());
			usuario.setApellido(dto.getApellido());
			usuario.setDireccion(dto.getDireccion());
			usuario.setTelefono(dto.getTelefono());
			usuario.setMail(dto.getMail());
			usuario.setPassword(dto.getPassword());
			usuario.setToken(dto.getToken());
			
			repository.save(usuario);
			dto.setId(usuario.getId());
			return dto;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	// --- CRUD Method - Delete
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
