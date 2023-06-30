import java.util.Scanner;

public class Piramide extends Triangulo {
    private double altura;
    @Override
    public double calcularPerimetro() {
        return super.calcularPerimetro() + calcularPerimetro2();
    }

    private double calcularPerimetro2() {
        double lado1 = 0;
        lado1 = Math.sqrt(Math.pow(lado1, 2) + Math.pow(altura, 2));
        double lado2 = 0;
        lado2 = Math.sqrt(Math.pow(lado2, 2) + Math.pow(altura, 2));
        double lado3 = 0;
        lado3 = Math.sqrt(Math.pow(lado3, 2) + Math.pow(altura, 2));
        return lado1 + lado2 + lado3;
    }

    @Override
    public double calcularArea() {
        double areaBase = super.calcularArea();
        double areaLateral = calcularAreaLateral();
        return areaBase + (2 * areaLateral);
    }

    public double calcularAreaLateral() {
        double perimetroBase = calcularPerimetro();
        return perimetroBase;
    }

    public double calcularVolumen() {
        double areaBase = super.calcularArea();
        return (areaBase * altura) / 3;
    }


    public double calcularAngulo1() {
        double cosenoAngulo1 = (Math.pow(lado2, 2) + Math.pow(lado3, 2) - Math.pow(lado1, 2)) / (2 * lado2 * lado3);
        return Math.toDegrees(Math.acos(cosenoAngulo1));
    }

    public double calcularAngulo2() {
        double cosenoAngulo2 = (Math.pow(lado1, 2) + Math.pow(lado3, 2) - Math.pow(lado2, 2)) / (2 * lado1 * lado3);
        return Math.toDegrees(Math.acos(cosenoAngulo2));
    }

    public double calcularAngulo3() {
        double cosenoAngulo3 = (Math.pow(lado1, 2) + Math.pow(lado2, 2) - Math.pow(lado3, 2)) / (2 * lado1 * lado2);
        return Math.toDegrees(Math.acos(cosenoAngulo3));
    }

    @Override
    public void ingresarPuntos() {
        boolean puntosValidos = false;
        Scanner sc = new Scanner(System.in);

        while (!puntosValidos) {
            // Verificar si los puntos son colineales utilizando el método de la clase Piramide
            super.listaPuntos.clear(); // Limpiar la lista de puntos antes de ingresar nuevos puntos
            super.ingresarPuntos(); // Llama al método de la clase base para ingresar los puntos

            if (sonColineales()) {
                System.out.println("Los puntos ingresados son colineales. Vuelva a ingresar los puntos.");
            } else {
                puntosValidos = true;
            }
        }
    }



    protected boolean sonColineales() {
        Punto punto1 = listaPuntos.get(0);
        Punto punto2 = listaPuntos.get(1);
        Punto punto3 = listaPuntos.get(2);

        // Verificar si el área del triángulo formado por los puntos es cero
        double area = Math.abs(
                (punto1.getX() * (punto2.getY() - punto3.getY()) +
                        punto2.getX() * (punto3.getY() - punto1.getY()) +
                        punto3.getX() * (punto1.getY() - punto2.getY())) / 2.0
        );

        return area == 0;
    }


    public void ingresarAltura() {
        Scanner sc = new Scanner(System.in);
        double alturaIngresada;
        do {
            System.out.println("Ingrese la altura de la pirámide (debe ser mayor a cero): ");
            alturaIngresada = sc.nextDouble();
        } while (alturaIngresada <= 0);

        altura = alturaIngresada;
    }
}


