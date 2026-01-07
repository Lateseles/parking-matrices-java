public class Matriculas {

   private static String[] extraerParte(String[] matriculas, int inicio, int fin) {
      String[] matriculasDivididas = new String[matriculas.length];

      for (int i = 0; i < matriculas.length; i++) {
         matriculasDivididas[i] = matriculas[i].substring(inicio, fin);
      }

      return matriculasDivididas;
   }

   private static int cuentaInicianConPar(String[] partesNumericas) {
      int contador = 0;

      for (String matricula : partesNumericas)
         if ((matricula.charAt(0) - '0') % 2 == 0)
            contador++;

      return contador;
   }

   private static int cuentaContienenLetra(String[] partesAlfabeticas, char caracter) {
      int contador = 0;

      for (String matricula : partesAlfabeticas)
         if (matricula.contains(caracter + ""))
            contador++;

      return contador;
   }

   private static String mostrarMayor(String[] matriculas) {
      String mayor = matriculas[0];

      for (int i = 1; i < matriculas.length; i++) {
         if (matriculas[i].compareTo(mayor) > 0)
            mayor = matriculas[i];
      }

      return mayor;
   }

   public static void main(String[] args) {
      String[] matriculas = { "1234ABC", "4321BCD", "1111AAA", "9999XYZ" };
      /*
       * 1. Crear dos arrays:
       * - Uno con las partes numéricas de las matrículas.
       * - Otro con las partes alfabéticas.
       */
      String[] partesNumericas = extraerParte(matriculas, 0, 4);
      String[] partesAlfabeticas = extraerParte(matriculas, 4, 7);
      /*
       * 2. Mostrar cuántas matrículas:
       * - Empiezan por un número par.
       * - Contienen la letra A en la parte alfabética.
       * 
       */
      System.out.println(cuentaInicianConPar(partesNumericas) + " matrículas conmienzan con número par");
      System.out.println(cuentaContienenLetra(partesAlfabeticas, 'A') + " matrículas contienen el caracter A");

      // 3. Mostrar la matrícula cuya parte numérica es mayor.
      System.out.println("La matrícula con un número mas alto es: " + mostrarMayor(partesNumericas));
   }
}