package veterinaria.opciones;
import veterinaria.Mascota;
import veterinaria.menus.Menus;
import veterinaria.Utilerias;

import veterinaria.estructuras.*;
import java.util.Scanner;

public class OpcionesMascotas {
    public static void ejecutar(setMascotas mascotas){
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

    public static void registrarMascota(setMascotas mascotas){

    }

    public static void modificarMascota(setMascotas mascotas){

    }

    public static void eliminarMascota(setMascotas mascotas){

    }
}



