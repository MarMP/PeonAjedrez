package org.iesalandalus.programacion.peonajedrez;

public class Posicion {

	private int fila;
	private char columna;

	//Constructor con parámetros
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	
	public int getFila() {
		return fila;
	}

	public char getColumna() {
		return columna;
	}

	private void setFila(int fila) {
		if (fila < 1 || fila > 8) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else {
			this.fila = fila;
		}

	}

	private void setColumna(char columna) {
		if (columna < 'a' || columna > 'h') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		} else {
			this.columna = columna;
		}

	}
	
	
	
	

}
