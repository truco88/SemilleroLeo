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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((coleccion == null) ? 0 : coleccion.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
		result = prime * result + ((estadoEnum == null) ? 0 : estadoEnum.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroPaginas == null) ? 0 : numeroPaginas.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((tematicaEnum == null) ? 0 : tematicaEnum.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comic other = (Comic) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (coleccion == null) {
			if (other.coleccion != null)
				return false;
		} else if (!coleccion.equals(other.coleccion))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (editorial == null) {
			if (other.editorial != null)
				return false;
		} else if (!editorial.equals(other.editorial))
			return false;
		if (estadoEnum == null) {
			if (other.estadoEnum != null)
				return false;
		} else if (!estadoEnum.equals(other.estadoEnum))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroPaginas == null) {
			if (other.numeroPaginas != null)
				return false;
		} else if (!numeroPaginas.equals(other.numeroPaginas))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (tematicaEnum == null) {
			if (other.tematicaEnum != null)
				return false;
		} else if (!tematicaEnum.equals(other.tematicaEnum))
			return false;
		return true;
	}
	
    
	
    
	

}
