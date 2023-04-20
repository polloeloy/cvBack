package cv.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="informacion")
public class InformacionPersonal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1812308237880983974L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)  
	private Long id;
	private String nombre;
	private String apellido;
	private byte [] foto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


}
