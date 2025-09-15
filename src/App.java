import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("*** HOTEL CLOUDS INN ***");
        System.out.println("*** Bienvenido al sistema de reserva de hotel ***");
        Scanner consola = new Scanner(System.in);
        // Creación de los array para almacenar los datos
        // MATRIZ DEL HOTEL: 3 pisos x 3 habitaciones (9 habitaciones en total)
        boolean[][] hotel = new boolean[3][3]; // false = libre, true = ocupada
        int cantidadHabitacion = 3 ;
        // ARRAYS PARA  ALMACENAR LOS DATOS DE LAS RESERVAS (máximo 9 habitaciones)
        String[] clientes = new String[9];
        int[] noches = new int[9];
        final double PRECIO_NOCHE = 135.900;
        double[] total = new double[9];
        int opcion;
    }
}
