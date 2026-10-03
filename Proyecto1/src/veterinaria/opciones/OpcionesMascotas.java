package veterinaria.opciones;
import veterinaria.Mascota;
import veterinaria.menus.Menus;
import veterinaria.Utilerias;

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

    public static void registrarMascota(HashSet<Mascota> mascotas){

    }

    public static void modificarMascota(HashSet<Mascota> mascotas){

    }

    public static void eliminarMascota(HashSet<Mascota> mascotas){

    }
}



