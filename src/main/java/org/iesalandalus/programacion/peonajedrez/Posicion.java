package org.iesalandalus.programacion.peonajedrez;

import java.util.Objects;

public class Posicion {

	private int fila;
	private char columna;

	// Constructor con parámetros
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}

	// Constructor copia
	public Posicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();
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

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Posicion)) {
			return false;
		}
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	@Override
	public String toString() {
		return "fila=" + fila + ", columna=" + columna;
	}

}
