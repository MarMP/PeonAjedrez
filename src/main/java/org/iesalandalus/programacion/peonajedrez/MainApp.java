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
	
	private static void realizarMovimiento(int movimiento) {

		if (direccion == null) {
			System.out
					.println("Antes de mover el peón debe crear uno. Escoja entre las diferentes opciones del menú. ");
			System.out.println(" ");
		} else {
			switch (movimiento) {
			case 1:
				try {
					peon.mover(1);
					System.out.println("El peón se ha movido. Su posición ahora es: " + peon.toString());
				} catch (OperationNotSupportedException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					peon.mover(2);
					System.out.println("El peón se ha movido. Su posición ahora es: " + peon.toString());
				} catch (OperationNotSupportedException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					peon.mover(direccion.IZQUIERDA);
					System.out.println("El peón se ha movido. Su posición ahora es: " + peon.toString());
				} catch (OperationNotSupportedException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					peon.mover(direccion.DERECHA);
					System.out.println("El peón se ha movido. Su posición ahora es: " + peon.toString());
				} catch (OperationNotSupportedException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Opción incorrecta.");
			}
		}

	}	
	
	private static void crearPeonDefecto() {
		peon = new Peon();
		System.out.println("El peón en: " + peon.toString());
	}

	private static void crearPeonColor() {
		peon = new Peon(elegirColor());
		System.out.println("El peón en: " + peon.toString());
	}
	
	private static void crearPeonColorColumna() {
		peon = new Peon(elegirColor(), elegirColumnaInicial());
		System.out.println("El peón en: " + peon.toString());
	}

	private static void mover() {
		mostrarMenuMovimientos();
		realizarMovimiento(elegirMovimiento());
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			crearPeonDefecto();
			break;
		case 2:
			crearPeonColor();
			break;
		case 3:
			crearPeonColorColumna();
			break;
		case 4:
			mover();
			break;
		case 5:
			salir = true;
			break;
		default:
			System.out.println("Opción incorrecta.");
		}
	}
}
