package pendulo;

import java.util.Scanner;

public class PenduloTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la longitud:");
		double l = sc.nextDouble();
		System.out.println("Ingrese g:");
		double g = sc.nextDouble();
		Pendulo pendulo = new Pendulo(l, g);
		System.out.println("Periodo de oscilacion: " + pendulo.calcularPeriodoOscilacion());
	}

}
