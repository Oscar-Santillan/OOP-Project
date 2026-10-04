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
                case 2 -> modificarMascota(mascotas, clientes, entrada);
                //Eliminar mascota
                case 3 -> eliminarMascota(mascotas, entrada);
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

        int id = 1;
        for (Mascota mascota : mascotas.getMascotas()) {
            if (mascota.getId() >= id) {
                id = mascota.getId() + 1;
            }
        }
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

    public static void modificarMascota(setMascotas mascotas,HashMap<Integer, Cliente> clientes, Scanner entrada){
        int opcion;

        do {
            Menus.menuEditarMascota();
            opcion = Utilerias.leerEntero(entrada);

            switch (opcion){
                //Edad
                case 1 -> {
                    System.out.print("Ingresa el ID de la mascota: ");
                    int id = Utilerias.leerEntero(entrada);

                    Mascota mascota = mascotas.buscarMascotaId(id);

                    if(mascota == null){
                        System.out.println("No está registrada esa mascota...");
                        break;
                    }

                    System.out.print("Ingresa la edad de la mascota: ");
                    short edad = Utilerias.leerShort(entrada);
                    while(edad < 0){
                        System.out.print("La edad no puede ser negativa. Ingresa la edad: ");
                        edad = Utilerias.leerShort(entrada);
                    }

                    mascota.setEdad(edad);
                    System.out.println("Edad Registrada correctamente!!!");

                }
                case 2 -> {
                    System.out.println("=====Cambio de dueño=====");

                    System.out.print("Ingresa el ID de la mascota: ");
                    int id = Utilerias.leerEntero(entrada);

                    Mascota mascota = mascotas.buscarMascotaId(id);

                    if (mascota == null) {
                        System.out.println("No está registrada esa mascota...");
                        break;
                    }

                    System.out.print("Ingresa el número de cliente: ");
                    int numCliente = Utilerias.leerEntero(entrada);

                    Cliente dueño = OpcionesClientes.asignarDueño(numCliente, clientes, entrada);

                    if (dueño == null) {
                        System.out.println("No se realizó el cambio de dueño.");
                        break;
                    }

                    if (dueño == mascota.getDueño()) {
                        System.out.println("La mascota ya pertenece a ese cliente.");
                        break;
                    }

                    if (dueño.getMascotas().buscarMascota(mascota.getNombre())) {
                        System.out.println("Este cliente ya tiene una mascota con ese nombre.");
                        break;
                    }

                    Cliente dueñoAnterior = mascota.getDueño();
                    dueñoAnterior.eliminarMascota(mascota);
                    mascota.setDueño(dueño);
                    dueño.agregarMascota(mascota);

                    System.out.println("Dueño modificado correctamente.");
                }

                //Raza
                case 3 -> {
                    System.out.print("Ingresa el ID de la mascota: ");
                    int id = Utilerias.leerEntero(entrada);

                    Mascota mascota = mascotas.buscarMascotaId(id);

                    if (mascota == null) {
                        System.out.println("No está registrada esa mascota...");
                        break;
                    }

                    System.out.print("Ingresa la raza: ");
                    String raza = entrada.nextLine();
                    while (raza.isBlank()) {
                        System.out.print("Ingresa una raza: ");
                        raza = entrada.nextLine();
                    }

                    mascota.setRaza(raza);
                    System.out.println("Raza modificada correctamente.");
                }
                //Regresar
                case 4 -> {
                    System.out.println("Regresando...");
                }
                default -> {
                    System.out.println("Ingresa una opción válida...");
                }
            }
        }while(opcion != 4);

    }

    public static void eliminarMascota(setMascotas mascotas, Scanner entrada){
        System.out.print("Ingresa el ID de la mascota: ");
        int id = Utilerias.leerEntero(entrada);

        Mascota mascota = mascotas.buscarMascotaId(id);

        if (mascota == null) {
            System.out.println("No está registrada esa mascota...");
            return;
        }

        mascota.getDueño().eliminarMascota(mascota);
        mascotas.removeMascota(mascota);
        System.out.println("Mascota eliminada correctamente.");

    }
}



