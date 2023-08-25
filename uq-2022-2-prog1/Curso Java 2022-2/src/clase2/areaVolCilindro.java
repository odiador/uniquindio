package clase2;
public class areaVolCilindro {
	public static double calcArea (double r,double h) {
		double area = 2* Math.PI * r*(h+r);
		return area;
	}
	public static double calcVol (double r,double h) {
		double vol = Math.PI *Math.pow(r, 2)*h;
		return vol;
	}
	public static void main(String[] args) {
		double radio,altura,area,volumen;
		radio= base.leerDouble("Ingrese el radio del cilindro");
		altura = base.leerDouble("Ingrese la altura del cilindro");
		area = calcArea(radio,altura);
		volumen = calcVol(radio,altura);
		base.imprimir("El area del cilindro es "+area+" y el volumen es "+volumen+".");
	}
}