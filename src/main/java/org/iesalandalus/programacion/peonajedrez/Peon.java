package org.iesalandalus.programacion.peonajedrez;

public class Peon {

	private Color color;
	private Posicion posicion;

	public Color getColor() {
		return color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setColor(Color color) {
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}

		this.color = color;
	}

	private void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new IllegalArgumentException("ERROR: Mover el peón en una dirección nula no está permitido.");
		}
		this.posicion = posicion;
	}

	
	
}
