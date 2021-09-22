package bookstore.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Libros")
public class LibroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Titulo", length=50)
	private String titulo;
	
	@Column(name="Autor", length=50)
	private String autor;
	
	@Column(name="Imagen", length=500)
	private String imagen;
	
	@Column(name="Descripcion", length=500)
	private String descripcion;
	
	@Column(name="Precio", length=10, columnDefinition="Decimal default '0.00'")
	private float precio;

	// --- Constructors ---
	public LibroEntity() { }
	public LibroEntity(int id, String titulo, String autor, String imagen, String descripcion, float precio) {
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
		
		
