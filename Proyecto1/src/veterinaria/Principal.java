package veterinaria;
import veterinaria.menus.Menus;
import veterinaria.opciones.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Principal {
    public static void main(String[] args) {
        HashMap<Integer, Cliente> clientes = new HashMap<>();
        HashSet<Mascota> mascotas = new HashSet<>();
        ArrayList<Consulta> historicoConsultas = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        int opcion;

        do{
            Menus.mostrarMenuPrincipal();
            opcion = Utilerias.leerEntero(entrada);
            switch(opcion){
                //OpcionesMascotas
                case 1 ->{
                    OpcionesMascotas.ejecutar(mascotas);
                }
                //Clientes
                case 2 ->{
                    OpcionesClientes.ejecutar(clientes);
                }
                //Consultas
                case 3 ->{
                    OpcionesConsultas.ejecutar();
                }
                //Salir
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
