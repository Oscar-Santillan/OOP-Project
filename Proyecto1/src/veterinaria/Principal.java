package veterinaria;
import veterinaria.menus.Menus;
import veterinaria.opciones.*;
import java.util.Scanner;
import veterinaria.estructuras.*;
import java.util.HashMap;

public class Principal {
    public static void main(String[] args) {
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        setMascotas mascotas = new setMascotas();
        listConsultas consultas = new listConsultas();
        Scanner entrada = new Scanner(System.in);

        int opcion;

        do{
            Menus.mostrarMenuPrincipal();
            opcion = Utilerias.leerEntero(entrada);
            switch(opcion){
                case 1 ->{
                    OpcionesMascotas.ejecutar(mascotas, clientes, entrada);
                }
                case 2 ->{
                    OpcionesClientes.ejecutar(clientes, entrada);
                }
                case 3 ->{
                    OpcionesConsultas.ejecutar(clientes, consultas, entrada);
                }
                case 4 ->{
                    System.out.println("Saliendo...");
                }
                default -> {
                    System.out.println("Ingresa una opción válida...");
                }
            }
        }while(opcion != 4);

    }

}
