package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;
	

	public ComicDTO crearComicDTO(String id, String nombre, String editorial, TematicaEnum tematicaEnum,
			String coleccion, Integer numeroPaginas, BigDecimal precio, String autores, Boolean color,
			LocalDate fechaVenta, EstadoEnum estadoEnum, Long cantidad) {

		ComicDTO comicDTO = new ComicDTO(id, nombre, editorial, tematicaEnum, coleccion, numeroPaginas, precio, autores,
				color, fechaVenta, estadoEnum, cantidad);

		return comicDTO;

	}

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Leo
	 * 
	 * @param comicDTO
	 */
	public void agregarComicDTOlista(ComicDTO comicDTO) {

		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);

	}

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Leo
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setId("100");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Comic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		if (listaComics == null) {
			listaComics = new ArrayList<ComicDTO>();
		}
		listaComics.add(comicDTO);
	}

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Leo
	 * 
	 * @param id
	 * @param nombre
	 */
	public void modificarComicDTO(String id, String nombre) {

		ComicDTO comicAModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {

			comicAModificar = listaComics.get(i);
			if (comicAModificar.getId().equals(id)) {
				comicAModificar.setNombre(nombre);
				return;
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de <b>Caso de Uso</b>
	 * 
	 * @author Leo
	 * 
	 * @param i
	 * @param comicDTO
	 */
	public void modificarComicDTO(int i, ComicDTO comicDTO) {
		listaComics.set(i, comicDTO);
	}

	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
