package bookstore.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Novedades")
public class NovedadEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="Titulo", length=100)
	private String titulo;
	
	@Column(name="Imagen", length=500)
	private String imagen;
	
	@Column(name="Descripcion", length=500)
	private String descripcion;
	

	// --- Constructors ---
	public NovedadEntity() {}
	public NovedadEntity(int id, String titulo, String descripcion, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
}
