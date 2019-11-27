package com.hbt.semillero.ejb;

import com.hbt.semillero.dto.ProveedorDTO;

public interface IGestionarProveedorLocal {

	/**
	 * 
	 * Metodo encargado de crear un comic y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicNuevo informacion nueva a crear
	 */
	public void crearProveedor(ProveedorDTO proveedorNuevo);

}
