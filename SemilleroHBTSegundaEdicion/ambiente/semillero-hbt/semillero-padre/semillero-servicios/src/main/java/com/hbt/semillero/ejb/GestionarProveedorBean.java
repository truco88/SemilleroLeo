package com.hbt.semillero.ejb;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.entidades.Proveedor;

public class GestionarProveedorBean implements IGestionarProveedorLocal {

	@PersistenceContext
	private EntityManager em;

	/*
	 * para que funcione bien necesitamos que entre un comicDTO debe guardar
	 * informacion en la base de datos REQUIRES_NEW pregunta si hay una transaccion
	 * activa, entonces crea una nueva y si no tiene una transaccion entonces crea
	 * una nueva
	 * 
	 */

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearProveedor(ProveedorDTO proveedorDTO) {

		Proveedor proveedor = convertirProveedorDTOToProveedor(proveedorDTO);
		em.persist(proveedor);

	}
	
	
	
	
	
	

	/**
	 * Metodo encargado para transpasar informacion de un lado a otro, no incluye
	 * manipulacion de datos SOLO los metodos (em) son los que necesitan
	 * transaccionalidad
	 */
	private Proveedor convertirProveedorDTOToProveedor(ProveedorDTO proveedorDTO) {

		Proveedor proveedor = new Proveedor();
		if (proveedorDTO.getId() != null) {
			proveedor.setId(proveedorDTO.getId());
		}

		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		proveedor.setEstado(proveedorDTO.getEstado());
		proveedor.setPersona(proveedorDTO.getPersona());
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());

		return proveedor;

	}

}
