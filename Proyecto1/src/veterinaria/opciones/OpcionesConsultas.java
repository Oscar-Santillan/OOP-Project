package veterinaria.opciones;
import veterinaria.menus.Menus;
import veterinaria.Mascota;
import veterinaria.Cliente;
import veterinaria.Utilerias;
import veterinaria.estructuras.listConsultas;

import java.util.Scanner;
import java.util.HashSet;
import java.time.LocalDateTime;
import java.util.HashMap;

public class OpcionesConsultas {
    public static void ejecutar(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            Menus.mostrarMenuConsultas();
            opcion = Utilerias.leerEntero(entrada);

            switch (opcion){
                //Registrar nueva consulta
                case 1 -> {}
                //Consultar el historial de consultas de la mascota
                case 2 -> {}
                //Consultar el histórico de consultas de la veterinaria
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

    public static void registrarConsulta(HashMap<Integer, Cliente> clientes,listConsultas consultas){
        /*Scanner entrada = new Scanner(System.in);
        int idCliente,folio;
        LocalDateTime fechayHora;
        String nombreMascota,motivoConsulta,diagnostico,tratamiento;

        System.out.println("=====Registrar Consultas=====");
        System.out.println("Ingrese el ID de su cliente:");
        idCliente=entrada.nextInt();
        entrada.nextLine();
        
        
        if(clientes.containsKey(idCliente)){
            Cliente cliente = clientes.get(idCliente);
            System.out.println("Ingrese el nombre de su mascota:");
            nombreMascota=entrada.nextLine();
            if(cliente.getMascotas().buscarMascota(nombreMascota)){

                System.out.println("Ingrese el folio de su Consulta:");
                folio = consultas.sizeConsulta()+1;
                System.out.println("");


            }
    


        }
        else{
            System.out.println("El ID ingresado no existe");
            System.out.print("Verifique que está bien escrito,");
            System.out.println(" de lo contrario, registre al Cliente y su respectiva Mascota");
        }
*/
    }

    public static void consultarHistorial(){

    }

    public static void consultarHistorico(){

    }
}
