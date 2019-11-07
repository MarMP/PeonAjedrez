package org.iesalandalus.programacion.peonajedrez;

import javax.naming.OperationNotSupportedException;

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

	// Constructor con param color y columna inicial
	public Peon(Color color, char columnaInicial) {
		setColor(color);

		if (columnaInicial < 'a' || columnaInicial > 'h') {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		if (color.equals(Color.BLANCO)) {
			this.posicion = new Posicion(2, columnaInicial);
		}
		if (color.equals(Color.NEGRO)) {
			this.posicion = new Posicion(7, columnaInicial);
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
	
	public void mover(Direccion direccion) throws OperationNotSupportedException {

		if (direccion == null) {
			throw new NullPointerException("ERROR: Mover el peón en una dirección nula no está permitido.");
		}

		switch (direccion) {

			case IZQUIERDA:
				try {
					if (color.equals(color.BLANCO)) {
						posicion = new Posicion(posicion.getFila() +1, (char) (posicion.getColumna() - 1));	
					}
					if (color.equals(color.NEGRO)) {
						posicion = new Posicion(posicion.getFila() -1, (char) (posicion.getColumna() - 1));	
					}
					
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
				break;

			case DERECHA:
				try {
					if (color.equals(color.BLANCO)) {
						posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 1));
					}
					if (color.equals(color.NEGRO)) {
						posicion = new Posicion(posicion.getFila() -1, (char) (posicion.getColumna() + 1));	
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
				break;
		}
	}
	
	

	
	
}
