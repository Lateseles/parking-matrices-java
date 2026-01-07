import java.util.Arrays;
import java.util.Scanner;

public class AnalisisPalabras {

    private static String[] leerFrase() {
        Scanner t = new Scanner(System.in);
        String frase = t.nextLine();
        return frase.split(" ");
    }

    private static String getMasLarga(String[] palabras) {
        int indiceMayor = 0;
        int tamMayor = palabras[indiceMayor].length();

        for (int i = 0; i < palabras.length; i++)
            if (palabras[i].length() > tamMayor) {
                indiceMayor = i;
                tamMayor = palabras[i].length();
            }

        return palabras[indiceMayor];
    }

    private static String getMasCorta(String[] palabras) {
        int indiceMenor = 0;
        int tamMayor = palabras[indiceMenor].length();

        for (int i = 0; i < palabras.length; i++)
            if (palabras[i].length() < tamMayor) {
                indiceMenor = i;
                tamMayor = palabras[i].length();
            }

        return palabras[indiceMenor];
    }

    public static int[] getLongitudes(String[] palabras) {
        int[] longitudes = new int[palabras.length];

        for (int i = 0; i < palabras.length; i++)
            longitudes[i] = palabras[i].length();

        return longitudes;

    }

    public static void main(String[] args) {
        // 1. Almacenar cada palabra de la frase en un array de strings.
        String[] palabras = leerFrase();

        // Mostrar: El número total de palabras.
        System.out.println("El número total de palabras es: " + palabras.length);
        // Mostrar la palabra más larga
        System.out.println("La palabras más larga es: " + getMasLarga(palabras));
        // La palabra más corta (si hay varias, mostrar la primera)
        System.out.println("La palabra más corta es: " + getMasCorta(palabras));
        // 3 Crear un array de enteros donde cada posición indique la longitud de la
        // palabra correspondiente.
        int[] longitudes = getLongitudes(palabras);
        // 4 Mostrar dicho array.
        System.out.println(Arrays.toString(longitudes));
    }

}
