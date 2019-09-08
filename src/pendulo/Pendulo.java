package pendulo;

public class Pendulo {
	private double longitud;
	private double aceleracionGravitacional;
	
	public Pendulo(double l, double g) {
		this.setLongitud(l);
		this.setAceleracionGravitacional(g);
	}
	
	public double calcularPeriodoOscilacion() {
		return 2 * Math.PI * Math.sqrt(this.aceleracionGravitacional / this.longitud);
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public double getAceleracionGravitacional() {
		return aceleracionGravitacional;
	}
	
	public void setAceleracionGravitacional(double aceleracionGravitacional) {
		this.aceleracionGravitacional = aceleracionGravitacional;
	}
}
