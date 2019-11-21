package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.Persona;

/**
 * <b>Descripción:<b> Clase que determina el uso de metodos para manipular
 * informacion POJO «Plain Old Java Object», que puede interpretarse como «Un
 * objeto Java Plano». Es una instancia de una clase que no extiende ni
 * implementa nada en particular.
 * 
 * @author Leo
 * @version 1.0
 */
public class GestionarProveedorPOJO {
	
	/**
	 * Lista que permite reunir un conjunto de proveedoress
	 */
	private List<ProveedorDTO> listaProveedores = null;

	public void crearProveedorDTO() {

		/**
		 * 
		 * Metodo encargado de crear un nuevo proveedor
		 * 
		 * @author leo
		 *
		 */
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		proveedorDTO.setId("10");
		proveedorDTO.setDireccion("Cll 52 n° 39-34");
		proveedorDTO.setFechaCreacion(LocalDate.now());
		proveedorDTO.setEstado("ACTIVO");
		//proveedorDTO.setPersona(persona);
		proveedorDTO.setMontoCredito(new BigDecimal(5000));

		if (listaProveedores == null) {
			listaProveedores = new ArrayList<ProveedorDTO>();
		}
		
		listaProveedores.add(proveedorDTO);
	}

	
	/**
	 * 
	 * Metodo encargado de retornar un proveeedor dado un id determinadao
	 * 
	 * @param idProveedor identificador del proveedor a ser buscado
	 * @
	 */
	public ProveedorDTO consultarProveedorDTO(String idProveedor) {
		
		if(listaProveedores != null && !listaProveedores.isEmpty()) {
			for (int i = 0; i < listaProveedores.size(); i++) {
				if (listaProveedores.get(i).getId().equals(idProveedor)) {
					return listaProveedores.get(i);
				}
			}
		}
		return null;
	}
	
	
	

}
