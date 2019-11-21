package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;


/**
 * <b>Descripción:<b> Clase que determina el uso de metodos para manipular
 * informacion POJO «Plain Old Java Object», que puede interpretarse como «Un
 * objeto Java Plano». Es una instancia de una clase que no extiende ni
 * implementa nada en particular.
 * 
 * @author Leo
 * @version 1.0
 */
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
	 * Metodo encargado de cambiar el nombre a un comic con el mismo id
	 * 
	 * @author ccastano
	 * 
	 * @param comicModificar
	 */
	public void modificarComicDTO(ComicDTO comicModificar) {
		// validacion que permite determinar si una lista esta inicializada y tiene
		// elementos
		if (listaComics != null && !listaComics.isEmpty()) {
			int i = 0;
			// ciclo while que permite recorrerer una lista
			// iniciando desde cero hasta el tamaño de la lista de comics
			while (i <= listaComics.size()) {
				if (listaComics.get(i).getId().equals(comicModificar.getId())) {
					listaComics.get(i).setNombre(comicModificar.getNombre());
				}
				// atributo que permite incrementar el iterador
				// permite controlar cuando se termine el ciclo o
				// cuando terminar
				i++;
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de eliminar un elemento determinado de la lista de comic
	 * 
	 * @param comicEliminar
	 */
	public void eliminarComicDTO(ComicDTO comicEliminar) {
		// validacion que permite determinar si una lista esta inicializada y tiene
		// elementos
		if (listaComics != null && !listaComics.isEmpty()) {
			// ciclo for each
			for (ComicDTO comicIterar : listaComics) {
				// validacion del mismo id
				if (comicIterar.getId().equals(comicEliminar.getId())) {
					// metodo que permite quitar un elemento de una lista
					listaComics.remove(comicIterar);
				}
			}
		}
	}

	/**
	 * 
	 * Metodo encargado de retornar un comic dado un id determinadao
	 * 
	 * @param idComic identificador del comic a ser buscado
	 * @return comic encontrado
	 */
	public ComicDTO consultarComicDTO(String idComic) {
		// validacion que permite determinar si una lista esta inicializada y tiene
		// elementos
		if (listaComics != null && !listaComics.isEmpty()) {
			// ciclo for
			for (int i = 0; i <= listaComics.size(); i++) {
				if (listaComics.get(i).getId().equals(idComic)) {
					return listaComics.get(i);
				}
			}
		}
		return null;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * 
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * 
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}

}
