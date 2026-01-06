import java.util.Scanner;

public class Parking {
   private static final Scanner t = new Scanner(System.in);
   private static final byte PLANTAS_APARCAMIENTO = 3;
   private static final byte PLAZAS_PLANTA = 5;
   private static final byte CODIGO_LIBRE = 0;
   private static final byte CODIGO_OCUPADA = 1;

   // **********ENTRADA Y SALIDA**********
   private static byte pedirEstadoPlaza(String mensaje, String error) {
      byte estado;

      do {
         System.out.print(mensaje);
         estado = t.nextByte();
         if (estado != CODIGO_LIBRE && estado != CODIGO_OCUPADA)
            System.out.print(error);
      } while (estado != CODIGO_LIBRE && estado != CODIGO_OCUPADA);

      return estado;
   }

   private static void mostrarAparcamiento(byte[][] aparcamiento) {
      for (byte i = 0; i < aparcamiento.length; i++)
         System.out.println("Planta " + i + ": " + plantaToString(i, aparcamiento) + " Plazas libres: "
               + calcularPlazasLibre(i, aparcamiento));
   }

   private static void mostrarLibresOcupadas(byte[][] aparcamiento) {
      final byte plazasLibres = calcularPlazasLibre(aparcamiento);
      final byte plazasOcupadas = (byte) (PLANTAS_APARCAMIENTO * PLAZAS_PLANTA - plazasLibres);
      System.out.printf("Plazas libres: %2d  Plazas ocupadas: %2d\n", plazasLibres, plazasOcupadas);
   }

   // **********Auxiliares**********
   private static void rellenarPlazas(byte[][] aparcamiento) {
      for (byte i = 0; i < PLANTAS_APARCAMIENTO; i++)
         for (byte j = 0; j < PLAZAS_PLANTA; j++)
            aparcamiento[i][j] = pedirEstadoPlaza(String.format("Planta %2d Plaza %2d: ", i, j),
                  String.format("Debe introducir los valores %d o %d\n", CODIGO_LIBRE, CODIGO_OCUPADA));
   }

   private static String plantaToString(byte planta, byte[][] aparcamiento) {
      StringBuilder sb = new StringBuilder(PLAZAS_PLANTA * 2);

      for (byte estado : aparcamiento[planta])
         sb.append(estado + " ");

      return sb.toString();
   }

   private static byte calcularPlazasLibre(byte planta, byte[][] aparcamiento) {
      byte resultado = 0;
      for (byte estado : aparcamiento[planta])
         if (estado == CODIGO_LIBRE)
            resultado++;

      return resultado;
   }

   private static byte calcularPlazasLibre(byte[][] aparcamiento) {
      byte resultado = 0;

      for (byte i = 0; i < PLANTAS_APARCAMIENTO; i++)
         resultado += calcularPlazasLibre(i, aparcamiento);

      return resultado;
   }

   private static byte plantaMasLibres(byte[][] aparcamiento) {
      byte planta = 0, cantidad = calcularPlazasLibre(planta, aparcamiento);
      byte cantidadAuxiliar;

      for (byte i = 1; i < PLANTAS_APARCAMIENTO; i++) {
         cantidadAuxiliar = calcularPlazasLibre(i, aparcamiento);
         if (cantidadAuxiliar > cantidad) {
            planta = i;
            cantidad = cantidadAuxiliar;
         }
      }

      return planta;
   }

   // **********Metodo principal**********
   public static void main(String[] args) {

      // 1. Declarar matriz bidimensional
      byte[][] aparcamiento = new byte[PLANTAS_APARCAMIENTO][PLAZAS_PLANTA];
      // 2.Solicitar al usuario el estado de cada plaza
      rellenarPlazas(aparcamiento);
      // 3. Mostrar el estado completo del aparcamiento
      System.out.println();
      mostrarAparcamiento(aparcamiento);
      // 4. Mostrar el numero total de plazas libres y plazas ocupadas
      System.out.println();
      mostrarLibresOcupadas(aparcamiento);
      // 5. Indicar la planta con mayor numero de plazas libres
      System.out.println();
      System.out.println("La planta con más plazas libres es la número: " + plantaMasLibres(aparcamiento));
   }
}