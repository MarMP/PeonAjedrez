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
	
	private static void mostrarMenu() {
		System.out.println("MENÚ DEL PROGRAMA: ");
		System.out.println("1: Crear peón por defecto.");
		System.out.println("2. Crear peón de un color: blanco o negro.");
		System.out.println("3. Crear peón de un color y en una columna inicial dada.");
		System.out.println("4. Mover peón.");
		System.out.println("5. Salir");
	}

	private static int elegirOpcion() {
		int opcion;
		do {
			System.out.println("Por favor, introduzca la opción del menú que desee realizar: ");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 5);

		return opcion;
	}

}
