package org.iesalandalus.programacion.peonajedrez;

public class Peon {

	private Color color;
	private Posicion posicion;

	// Peón por defecto negro en la posición 7d
	public Peon() {
		this.color = Color.NEGRO;
		this.posicion = new Posicion(7, 'd');
	}

	// Constructor con parámetro color
	public Peon(Color color) {
		setColor(color);

		if (color.equals(Color.BLANCO)) {
			this.posicion = new Posicion(2, 'd');
		}
		if (color.equals(Color.NEGRO)) {
			this.posicion = new Posicion(7, 'd');
		}
	}

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
