package com.hbt.semillero.ejb;

import java.math.BigDecimal;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.EstadoEnum;

/**
 * Interfaz coleccion de metodos abstractos, se especifica que se debe hacer
 * pero no su implementacion <b>Descripción:<b> Clase que determina <b>Caso de
 * Uso:<b>
 * 
 * @author soporte_it_manizales
 * @version
 */
public interface IGestionarProveedorLocal {

	/**
	 * 
	 * Metodo encargado de crear un persona y persistirlo
	 * 
	 * @author Leo
	 * 
	 * @param comicNuevo informacion nueva a crear
	 * @return
	 */
	public ResultadoDTO crearProveedor(ProveedorDTO proveedorDTO);

	/**
	 * 
	 * Metodo encargado de modificar el nombre del proveedor <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @param nombreProveedor
	 * @param montoCredito
	 * @param proveedorNuevo
	 * @param personaNueva
	 */
	public void modificarProveedor(Long idProveedor, String nombreProveedor, BigDecimal montoCredito,
			ProveedorDTO proveedorNuevo, PersonaDTO personaNueva);

	/**
	 * 
	 * Metodo encargado de modificar el estado de un Porveedor <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @param estado
	 * @param nuevo
	 */
	public void cambiarEstado(Long idProveedor, EstadoEnum estado);

	/**
	 * 
	 * Metodo encargado de consultar proveedor <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @return
	 */
	public ProveedorDTO consultarProveedor(Long idProveedor);

}
