import java.util.Scanner;

public class Recursividad {

    // ===================== FUNCIONES RECURSIVAS =====================
    // básicamente fraccionar las operaciones //
    // 1. Factorial: n! = n * (n-1)!
    public static long factorial(int n) {
        if (n == 0 || n == 1) {      // caso base
            return 1;
        }
        return n * factorial(n - 1); // llamada recursiva
    }

    // 2. Suma de 1 a n: suma(n) = n + suma(n-1)
    public static long suma(int n) {
        if (n == 1) {                // caso base
            return 1;
        }
        return n + suma(n - 1);      // llamada recursiva
    }

    // 3. Potencia: base^exp = base * base^(exp-1)
    public static long potencia(int base, int exponente) {
        if (exponente == 0) {        // caso base: número elevado a 0 es 1
            return 1;
        }
        return base * potencia(base, exponente - 1); // llamada recursiva
    }

    // 4. Contar dígitos: se quita el último dígito dividiendo entre 10
    public static int contarDigitos(int n) {
        if (n < 0) {                 // si es negativo, lo volvemos positivo
            n = -n;
        }
        if (n < 10) {                // caso base: un solo dígito
            return 1;
        }
        return 1 + contarDigitos(n / 10); // llamada recursiva
    }

    // 5. Invertir cadena: último carácter + invertir(el resto)
    public static String invertir(String cadena) {
        if (cadena.length() <= 1) {  // caso base: vacía o de 1 letra
            return cadena;
        }
        return cadena.charAt(cadena.length() - 1)
                + invertir(cadena.substring(0, cadena.length() - 1));
    }

    // ===================== LECTURA DE DATOS =====================

    // Pide un número entero y repite la pregunta hasta que el usuario escriba uno válido
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("  Eso no es un número entero válido. Intenta de nuevo.");
            }
        }
    }

    // ===================== MENÚ =====================

    public static void mostrarMenu() {
        System.out.println();
        System.out.println("========== MENÚ DE RECURSIVIDAD ==========");
        System.out.println("1. Factorial de un número");
        System.out.println("2. Suma de 1 hasta N");
        System.out.println("3. Potencia (base y exponente)");
        System.out.println("4. Contar dígitos de un número");
        System.out.println("5. Invertir una cadena");
        System.out.println("0. Salir");
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero(sc, "Elige una opción: ");

            switch (opcion) {
                case 1: {
                    int n = leerEntero(sc, "Número (0 a 20): ");
                    if (n < 0 || n > 20) {
                        System.out.println("  Debe estar entre 0 y 20 (más grande no cabe en un long).");
                    } else {
                        System.out.println("  factorial(" + n + ") = " + factorial(n));
                    }
                    break;
                }
                case 2: {
                    int n = leerEntero(sc, "N (mayor o igual a 1): ");
                    if (n < 1) {
                        System.out.println("  N debe ser mayor o igual a 1.");
                    } else {
                        System.out.println("  suma(" + n + ") = " + suma(n));
                    }
                    break;
                }
                case 3: {
                    int base = leerEntero(sc, "Base: ");
                    int exp = leerEntero(sc, "Exponente (mayor o igual a 0): ");
                    if (exp < 0) {
                        System.out.println("  El exponente debe ser mayor o igual a 0.");
                    } else {
                        System.out.println("  potencia(" + base + ", " + exp + ") = " + potencia(base, exp));
                    }
                    break;
                }
                case 4: {
                    int n = leerEntero(sc, "Número entero: ");
                    System.out.println("  contarDigitos(" + n + ") = " + contarDigitos(n));
                    break;
                }
                case 5: {
                    System.out.print("Escribe una cadena: ");
                    String texto = sc.nextLine();
                    System.out.println("  invertir(\"" + texto + "\") = \"" + invertir(texto) + "\"");
                    break;
                }
                case 0:
                    System.out.println("¡bye bye");
                    break;
                default:
                    System.out.println("  Opción no válida. Elige un número del 0 al 5.");
            }
        }

        sc.close();
    }
}