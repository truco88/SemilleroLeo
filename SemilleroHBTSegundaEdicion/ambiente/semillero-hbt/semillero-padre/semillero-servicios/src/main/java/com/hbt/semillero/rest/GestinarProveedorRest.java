package com.hbt.semillero.rest;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.JsonUtils;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarProveedorLocal;

/**
 * 
 * <b>Descripción:<b> Clase que determina el servicio rest de un Porveedor
 * <b>Caso de Uso:<b>
 * 
 * @author soporte_it_manizales
 * @version
 */

@Path("/GestionarProveedor")
public class GestinarProveedorRest {

	/**
	 * Atriburo que permite gestionar una persona
	 */
	@EJB
	private IGestionarProveedorLocal gestionarProveedorEJB;

	@GET
	@Path("/prueba")
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
	@Path("/crearProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO) {
		return gestionarProveedorEJB.crearProveedor(proveedorDTO);

	}
	
	
	/**
	 * 
	 * Metodo encargado de consultar proveedor 
	 * <b>Caso de Uso</b>
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @return
	 */
	@GET
	@Path("/consultarProveedor")
	@Produces(MediaType.APPLICATION_JSON)
	public ProveedorDTO consultarProveedor(@QueryParam("idProveedor") Long idProveedor) {
		if (idProveedor != null) {
			ProveedorDTO proveedorDTO = gestionarProveedorEJB.consultarProveedor(idProveedor);
			return proveedorDTO;
		}
		return null;		
	}
	
	
	
	

}
