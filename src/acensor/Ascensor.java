package acensor;

import java.security.InvalidParameterException;

/*
 * Los Ascensores son objetos que almacenan la siguiente información: el número
 * de pisos que tiene el edificio donde está el ascensor, el número de sotanos
 * que tiene el edificio. Agregue los siguientes métodos analizadores: • Un
 * método que determine cuál es sería el siguiente piso en el que quedaría el
 * ascensor si pudiera subir un piso. Por ejemplo, si el piso actual del
 * ascensor es el 3 y el piso más alto al que puede llegar es 6, entonces si el
 * ascensor sube un piso, quedaría en el piso 4. Tenga en cuenta condiciones
 * excepcionales como que no hay piso cero en las torres (es decir, después del
 * piso -1 viene el piso 1) y que no se puede subir más arriba del piso más
 * alto. • 
 * 
 * Construya un método similar al anterior para averiguar cuál sería el
 * piso al que llegaría el ascensor si desciende un piso. Tenga en cuenta las
 * reglas establecidas en el método anterior. 
 * 
 * • Construya un método que permita
 * determinar cuántos pisos puede atender el ascensor. Ejemplo: si el piso más
 * bajo para el ascensor es el -3 y el piso más alto es el 4, el ascensor puede
 * atender 7 pisos. Tenga en cuenta casos como que, si el piso más bajo es el 1
 * y el piso más alto es el 3, entonces el ascensor puede atender 3 pisos. 
 * 
 * El programa que va a construir deberá ofrecer un menú con las opciones
 * anteriores, más una opción para crear un ascensor con los atributos
 * especificados.
 */
public class Ascensor {
	private int numeroPisosEdificio;
	public int getNumeroPisosEdificio() {
		return numeroPisosEdificio;
	}

	public void setNumeroPisosEdificio(int numeroPisosEdificio) {
		this.numeroPisosEdificio = numeroPisosEdificio;
	}

	public int getNumeroSotanosEdificio() {
		return numeroSotanosEdificio;
	}

	public void setNumeroSotanosEdificio(int numeroSotanosEdificio) {
		this.numeroSotanosEdificio = numeroSotanosEdificio;
	}

	private int numeroSotanosEdificio;

	public Ascensor(int numeroPisos, int numeroSotanos) {
		if (numeroPisos <= 0) {
			throw new InvalidParameterException("parametro numeroPisos: " + numeroPisos + " debe ser mayor a 0");
		}
		if (numeroSotanos < 0) {
			throw new InvalidParameterException("parametro numeroSotanos: " + numeroPisos + " debe ser mayor o igual a 0");
		}
		this.numeroPisosEdificio = numeroPisos;
		this.numeroSotanosEdificio = numeroSotanos;
	}

	public int siguientePiso(int pisoActual) {
		if (!validarPisoActual(pisoActual)) {
			throw new InvalidParameterException("parametro pisoActual: " + pisoActual + " invalido");
		}
		if (pisoActual == this.numeroPisosEdificio) {
			return pisoActual;
		}
		if (pisoActual == -1) {
			return 1;
		}
		return ++pisoActual;
	}
	
	public int pisoAnterior(int pisoActual) {
		if (!validarPisoActual(pisoActual)) {
			throw new InvalidParameterException("parametro pisoActual: " + pisoActual + " invalido");
		}
		if (Math.abs(pisoActual) == this.numeroSotanosEdificio) {
			return pisoActual;
		}
		if (pisoActual == 1) {
			return this.numeroSotanosEdificio > 0 ? -1 : pisoActual;
		}
		return --pisoActual;
	}
	
	public int getNumeroPisosAtiende() {
		return this.numeroSotanosEdificio + this.numeroPisosEdificio;
	}
	
	private boolean validarPisoActual(int pisoActual) {
		return !(pisoActual == 0 || (pisoActual < 0 && Math.abs(pisoActual) > this.numeroSotanosEdificio) || pisoActual > this.numeroPisosEdificio);
	}
}
