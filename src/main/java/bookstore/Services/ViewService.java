package bookstore.Services;

import java.util.List;

public interface ViewService <DTO> {
	public List<DTO> findAll() throws Exception;
	public DTO findById(int id) throws Exception;
	public DTO save(DTO dto) throws Exception;
	public DTO update(DTO dto, int id) throws Exception;
	public boolean delete(int id) throws Exception;
}
