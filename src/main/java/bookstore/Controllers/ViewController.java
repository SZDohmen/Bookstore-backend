package bookstore.Controllers;

import org.springframework.http.ResponseEntity;

public interface ViewController <DTO> {
	public ResponseEntity<DTO> getAll();
	public ResponseEntity<DTO> getOne(int id);
	public ResponseEntity<DTO> post(DTO dto);
	public ResponseEntity<DTO> put(DTO dto, int id);
	public ResponseEntity<DTO> delete (int id);
}
