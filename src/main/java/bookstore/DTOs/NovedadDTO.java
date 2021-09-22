package bookstore.DTOs;

import java.io.Serializable;

public class NovedadDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private String imagen;
	private String descripcion;
	
	// --- Constructors ---
	public NovedadDTO() {}
	public NovedadDTO(int id, String titulo, String imagen, String descripcion) {
		this.id = id;
		this.titulo = titulo;
		this.imagen = imagen;
		this.descripcion = descripcion;
	}
	
	// --- Setters & Getters ---
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
