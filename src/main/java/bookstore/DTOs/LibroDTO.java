package bookstore.DTOs;

import java.io.Serializable;

public class LibroDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String titulo;
	private String autor;
	private String imagen;
	private String descripcion;
	private float precio;
	
	// --- Constructors ---
		public LibroDTO() { }
		public LibroDTO(int id, String titulo, String autor, String imagen, String descripcion, float precio) {
			this.id = id;
			this.titulo = titulo;
			this.autor = autor;
			this.imagen = imagen;
			this.descripcion = descripcion;
			this.precio = precio;
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
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
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
		public float getPrecio() {
			return precio;
		}
		public void setPrecio(float precio) {
			this.precio = precio;
		}
}
