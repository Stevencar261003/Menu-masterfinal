import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {
    private List<String> historial;

    public Main() {
        historial = new ArrayList<>();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.iniciarPrograma();
    }

    private void iniciarPrograma() {
        Scanner sc = new Scanner(System.in);
        Figura figura = null;

        int opcionFigura;
        do {
            System.out.println("MENU DE FIGURAS");
            System.out.println("1. TRIANGULO");
            System.out.println("2. CUADRADO");
            System.out.println("3. CIRCULO");
            System.out.println("4. PIRAMIDE");
            System.out.println("5. ESFERA");
            System.out.println("6. CUBO");
            System.out.println("7. Salir");
            System.out.print("ESCOJA LA FIGURA : ");
            opcionFigura = sc.nextInt();

            switch (opcionFigura) {
                case 1:
                    figura = new Triangulo();
                    ((Triangulo) figura).ingresarPuntos();
                    break;
                case 2:
                    figura = new Cuadrado();
                    ((Cuadrado) figura).ingresarLado();
                    break;
                case 3:
                    figura = new Circulo();
                    ((Circulo) figura).ingresarRadio();
                    break;
                case 4:
                    figura = new Piramide();
                    ((Piramide) figura).ingresarPuntos();
                    ((Piramide) figura).ingresarAltura();
                    break;
                case 5:
                    figura = new Esfera();
                    ((Esfera) figura).ingresarRadio();
                    break;
                case 6:
                    figura = new Cubo();
                    ((Cubo) figura).ingresarLado();
                    break;
                default:
                    System.out.println("Opcion error!!!.");
                    break;
            }

            if (figura != null && opcionFigura != 7 && opcionFigura != 8) {
                int opcionCalculo = 0;
                do {
                    System.out.println("\n SUB MENU ");
                    if (figura instanceof Esfera) {
                        System.out.println("1. NO POSEE PERIMETRO");
                        System.out.println("2. AREA SUPERFICIAL");
                        System.out.println("3. VOLUMEN");
                    } else {
                        System.out.println("1. PERIMETRO");
                        if (figura instanceof Piramide || figura instanceof Cubo) {
                            System.out.println("2. Calcular área superficial");
                            System.out.println("3. Calcular volumen");
                        } else {
                            System.out.println("2. Calcular área");
                        }
                    }

                    switch (opcionCalculo) {
                        case 1:
                            double perimetro = figura.calcularPerimetro();
                            System.out.println("El perímetro es: " + perimetro);
                            agregarFigura(figura, "Perímetro: " + perimetro);
                            break;
                        case 2:
                            if (figura instanceof Piramide) {
                                double areaSuperficial = ((Piramide) figura).calcularArea();
                                System.out.println("El área superficial es: " + areaSuperficial);
                                agregarFigura(figura, "Área superficial: " + areaSuperficial);
                            } else if (figura instanceof Esfera) {
                                double areaSuperficial = ((Esfera) figura).calcularAreaSuperficial();
                                System.out.println("El área superficial es: " + areaSuperficial);
                                agregarFigura(figura, "Área superficial: " + areaSuperficial);
                            } else if (figura instanceof Cubo) {
                                double areaSuperficial = ((Cubo) figura).calcularAreaSuperficial();
                                System.out.println("El área superficial es: " + areaSuperficial);
                                agregarFigura(figura, "Área superficial: " + areaSuperficial);
                            } else {
                                double area = figura.calcularArea();
                                System.out.println("El área es: " + area);
                                agregarFigura(figura, "Área: " + area);
                            }
                            break;
                        case 3:
                            if (figura instanceof Piramide) {
                                double volumen = ((Piramide) figura).calcularVolumen();
                                System.out.println("El volumen es: " + volumen);
                                agregarFigura(figura, "Volumen: " + volumen);
                            } else if (figura instanceof Esfera) {
                                double volumen = ((Esfera) figura).calcularVolumen();
                                System.out.println("El volumen es: " + volumen);
                                agregarFigura(figura, "Volumen: " + volumen);
                            } else if (figura instanceof Cubo) {
                                double volumen = ((Cubo) figura).calcularVolumen();
                                System.out.println("El volumen es: " + volumen);
                                agregarFigura(figura, "Volumen: " + volumen);
                            } else {
                                System.out.println("Opción inválida. Intente nuevamente.");
                            }
                            break;
                        case 4:
                            System.out.println();
                            break;
                        default:
                            System.out.println("Opción inválida. Intente nuevamente.");
                            break;
                    }
                } while (opcionCalculo != 4);
            }

        } while (opcionFigura != 8);
    }

    public void agregarFigura(Figura figura, String resultado) {
        historial.add(figura.getClass().getSimpleName() + ": " + resultado);
    }

    public void mostrarHistorial() {
        System.out.println("\nHISTORIAL:");
        if (historial.isEmpty()) {
            System.out.println("No hay figuras en el historial.");
        } else {
            for (String item : historial) {
                System.out.println(item);
            }
        }
    }
}
