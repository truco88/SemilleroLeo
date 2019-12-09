package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.dto.PersonaDTO;

/**
 * 
 * <b>Descripción:<b> Clase ProveedorDTO <b>Caso de Uso:<b>
 * 
 * @author soporte_it_manizales
 * @version
 */
public class ProveedorDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String direccion;
	private LocalDate fechaCreacion;
	private EstadoEnum estadoEnum;
	private PersonaDTO personaDTO;
	private BigDecimal montoCredito;

	/**
	 * Constructor de la clase.
	 */
	public ProveedorDTO() {

	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param id
	 * @param direccion
	 * @param fechaCreacion
	 * @param estado
	 * @param persona
	 * @param montoCredito
	 */
	public ProveedorDTO(Long id, String direccion, LocalDate fechaCreacion, EstadoEnum estadoEnum, PersonaDTO personaDTO,
			BigDecimal montoCredito) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.personaDTO = personaDTO;
		this.montoCredito = montoCredito;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * 
	 * @return El id asociado a la clase
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * 
	 * @param id El nuevo id a modificar.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo direccion
	 * 
	 * @return El direccion asociado a la clase
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo direccion
	 * 
	 * @param direccion El nuevo direccion a modificar.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * 
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * 
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * @return El estadoEnum asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo personaDTO
	 * @return El personaDTO asociado a la clase
	 */
	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo personaDTO
	 * @param personaDTO El nuevo personaDTO a modificar.
	 */
	public void setPersonaDTO(PersonaDTO persona) {
		this.personaDTO = persona;
	}


	/**
	 * Metodo encargado de retornar el valor del atributo montoCredito
	 * 
	 * @return El montoCredito asociado a la clase
	 */
	public BigDecimal getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo montoCredito
	 * 
	 * @param montoCredito El nuevo montoCredito a modificar.
	 */
	public void setMontoCredito(BigDecimal montoCredito) {
		this.montoCredito = montoCredito;
	}
	
	public static ProveedorDTO valueOf(String arg) {
		return JsonUtils.valueOf(arg, ProveedorDTO.class);
	}

	@Override
	public String toString() {
		return JsonUtils.toStringJson(this);
	}
	
	/**
	 * @see java.lang.Object#hashCode() Este método viene a complementar al método
	 *      equals y sirve para comparar objetos de una forma más rápida en
	 *      estructuras Hash ya que únicamente nos devuelve un número entero. Cuando
	 *      Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet
	 *      etc) primero invoca al método hashcode y luego el equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((estadoEnum == null) ? 0 : estadoEnum.hashCode());
		result = prime * result + ((fechaCreacion == null) ? 0 : fechaCreacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((montoCredito == null) ? 0 : montoCredito.hashCode());
		result = prime * result + ((personaDTO == null) ? 0 : personaDTO.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProveedorDTO other = (ProveedorDTO) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estadoEnum == null) {
			if (other.estadoEnum != null)
				return false;
		} else if (!estadoEnum.equals(other.estadoEnum))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (montoCredito == null) {
			if (other.montoCredito != null)
				return false;
		} else if (!montoCredito.equals(other.montoCredito))
			return false;
		if (personaDTO == null) {
			if (other.personaDTO != null)
				return false;
		} else if (!personaDTO.equals(other.personaDTO))
			return false;
		return true;
	}

}
