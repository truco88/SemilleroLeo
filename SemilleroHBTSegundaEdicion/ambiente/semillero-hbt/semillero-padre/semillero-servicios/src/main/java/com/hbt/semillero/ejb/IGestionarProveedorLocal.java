package com.hbt.semillero.ejb;

import java.math.BigDecimal;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.EstadoEnum;

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
	 * Metodo encargado de modificar el nombre del proveedor
	 * <b>Caso de Uso</b>
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @param nombreProveedor
	 * @param montoCredito
	 * @param proveedorNuevo
	 * @param personaNueva
	 */
	public void modificarProveedor(String idProveedor, String nombreProveedor, BigDecimal montoCredito,
			ProveedorDTO proveedorNuevo, PersonaDTO personaNueva);
	
	
	
	/**
	 * 
	 * Metodo encargado de modificar el estado de un Porveedor
	 * <b>Caso de Uso</b>
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @param estado
	 * @param nuevo
	 */
	public void cambiarEstado(String idProveedor, EstadoEnum estado, ProveedorDTO nuevo);
	
	
	
	/**
	 * 
	 * Metodo encargado de consultar proveedor
	 * <b>Caso de Uso</b>
	 * @author soporte_it_manizales
	 * 
	 * @param idProveedor
	 * @return
	 */
	public ProveedorDTO consultarProveedor(String idProveedor);
	

}
