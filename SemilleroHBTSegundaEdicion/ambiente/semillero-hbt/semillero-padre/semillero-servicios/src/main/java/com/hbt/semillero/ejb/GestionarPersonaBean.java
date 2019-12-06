package com.hbt.semillero.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Persona;

/**
 * 
 * <b>Descripción:<b> Clase que determina la gestion de Persona 
 * <b>Caso de Uso:<b>
 * 
 * @author soporte_it_manizales
 * @version
 */
@Stateless
public class GestionarPersonaBean implements IGestionarPersonaLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * Metodo encargado de metodo encargado de crear una persona <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param personaDTO
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {

		Persona persona = convertirPersonaDTOToPersona(personaDTO);
		em.persist(persona);
		return null;

	}

	/**
	 * 
	 * Metodo encargado de Consultar una Persona <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idPersona
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO consultarPersona(Long idPersona) {
		Persona persona = em.find(Persona.class, idPersona);
		PersonaDTO personaDTO = convertirPersonaToPersonaDTO(persona);
		return personaDTO;

	}

	/**
	 * 
	 * Metodo encargado de transformar un personaDTO a una persona
	 * 
	 * @param comic
	 * @return
	 */
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		if (personaDTO != null && personaDTO.getId() != null) {
			persona.setId(personaDTO.getId());
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		return persona;
	}
	
	/**
	 * 
	 * Metodo encargado de un persona a una personaDTO
	 * <b>Caso de Uso</b>
	 * @author soporte_it_manizales
	 * 
	 * @param persona
	 * @return
	 */
	public PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (persona != null && persona.getId() != null) {
			personaDTO.setId(persona.getId());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
		return personaDTO;

	}

}
