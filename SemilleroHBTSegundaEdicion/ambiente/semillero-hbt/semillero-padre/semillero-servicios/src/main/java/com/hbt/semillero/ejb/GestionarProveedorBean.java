package com.hbt.semillero.ejb;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Proveedor;

/**
 * <b>Descripción:<b> Clase que determina la gestion del proveedor <b>Caso de
 * Uso:<b>
 * 
 * @author Leo
 * @version
 */
@Stateless
public class GestionarProveedorBean implements IGestionarProveedorLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * para que funcione bien necesitamos que entre un proveedorDTO debe guardar
	 * informacion en la base de datos REQUIRES_NEW pregunta si hay una transaccion
	 * activa, entonces crea una nueva y si no tiene una transaccion entonces crea
	 * una nueva
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarProveedorLocal#crearProveedor(com.hbt.semillero.dto.ProveedorDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO) {
		
		if (validarNombre(proveedorDTO.getPersona().getNombre())) {
			return null;
		}
		
		Proveedor proveedor = convertirProveedorDTOToProveedor(proveedorDTO);
		em.persist(proveedor);
		return null;
		
	}

	/**
	 * 
	 * Metodo encargado de validar si un proveedo tiene un nombre unico
	 * <b>Caso de Uso</b>
	 * @author soporte_it_manizales
	 * 
	 * @param nombre
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	private Boolean validarNombre(String nombre) {

		List<Persona> personas = (List<Persona>) em.createQuery("select p from Persona").getResultList();
		if (personas != null) {

			for (int i = 0; i < personas.size(); i++) {
				if (personas.get(i).getNombre().equals(nombre)) {
					return true;
				}
			}

		}
		return null;

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
