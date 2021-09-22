package bookstore.DTOs;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String mail;
	private String password;
	private String token;
	
	// --- Constructors ---
	public UsuarioDTO() {}
	public UsuarioDTO(int id, String nombre, String apellido, String direccion, String telefono, String mail, String password, String token) {
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
	public void setToken(String token) {
		this.token = token;
	}

}
