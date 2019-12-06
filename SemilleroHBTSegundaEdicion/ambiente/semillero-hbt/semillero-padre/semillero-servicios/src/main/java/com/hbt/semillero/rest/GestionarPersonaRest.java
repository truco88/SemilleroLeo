package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;


/**
 * 
 * <b>Descripción:<b> Clase que determina el servicio rest de una Persona
 * <b>Caso de Uso:<b> 
 * @author soporte_it_manizales
 * @version
 */
@Path("/GestionarPersona")
public class GestionarPersonaRest {
	
	
	/**
	 * Atriburo que permite gestionar una persona
	 */
	@EJB
	private IGestionarPersonaLocal gestionarPersonaEJB;
	
	@GET
	@Path("/conexion")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}
	
	
	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crearProveedor
	 * 
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
		gestionarPersonaEJB.crearPersona(personaDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Persona creado exitosamente");
		return resultadoDTO;

	}
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=1
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarPersona(@QueryParam("idPersona") Long idPersona) {
		if (idPersona != null) {
			PersonaDTO personaDTO = gestionarPersonaEJB.consultarPersona(idPersona);
			return personaDTO;
		}
		return null;
	}

}
















