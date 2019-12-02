package com.hbt.semillero.ejb;

import com.hbt.semillero.dto.ProveedorDTO;
import com.hbt.semillero.dto.ResultadoDTO;

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
	
	
	
	

}
