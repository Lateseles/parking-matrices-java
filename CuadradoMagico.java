import java.util.Scanner;

public class CuadradoMagico {
   static final Scanner t = new Scanner(System.in);

   // **********ENTRADA SALIDA**********
   private static void rellenaCuadro(int[][] cuadrado) {
      System.out.println("Introduzca los valores de su cuadrado\n");
      for (int i = 0; i < cuadrado.length; i++) {
         System.out.printf("Introduzca los valores de la fila %d: ", i);
         for (int j = 0; j < cuadrado.length; j++)
            cuadrado[i][j] = t.nextInt();
      }
   }

   private static void mostrarCuadrado(int[][] cuadrado) {
      for (int i = 0; i < cuadrado.length; i++) {
         for (int j = 0; j < cuadrado[i].length; j++) {
            System.out.printf("%2d ", cuadrado[i][j]);
         }
         System.out.println();
      }
   }

   private static void mostrarSumas(String mensaje, int[] sumas) {
      for (int i = 0; i < sumas.length; i++)
         System.out.println(mensaje + i + " = " + sumas[i]);
   }

   // **********SUMAR LAS LINEAS NECESARIAS**********
   private static int sumaFila(int fila, int[][] cuadrado) {
      int suma = 0;

      for (int i = 0; i < cuadrado[fila].length; i++)
         suma += cuadrado[fila][i];

      return suma;
   }

   private static int sumaColumna(int columna, int[][] cuadrado) {
      int suma = 0;

      for (int i = 0; i < cuadrado.length; i++)
         suma += cuadrado[i][columna];

      return suma;
   }

   private static int sumaDiagonalPrincipal(int[][] cuadrado) {
      int suma = 0;

      for (int i = 0; i < cuadrado.length; i++)
         suma += cuadrado[i][i];

      return suma;
   }

   private static int sumaDiagonalSecundaria(int[][] cuadrado) {
      int suma = 0;

      for (int i = 0; i < cuadrado.length; i++)
         suma += cuadrado[i][cuadrado.length - 1 - i];

      return suma;
   }

   // **********Auxiliares**********
   private static void calculaSumas(int[][] cuadrado, int[] sumaFilas, int[] sumaColumnas) {
      for (int i = 0; i < cuadrado.length; i++) {
         sumaFilas[i] = sumaFila(i, cuadrado);
         sumaColumnas[i] = sumaColumna(i, cuadrado);
      }
   }

   private static boolean sonIguales(int[] filas, int[] columnas, int principal, int secundaria) {
      final int constanteMagica = filas[0];

      for (int i = 0; i < filas.length; i++) {
         if (filas[i] != constanteMagica || columnas[i] != constanteMagica)
            return false;
      }
      if (principal != constanteMagica || secundaria != constanteMagica)
         return false;

      return true;
   }

   public static void main(String[] args) {
      int tamMatriz;
      int[][] cuadrado;
      int[] sumaFilas, sumaColumnas;
      int sumaPrincipal, sumaSecundaria;
      boolean isMagico;

      // 1. Solicitar al usuario el tamaño N de la matriz cuadrada (N ≥ 3).
      System.out.print("Introduzca el tamaño que debe tener su cuadrado: ");
      tamMatriz = t.nextInt();
      // 2. Crear una matriz NxN de números enteros.
      cuadrado = new int[tamMatriz][tamMatriz];
      // 3. Permitir introducir los valores de la matriz por teclado
      rellenaCuadro(cuadrado);
      // 4. Mostrar la matriz por pantalla con formato de tabla.
      System.out.println();
      mostrarCuadrado(cuadrado);
      System.out.println();
      // 5. Calcular
      sumaFilas = new int[tamMatriz];
      sumaColumnas = new int[tamMatriz];
      sumaPrincipal = sumaDiagonalPrincipal(cuadrado);
      sumaSecundaria = sumaDiagonalSecundaria(cuadrado);

      calculaSumas(cuadrado, sumaFilas, sumaColumnas);
      mostrarSumas("Suma de la fila ", sumaFilas);
      mostrarSumas("Suma de la columna ", sumaColumnas);
      System.out.println("Suma de la diagonal principal " + sumaPrincipal);
      System.out.println("Suma de la diagonal secundaria " + sumaSecundaria);
      // 6. Comprobar si todas las sumas son iguales
      isMagico = sonIguales(sumaFilas, sumaColumnas, sumaPrincipal, sumaSecundaria);
      // 7. Indicar claramente si la matriz es mágica o no mágica.
      System.out.println(isMagico ? "Es un cuadrado mágico" : "No es un cuadrado mágico");

   }
}
