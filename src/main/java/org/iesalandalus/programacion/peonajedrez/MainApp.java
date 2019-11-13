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
	
	private static Color elegirColor() {
		Color color = null;
		boolean validarColor = false;

		do {
			System.out.println("Escoja un color para su peón: blanco o negro.");
			System.out.println("1. Color blanco.");
			System.out.println("2. Color negro.");
			System.out.println("Introduzca la opción del color.");
			System.out.println(" ");
			int opcion = Entrada.entero();
			switch (opcion) {
			case 1:
				color = Color.BLANCO;
				validarColor = true;
				break;
			case 2:
				color = Color.NEGRO;
				validarColor = true;
				break;
			default:
				System.out.println("Opción errónea.");
			}

		} while (!validarColor);

		return color;
	}
	
	private static char elegirColumnaInicial() {
		char columnaInicial = 'a';
		do {
			System.out.println("Introduzca una columna inicial válida: a-h");
			columnaInicial = Entrada.caracter();
		} while (columnaInicial < 'a' || columnaInicial > 'h');

		return columnaInicial;
	}

	private static void mostrarMenuMovimientos() {
		System.out.println("Movimientos posibles: ");
		System.out.println("1: Avanzar 1 paso el peón.");
		System.out.println("2. Avanzar 2 pasos el peón.");
		System.out.println("3. Mover izquierda.");
		System.out.println("4. Mover derecha.");
		System.out.println(" ");
	}

	private static int elegirMovimiento() {
		int opcion;
		do {
			System.out.println("Por favor, introduzca la opción del menú que desee realizar: ");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 4);

		return opcion;
	}
}
