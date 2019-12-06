package com.hbt.semillero.ejb;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;

public interface IGestionarPersonaLocal {

	/**
	 * 
	 * Metodo encargado de Crear una Persona <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param personaDTO
	 * @return
	 */
	public ResultadoDTO crearPersona(PersonaDTO personaDTO);

	/**
	 * 
	 * Metodo encargado de Consultar Persona <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idPersona
	 * @return
	 */
	public PersonaDTO consultarPersona(Long idPersona);

}
