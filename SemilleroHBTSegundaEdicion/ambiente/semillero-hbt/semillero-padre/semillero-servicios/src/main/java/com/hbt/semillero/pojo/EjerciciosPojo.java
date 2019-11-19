package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EjerciciosPojo {

	LinkedList<Integer> list = new LinkedList<Integer>();

	/**
	 * Ejercicio 2 - Resultado del siguiente programa variable static puede usar
	 * metodos sin crear instancia de ellos
	 */
	private static String brand;
	private static boolean empty;

	public static void ejercicioIni() {

		// WaterBottle wb = new WaterBottle();
		System.out.print("Empty = " + empty);
		System.out.print(", Brand = " + brand);

	}

	/**
	 * metodo para validar si un numero es primo
	 * 
	 * @return
	 */
	public boolean primo(int n) {
		for (int i = 2; i < n; i++) {
			if (n % 0 == 0)
				return false;

		}
		return true;
	}

	/**
	 * 
	 * Metodo encargado de validar la suma de la fecha de nacimiento y la edad
	 * <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param fecha
	 * @param edad
	 * @return
	 */
	public boolean validarEdad(LocalDate fecha, Long edad) {
		LocalDate calcular = fecha.plusYears(edad);
		LocalDate fechaActual = LocalDate.now();
		if (calcular.equals(fechaActual)) {
			return true;
		}
		return false;

	}

	/**
	 * 
	 * Metodo encargado de llenar la lista <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param num
	 */
	public void llenarLista(int num) {
		list.add(num);

	}

	/**
	 * 
	 * Metodo encargado de retornar los valores <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @return
	 */
	public String datosMostrar() {

		// ordena los elementos en la lista en orden ascendente
		Collections.sort(list);

		return "" + list.getFirst() + "," + list.getLast() + "," + list.size();

	}

	/**
	 * 
	 * Metodo encargado de calcular el cambio <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param cambio
	 * @return
	 */
	public static int[] cambio(int cambio) {
		int[] cambioFinal = new int[5];
		while (cambio > 0) {
			if (cambio > 1000) {
				cambioFinal[0] += 1;
				cambio -= 1000;
			} else if (cambio > 500) {
				cambioFinal[1] += 1;
				cambio -= 500;
			} else if (cambio > 200) {
				cambioFinal[2] += 1;
				cambio -= 200;
			} else if (cambio > 100) {
				cambioFinal[3] += 1;
				cambio -= 100;
			} else if (cambio > 50) {
				cambioFinal[4] += 1;
				cambio -= 50;
			}
		}
		return cambioFinal;
	}

	/**
	 * 
	 * Ejercicio 9 <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @throws Exception
	 */
	//throws se utiliza para identidficar la lista posible de excepciones que un metodo puede lanzar
	public void ejercicio9() throws Exception {
		//throw se utiliza para lanzar explicitamente una axcepcion 
		throw new Exception();
	}

	/**
	 * 
	 * Metodo encargado de entregar el sig num <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String siguiente(String num1, String num2) {
		int sum1 = 0, sum2 = 0, sum = 0;

		for (int i = 0; i < num1.length(); i++) {
			sum1 += Integer.parseInt(num1.charAt(i) + "");
		}
		for (int i = 0; i < num2.length(); i++) {
			sum2 += Integer.parseInt(num2.charAt(i) + "");
		}

		sum = sum2 + (sum2 - sum1);
		return num(sum);

	}

	/**
	 * 
	 * Metodo encargado de retornar el siguiente numero <b>Caso de Uso</b>
	 * 
	 * @author soporte_it_manizales
	 * 
	 * @param suma
	 * @return
	 */
	public String num(int suma) {
		if (suma < 10) {
			return suma + "";
		}
		int num1 = 1;
		int num2 = 1;
		while (num1 + num2 == suma) {
			if (num2 > 9) {
				num1++;
				num2 = 1;
			}
		}
		return "" + num1 + num2;
	}
}
