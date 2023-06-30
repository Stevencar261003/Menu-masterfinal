import java.util.Scanner;

public class Triangulo extends Figura {

    double lado1;
    double lado2;
    double lado3;

    public Triangulo(double l1, double l2, double l3) {
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    public Triangulo() {
    }

    @Override
    public double calcularPerimetro() {
        lado1 = calcularDistancia(0,1);
        lado2 = calcularDistancia(0,2);
        lado3 = calcularDistancia(1,2);
        return lado1+ lado2 + lado3;
    }

    @Override
    public double calcularArea() {
        double s = calcularPerimetro()/2;
        double area = Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
        return area;
    }

}

