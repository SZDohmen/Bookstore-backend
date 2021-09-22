package bookstore.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Nombre", length=50, columnDefinition="varchar(50) default ' '")
	private String nombre;
	
	@Column(name="Apellido", length=50)
	private String apellido;
	
	@Column(name="Dirección", length=100)
	private String direccion;
	
	@Column(name="Telefono", length=50)
	private String telefono;
	
	@Column(name="Mail", length=50, unique=true)
	private String mail;
	
	@Column(name="Password", length=50)
	private String password;
	
	@Column(name="Token")
	private String token;

	// --- Constructors ---
	public UsuarioEntity() {}
	public UsuarioEntity(int id, String nombre, String apellido, String direccion, String telefono, String mail, String password, String token) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.mail = mail;
		this.password = password;
		this.token = token;
	}
	
	// --- Setters & Getters ---
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token){
		this.token = token;
	}
	
}
