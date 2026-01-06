import java.util.Scanner;

public class CuadradoMagico {
   Scanner t = new Scanner(System.in);

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

   public static void main(String[] args) {

   }
}
