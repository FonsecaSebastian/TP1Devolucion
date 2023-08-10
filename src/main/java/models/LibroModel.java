package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LibroModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private Long ISBN;
	private Integer anio;
	private String titulo;
	private Integer ejemplares;
	private Integer alta;
	
	public LibroModel() {

	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getISBN() {
		return ISBN;
	}

	public void setISBN(Long iSBN) {
		ISBN = iSBN;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Integer getAlta() {
		return alta;
	}

	public void setAlta(Integer alta) {
		this.alta = alta;
	}





	public LibroModel(Integer id, Long iSBN, String titulo, Integer ejemplares, Integer alta) {

		this.id = id;
		ISBN = iSBN;
		this.titulo = titulo;
		this.ejemplares = ejemplares;
		this.alta = alta;
	}
	
	@Override
	public String toString() {
		return "LibroModel [id=" + id + ", ISBN=" + ISBN + ", titulo=" + titulo + ", ejemplares=" + ejemplares
				+ ", alta=" + alta + "]";
	}
	

}
