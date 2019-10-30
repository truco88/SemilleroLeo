package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	@Test
	public void primeraPrueba() {
		 Long resultadoEsperado = 150L;
		 Long sumando1 = 100L;
		 Long sumando2 = 50L;
		 Long resultado= sumando1+ sumando2;
		 Assert.assertEquals(resultado, resultadoEsperado);
		 resultado=200L;
		 Assert.assertNotEquals(resultado, resultadoEsperado);
	}
	
	@Test
	private String invertirCadena(String cadena) {

        String cadenaInvertida = "";

        for (int x = cadena.length() - 1; x >= 0; x--) {

                      cadenaInvertida = cadenaInvertida + cadena.charAt(x);

        }
        return cadenaInvertida;
     
	}
	
	
		
	/**
	 * Pendiente hacer un metodo que use el método ToString de la entidad COMIC
	 */
}

