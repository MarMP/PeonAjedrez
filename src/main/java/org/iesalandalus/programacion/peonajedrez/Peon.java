package org.iesalandalus.programacion.peonajedrez;

import java.util.Objects;

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
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
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
			default:
				break;
		}
	}

	public void mover(int pasos) throws OperationNotSupportedException {

		// boolean salida = true; // variable booleana que controla si el peon sale de
		// la posición de inicio o no

		// if (salida == true) {
		if (posicion.getFila() == 2 || posicion.getFila() == 7) {
			switch (pasos) {
			case 1:
				try {
					if (color.equals(color.BLANCO)) {
						posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna()));
					}
					if (color.equals(color.NEGRO)) {
						posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna()));
					}

				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
				break;

			case 2:
				try {
					if (color.equals(color.BLANCO)) {
						posicion = new Posicion(posicion.getFila() + 2, (char) (posicion.getColumna()));
						// salida = false;
					}
					if (color.equals(color.NEGRO)) {
						posicion = new Posicion(posicion.getFila() - 2, (char) (posicion.getColumna()));
						// salida = false;
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException(
							"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
				}
				break;
			default:
				throw new OperationNotSupportedException("ERROR: El peón sólo se puede mover 1 o 2 pasos.");
			}

		} else {
			switch (pasos) {
			case 1:
				try {
					if (color.equals(color.BLANCO)) {
						posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna()));
					}
					if (color.equals(color.NEGRO)) {
						posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna()));
					}
				} catch (IllegalArgumentException e) {
					throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
				}
				break;
			default:
				throw new OperationNotSupportedException(
						"ERROR: El peón sólo se puede mover 2 pasos cuando se encuentra en la casilla inicial.");
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Peon)) {
			return false;
		}
		Peon other = (Peon) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return "fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ", color=" + color ;
	}
	
	
	
	
	

}
