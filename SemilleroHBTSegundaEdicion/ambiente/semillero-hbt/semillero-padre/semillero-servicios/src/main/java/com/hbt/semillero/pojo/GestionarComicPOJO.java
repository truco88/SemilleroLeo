package com.hbt.semillero.pojo;

import java.util.List;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;


public class GestionarComicPOJO {
	
	private List<ComicDTO> listaComics = null;
	
	public void crearComicDTO() {
		ComicDTO comicdto = new ComicDTO();
		//TODO 
		//Continuar llenando comicDTO sesion del jueves
		
	}
	
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
	
	
}
