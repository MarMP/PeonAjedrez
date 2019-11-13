package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	static Peon peon = null;
	static boolean salir = false;
	static Direccion direccion = null;

	public static void main(String[] args) {

		System.out.println("Programa para aprender a colocar y mover un peón en el tablero de ajedrez");
		System.out.println("-------------------------------------------------------------------------");

		mostrarPeon();

		while (!salir) {
			//mostrarMenu();
			//ejecutarOpcion(elegirOpcion());
		}

	}

	private static void mostrarPeon() {
		System.out.print("Representación del peón: ");
		if (peon == null) {
			System.out.println("Tiene que crear un peón para poder hacer uso de él. ");
			System.out.println(" ");
		} else {
			System.out.println(peon.toString());
		}
	}


}
