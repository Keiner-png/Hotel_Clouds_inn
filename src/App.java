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
        int opcion;
        do {
            System.out.print("""
                    \n BIENVENIDO AL MENÚ DE FUNCIONES DEL SISTEMA DE RESERVAS
                      1.Registrar una reserva
                      2.Cancelar una reserva
                      3.Ver estado de habitaciones
                      4.Generar reporte del hotel
                      5.Salir del menú
                      Seleccione una opción por favor:
                    """);
            opcion = consola.nextInt();

            switch (opcion) {
                case 1:
                    // Registrar reserva
                    System.out.print("Ingrese el número de habitación (101-103 / 201-203 / 301-303): ");
                    int habitacion = consola.nextInt();

                    // Calcular posición en la matriz
                    int pisoHotel = (habitacion / 100) - 1;   // 101->0, 201->1
                    int numeroHabitacion = (habitacion % 100) - 1; // 101->0, 102->1

                    if (hotel[pisoHotel][numeroHabitacion]) {
                        System.out.println("La habitación ya está ocupada.");
                    } else {
                        consola.nextLine(); // limpiar buffer
                        System.out.print("Ingrese nombre del cliente: ");
                        String nombreCliente = consola.nextLine();

                        System.out.print("Ingrese número de noches: ");
                        int numeroNoches = consola.nextInt();

                        System.out.println("El precio por noche es: " + PRECIO_NOCHE );

                        // Guardar reserva en arrays
                        int index = pisoHotel * cantidadHabitacion + numeroHabitacion;
                        clientes[index] = nombreCliente;
                        noches[index] = numeroNoches;
                        total[index] = numeroNoches * PRECIO_NOCHE;

                        hotel[pisoHotel][numeroHabitacion] = true; // marcar ocupada
                        System.out.println("Reserva registrada con éxito.");
                    }
                    break;
                case 2:
                    // Cancelar reserva
                    System.out.print("Ingrese el número de habitación a cancelar: ");
                    habitacion = consola.nextInt();
                    pisoHotel = (habitacion / 100) - 1;
                    numeroHabitacion = (habitacion % 100) - 1;

                    int index = pisoHotel * cantidadHabitacion + numeroHabitacion;

                    if (hotel[pisoHotel][numeroHabitacion]) {
                        hotel[pisoHotel][numeroHabitacion] = false; // liberar
                        clientes[index] = null; // borrar datos
                        noches[index] = 0;
                        total[index] = 0;
                        System.out.println("Reserva cancelada.");
                    } else {
                        System.out.println("Esa habitación ya está libre.");
                    }
                    break;

                case 3:
                    // Ver habitaciones
                    System.out.println("\nEstado del hotel:");
                    int tamanioHotel = hotel.length;
                    for (int i = 0; i < tamanioHotel; i++) {
                        for (int j = 0; j < hotel[i].length; j++) {
                            int num = (i + 1) * 100 + (j + 1);
                            String estado = hotel[i][j] ? "Ocupada" : "Libre";
                            System.out.print(num + ": " + estado + " | ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    // Reporte
                    System.out.println("\n=== REPORTE DEL HOTEL ===");
                    int ocupadas = 0;
                    int libres = 0;
                    tamanioHotel = hotel.length;
                    for (int i = 0; i < tamanioHotel; i++) {
                        for (int j = 0; j < hotel[i].length; j++) {
                            int num = (i + 1) * 100 + (j + 1);
                            int ind = i * cantidadHabitacion + j;
                            if (hotel[i][j]) {
                                ocupadas++;
                                System.out.printf("\nHabitacion: %d | -> Cliente:  %s | -> Total: $%.3f", num, clientes[ind], total[ind]);
                            } else {
                                libres++;
                            }
                        }
                    }
                    System.out.println();
                    System.out.println("Habitaciones ocupadas: " + ocupadas);
                    System.out.println("Habitaciones disponibles: " + libres);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            
                }
        
        } while (opcion != 5);
        consola.close();
    }
}

