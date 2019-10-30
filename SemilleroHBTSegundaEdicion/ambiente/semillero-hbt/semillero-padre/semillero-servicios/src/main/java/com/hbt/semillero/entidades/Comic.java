package com.hbt.semillero.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author soporte_it_manizales
 * @version
 */
@Entity
@Table(name="COMIC")
public class Comic implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 4322034079745146450L;
	
	
	private String id;
    private String nombre;
    private String editorial;
    private String tematicaEnum;
    private String coleccion;
    private Integer numeroPaginas;
    private BigDecimal precio;
    private String autores;
    private Boolean color;
    private LocalDate fechaVenta;
    private String estadoEnum;
    private Long cantidad;
    
    
    
    
	public Comic() {
		super();
	}
	
	
	@Id
	@Column(name="SCID")
	@SequenceGenerator(allocationSize = 1, name = "COMIC_SCID_GENERATOR", sequenceName = "SEQ_COMIC")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMIC_SCID_GENERATOR")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="SCNOMBRE")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name="SCEDITORIAL")
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	@Column(name="SCTEMATICA")
	@Enumerated(value = EnumType.STRING)//recibe un string del enum
	public String getTematicaEnum() {
		return tematicaEnum;
	}
	public void setTematicaEnum(String tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}
	@Column(name="SCCOLECCION")
	public String getColeccion() {
		return coleccion;
	}
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
	@Column(name="SCNUMEROPAGINAS")
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	@Column(name="SCPRECIO")
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	@Column(name="SCAUTORES")
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}
	@Column(name="SCCOLOR")
	public Boolean getColor() {
		return color;
	}
	public void setColor(Boolean color) {
		this.color = color;
	}
	@Column(name="SCFECHA_VENTA")
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	@Column(name="SCESTADO")
	public String getEstadoEnum() {
		return estadoEnum;
	}
	public void setEstadoEnum(String estadoEnum) {
		this.estadoEnum = estadoEnum;
	}
	@Column(name="SCCANTIDAD")
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Comic [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", tematicaEnum=" + tematicaEnum
				+ ", coleccion=" + coleccion + ", numeroPaginas=" + numeroPaginas + ", precio=" + precio + ", autores="
				+ autores + ", color=" + color + ", fechaVenta=" + fechaVenta + ", estadoEnum=" + estadoEnum
				+ ", cantidad=" + cantidad + "]";
	}
	
    
    
	

}
