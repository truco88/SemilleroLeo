package com.hbt.semillero.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.entidades.EstadoEnum;


/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Leo
 * @version
 */

@Stateless
public class GestionarComicBean implements IGestionarComicLocal{
	
	@PersistenceContext
	private EntityManager em;
	
	/*
	 * para que funcione bien necesitamos que entre un comicDTO
	 * debe guardar informacion en la base de datos
	 * REQUIRES_NEW pregunta si hay una transaccion activa, entonces crea una nueva
	 * y si no tiene una transaccion entonces crea una nueva
	 * */
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {	
		
		Comic comic =convertirComicDTOToComic(comicDTO);
		em.persist(comic);
	
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		//comic.setId(comicModificar.getId());
		em.merge(comic);
		
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String id) {
		
		Comic comic = em.find(Comic.class, id);
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarTodos(){
		
		em.createNativeQuery("SELECT c from Comic").getResultList();
		List<Comic> resultados = ( List<Comic>)em.createQuery("select c from Comic").getResultList();
		return null;
	}
		
		/**
		 * Permitir modificar el nombre de un comic dado esto por medio de el id
		 * */

	
	@Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//TODO cual es el resultado de llamar a modificarComic
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if(comicNuevo==null) {
			//manejar la entidad 
			comicModificar = em.find(Comic.class, id);
		}else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
			
		}
		comicModificar.setNombre(nombre);
		//sia ctualiza en la bbdd actualiza sino inserta
		em.merge(comicModificar);
	}
	
	

	@Override
	public void eliminarComic(Long idComic) {
		// TODO primer ejercicio para entregar
		
	}

	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();// conjunto de elementos que almacena datos con cierto orden
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();// c hace referencia a toda la entidad
		for(Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		
		return resultadosComicDTO;
				
	}
	
	/**
	 * Metodo encargado para transpasar informacion de un lado a otro,
	 * no incluye manipulacion de datos
	 * SOLO los metodos (em) son los que necesitan transaccionalidad
	 * */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		
		Comic comic = new Comic();
        if(comicDTO.getId()!=null) {
            comic.setId(Long.parseLong(comicDTO.getId()));
        }
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematicaEnum());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutores());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstadoEnum());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
		
	}
	
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematicaEnum(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutores(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstadoEnum(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        
        return comicDTO;
        
    }

}


















