package com.hbt.semillero.ejb;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
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
	 * Metodo encargado de validar si un proveedo tiene un nombre unico <b>Caso de
	 * Uso</b>
	 * 
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
	 * 
	 * Metodo encargado de modificar el nombre del proveedor 
	 * <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @param nombreProveedor
	 * @param montoCredito
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void modificarProveedor(String idProveedor, String nombreProveedor, BigDecimal montoCredito,
			ProveedorDTO proveedorNuevo, PersonaDTO personaNueva) {
		
		Proveedor proveedorModificar;
		Persona personaModificar;

		if (proveedorNuevo != null) {
			proveedorModificar = em.find(Proveedor.class, idProveedor);
			personaModificar = em.find(Persona.class, proveedorModificar.getId());

		} else {
			proveedorModificar = convertirProveedorDTOToProveedor(proveedorNuevo);
			personaModificar = convertirPersonaDTOToPersona(personaNueva);

		}

		proveedorModificar.setMontoCredito(montoCredito);
		personaModificar.setNombre(nombreProveedor);
		em.merge(personaModificar);
		em.merge(proveedorModificar);

	}

	/**
	 * 
	 * Metodo encargado de modificar el estado de un Proveedor 
	 * <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void cambiarEstado(String idProveedor, EstadoEnum estado, ProveedorDTO nuevo) {

		// validar que el id no este nullo y el estado
		if (idProveedor != null && !idProveedor.equals("")) {

			// consultar el proveedor usando entityManager
			Proveedor proveedor = em.find(Proveedor.class, idProveedor);

			// convertir estado String a estadoEnum
			proveedor = convertirProveedorDTOToProveedor(nuevo);
			proveedor.setEstado(estado);

			// si el estado es diferente se hace la actualizacion
			em.merge(proveedor);

		}

	}

	/**
	 * 
	 * Metodo encargado de Consultar el Proveedor 
	 * <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 *
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ProveedorDTO consultarProveedor(String idProveedor) {
		Proveedor proveedor = em.find(Proveedor.class, idProveedor);
		ProveedorDTO proveedorDTO = convertirProveedorToProveedorDTO(proveedor);
		return proveedorDTO;

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

	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if (proveedor.getId() != null) {
			proveedorDTO.setId(proveedor.getId().toString());
		}
		proveedorDTO.setDireccion(proveedor.getDireccion());
		proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
		proveedorDTO.setEstado(proveedor.getEstado());
		proveedorDTO.setPersona(proveedor.getPersona());
		proveedorDTO.setMontoCredito(proveedor.getMontoCredito());

		return proveedorDTO;

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
		if (personaDTO.getId() != null) {
			persona.setId(personaDTO.getId());
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		return persona;
	}

}
