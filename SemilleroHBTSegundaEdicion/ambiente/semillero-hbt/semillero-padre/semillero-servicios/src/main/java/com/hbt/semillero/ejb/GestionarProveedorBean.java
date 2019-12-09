package com.hbt.semillero.ejb;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
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

		if (validarNombre(proveedorDTO.getPersonaDTO().getNombre())) {
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
	 * Metodo encargado de modificar el nombre del proveedor <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @param nombreProveedor
	 * @param montoCredito
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void modificarProveedor(Long idProveedor, String nombreProveedor, BigDecimal montoCredito,
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
	 * Metodo encargado de modificar el estado de un Proveedor <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cambiarEstado(Long idProveedor, EstadoEnum estado) {

		// validar que el id no este nullo y el estado
		if (idProveedor != null && !idProveedor.equals("")) {

			// consultar el proveedor usando entityManager
			Proveedor proveedor = em.find(Proveedor.class, idProveedor);

			// comparar el estado a estadoEnum proveedor
			if (proveedor.getEstado().equals(estado)) {

				proveedor.setEstado(estado);
				em.merge(proveedor);

			}

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
	public ProveedorDTO consultarProveedor(Long idProveedor) {
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
		if (proveedorDTO != null && proveedorDTO.getId() != null) {
			proveedor.setId(proveedorDTO.getId());
		}
		
		Persona persona = convertirPersonaDTOToPersona(proveedorDTO.getPersonaDTO());
		
		proveedor.setDireccion(proveedorDTO.getDireccion());
		proveedor.setFechaCreacion(proveedorDTO.getFechaCreacion());
		proveedor.setEstado(proveedorDTO.getEstadoEnum());
		proveedor.setPersona(persona);
		proveedor.setMontoCredito(proveedorDTO.getMontoCredito());

		return proveedor;
		
	}

	private ProveedorDTO convertirProveedorToProveedorDTO(Proveedor proveedor) {
		ProveedorDTO proveedorDTO = new ProveedorDTO();
		if (proveedor != null && proveedor.getId() != null) {
			proveedorDTO.setId(proveedor.getId());
		}
		
		PersonaDTO personaDTO = convertirPersonaToPersonaDTO(proveedor.getPersona());
		
		
		proveedorDTO.setDireccion(proveedor.getDireccion());
		proveedorDTO.setFechaCreacion(proveedor.getFechaCreacion());
		proveedorDTO.setEstadoEnum(proveedor.getEstado());
		proveedorDTO.setPersonaDTO(personaDTO);
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
		if (personaDTO != null && personaDTO.getId() != null) {
			persona.setId(personaDTO.getId());
		}
		persona.setNombre(personaDTO.getNombre());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		return persona;
	}
	
	/**
	 * 
	 * Metodo encargado de transformar un persona a una personaDTO
	 * 
	 * @param comic
	 * @return
	 */
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		if (persona != null && persona.getId() != null) {
			personaDTO.setId(persona.getId());
		}
		personaDTO.setNombre(persona.getNombre());
		personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
		return personaDTO;
	}

}
