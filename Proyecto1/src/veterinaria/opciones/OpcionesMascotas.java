package veterinaria.opciones;
import veterinaria.Mascota;
import veterinaria.menus.Menus;
import veterinaria.Utilerias;

import veterinaria.estructuras.*;
import java.util.Scanner;
import java.util.HashMap;
import veterinaria.Cliente;

public class OpcionesMascotas {
    public static void ejecutar(setMascotas mascotas, HashMap<Integer, Cliente> clientes, Scanner entrada){
        int opcion;
        do{
            Menus.mostrarMenuMascotas();
            opcion = Utilerias.leerEntero(entrada);
            switch (opcion){
                //Registrar mascota
                case 1 -> registrarMascota(mascotas, clientes, entrada);
                //Modificar mascota
                case 2 -> System.out.println("La modificación de mascotas está pendiente de implementar.");
                //Eliminar mascota
                case 3 -> System.out.println("La eliminación de mascotas está pendiente de implementar.");
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

    public static void registrarMascota(setMascotas mascotas, HashMap<Integer, Cliente> clientes, Scanner entrada){
        System.out.println("=====Registrar Mascota=====");
        int id = mascotas.getMascotas().stream().mapToInt(Mascota::getId).max().orElse(0) + 1;
        System.out.println("ID asignado: " + id);
        System.out.print("Ingresa el nombre: ");
        String nombre = entrada.nextLine().trim();
        while(nombre.isBlank() || !Utilerias.contieneLetras(nombre)){
            System.out.print("Nombre inválido. Ingresa un nombre: ");
            nombre = entrada.nextLine().trim();
        }
        System.out.print("Ingresa el número de cliente: ");
        int numCliente = Utilerias.leerEntero(entrada);
        Cliente dueño = OpcionesClientes.asignarDueño(numCliente, clientes, entrada);
        if(dueño == null){
            System.out.println("Registro de mascota cancelado.");
            return;
        }
        // Las consultas identifican a la mascota por nombre dentro de cada dueño.
        if(dueño.getMascotas().buscarMascota(nombre)){
            System.out.println("Este cliente ya tiene una mascota registrada con ese nombre.");
            return;
        }
        System.out.print("Ingresa la edad de la mascota: ");
        short edad = Utilerias.leerShort(entrada);
        while(edad < 0){
            System.out.print("La edad no puede ser negativa. Ingresa la edad: ");
            edad = Utilerias.leerShort(entrada);
        }
        System.out.print("Especie: ");
        String especie = entrada.nextLine();
        System.out.print("Raza: ");
        String raza = entrada.nextLine();
        Mascota mascota = new Mascota(nombre, id, dueño, edad, especie, raza);
        mascotas.addMascota(mascota);
        dueño.agregarMascota(mascota);
        System.out.println("Mascota agregada con éxito!!!");
    }

    public static void modificarMascota(setMascotas mascotas){

    }

    public static void eliminarMascota(setMascotas mascotas){

    }
}



