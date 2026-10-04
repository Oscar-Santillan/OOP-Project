package veterinaria.opciones;
import veterinaria.Cliente;
import veterinaria.Mascota;
import veterinaria.menus.Menus;
import veterinaria.Utilerias;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class OpcionesMascotas {
    public static void ejecutar(HashSet<Mascota> mascotas){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            Menus.mostrarMenuMascotas();
            opcion = Utilerias.leerEntero(entrada);
            switch (opcion){
                //Registrar mascota
                case 1 -> {}
                //Modificar mascota
                case 2 -> {}
                //Eliminar mascota
                case 3 -> {}
                //Regresar al menú principal
                case 4 -> {
                    System.out.println("Regresando...");
                }
                default -> {
                    System.out.println("Ingresa una opción válida...");
                }
            }

        }while(opcion != 4);

    }

    public static void registrarMascota(HashSet<Mascota> mascotas, HashMap<Integer, Cliente> clientes, Scanner entrada){
        System.out.println("=====Registrar Mascota=====");

        int id = mascotas.size() + 1;
        System.out.println("ID asignado: " + id);

        System.out.print("Ingresa el nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingresa el número de cliente: ");
        int numCliente = Utilerias.leerEntero(entrada);

        do{
            Cliente dueño = OpcionesClientes.asignarDueño(numCliente, clientes,entrada);
        }while( dueño != null);

        System.out.print("Ingresa la edad de la mascota: ");
        short edad = Utilerias.leerShort(entrada);

        System.out.print("Especie: ");
        String especie = entrada.nextLine();

        System.out.print("Raza: ");
        String raza = entrada.nextLine();

        Mascota mascota = new Mascota(nombre, id, dueño, edad, especie, raza);

        System.out.println("Mascota agregada con éxito!!!");

    }

    public static void modificarMascota(HashSet<Mascota> mascotas){

    }

    public static void eliminarMascota(HashSet<Mascota> mascotas){

    }
}



