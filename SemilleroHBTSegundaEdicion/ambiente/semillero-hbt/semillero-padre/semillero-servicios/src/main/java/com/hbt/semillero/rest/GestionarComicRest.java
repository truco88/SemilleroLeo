package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * Clase para crear servicio Rest
 * @author Leo
 * @version
 */
@Path("/GestionarComic")
public class GestionarComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	@GET // metodo de envio
	@Path("/Saludo")//ruta de acceso unica a nuestro recurso
	@Produces //definir el tipo de dato que se vadefinir
	public String primerRest() {
	return "Hola mundo";
		
	}
	
	@GET
	@Path("/consultarComic")
    @Produces(MediaType.APPLICATION_JSON)
	@QueryParam("idComic")
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if(idComic!=null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		
		return null;
	}

}
