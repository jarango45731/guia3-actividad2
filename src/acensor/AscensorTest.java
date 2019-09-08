package acensor;

import java.util.Scanner;

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
public class AscensorTest {
	private static Ascensor ascensor;
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while (true) {
			imprimirOpciones();
			int opcion = sc.nextInt();
			ejecutarOpcion(opcion);
		}
	}

	private static void ejecutarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			opcionCrearAscensor();
			break;
		case 2:
			opcionDeterminarSiguientePiso();
			break;
		case 3:
			opcionDeterminarPisoAnterior();
			break;
		case 4:
			opcionDeterminarCuantosPisosPuedeAtenderAscensor();
			break;
		case 0:
			System.exit(0);
		}
	}

	private static void opcionCrearAscensor() {
		System.out.println("Ingrese el numero de pisos del edificio: ");
		int numeroPisos = sc.nextInt();
		System.out.println("Ingrese el numero de sotanos del edificio: ");
		int numeroSotanos = sc.nextInt();
		ascensor = new Ascensor(numeroPisos, numeroSotanos);
	}

	private static void opcionDeterminarSiguientePiso() {
		if (ascensor == null) {
			opcionCrearAscensor();
		}
		int pisoActual = getPisoActual();
		System.out.println("Siguiente piso: " + ascensor.siguientePiso(pisoActual));
	}
	
	
	private static void opcionDeterminarPisoAnterior() {
		if (ascensor == null) {
			opcionCrearAscensor();
		}
		int pisoActual = getPisoActual();
		System.out.println("Piso anterior: " + ascensor.pisoAnterior(pisoActual));
	}

	private static void opcionDeterminarCuantosPisosPuedeAtenderAscensor() {
		if (ascensor == null) {
			opcionCrearAscensor();
		}
		System.out.println("Numero de pisos que atiende el ascensor: " + ascensor.getNumeroPisosAtiende());
	}

	private static void imprimirOpciones() {
		System.out.println("***Ascensor***");
		if (ascensor != null) {
			System.out.println("Edificio, numero de pisos: " + ascensor.getNumeroPisosEdificio() + ", numero de sotanos: " + ascensor.getNumeroSotanosEdificio());
		}
		System.out.println("Ingrese una opcion:");
		System.out.println("1 Crear ascensor.");
		System.out.println("2 Determinar siguiente piso.");
		System.out.println("3 Determinar piso anterior.");
		System.out.println("4 Determinar cuantos pisos puede atender el ascensor.");
		System.out.println("0 Salir.");
	}
	
	private static int getPisoActual() {
		System.out.println("Ingrese el piso actual:");
		return sc.nextInt();
	}
}
