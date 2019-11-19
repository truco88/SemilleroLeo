package com.hbt.semillero.servicios;

import java.time.LocalDate;
import java.time.Month;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPojo;

public class EjerciciosTest {

	@Test(enabled = false)
	public void testUnitario() {

		/**
		 * A$B No valido $ no es caracter alfanumerico
		 */

		/**
		 * _helloWorld Es valido dado que inicia con caracteres especiales
		 */

		/**
		 * true Es el valor correspondiente a una variable booleana
		 */

		/**
		 * java.lang importa una libreria (no valido)
		 */

		/**
		 * Public 
		 * 
		 * 
		 */

		/**
		 * 1980_s comienza con numero (no valido)
		 */
	}
	
	/**
	 * 
	 * Test que prueba ejercicio 2 <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 *
	 */
	@Test(enabled = false)
	public void ejercicio2() {
		EjerciciosPojo.ejercicioIni();
	}

	/**
	 * 
	 * Metodo encargado de validar si el numero ingresado es primo 
	 * <b>Caso de Uso</b>
	 * @author soporte_it_manizales
	 *
	 */
	@Test
	public void ejercicio3() {

		EjerciciosPojo ejercicio = new EjerciciosPojo();

		Assert.assertEquals(ejercicio.primo(5), true);
		Assert.assertEquals(ejercicio.primo(222), false);
		Assert.assertEquals(ejercicio.primo(0), false);

	}

	/**
	 * 
	 * Metodo encargado de validar la fecha de hoy sumandole a la fecha de
	 * Nacimiento el numero de años <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 *
	 */
	@Test
	public void ejercicio4() {

		EjerciciosPojo ejercicio = new EjerciciosPojo();
		Assert.assertTrue(ejercicio.validarEdad(LocalDate.of(1988, Month.JANUARY, 9), 31L));
	}

	/**
	 * 
	 * Metodo encargado de probar el ejerciico5 <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 *
	 */
	@Test(enabled = false)
	public void pruebaEjercicio5() {
		EjerciciosPojo lista = new EjerciciosPojo();
		lista.llenarLista(-2);
		lista.llenarLista(50);
		lista.llenarLista(1);
		lista.llenarLista(249);
		Assert.assertEquals(lista.datosMostrar(), "-2,249,4");
	}

	/**
	 * 
	 * Metodo encargado de probar el cambio <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 *
	 */
	@Test(enabled = false)
	public void pruebaEjercicio8() {
		int[] esperado = { 5, 1, 0, 0, 1 };
		Assert.assertEquals(EjerciciosPojo.cambio(5550), esperado);

		int[] esperado2 = { 1, 0, 0, 0, 0 };
		Assert.assertEquals(EjerciciosPojo.cambio(1000), esperado2);
	}

	/**
	 * 
	 * Metodo encargado de probar secuencia <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 *
	 */
	@Test
	public void pruebaEjercicio11() {
		EjerciciosPojo secuencia = new EjerciciosPojo();
		Assert.assertEquals(secuencia.siguiente("80", "36"), 46);

	}

}
