package veterinaria.opciones;
import veterinaria.Utilerias;
import veterinaria.menus.Menus;
import java.util.Scanner;

public class OpcionesClientes {
    public static void ejecutar(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            Menus.mostrarMenuClientes();
            opcion = Utilerias.leerEntero(entrada);

            switch (opcion){
                //Registrar cliente
                case 1 -> {}
                //Consultar datos del cliente
                case 2 -> {}
                //Regresar
                case 3 -> {
                    System.out.println("Regresando...");
                }
                default -> {
                    System.out.println("Ingresa una opción válida...");
                }

            }

        }while(opcion != 3);

    }

    public static void registrarCliente(){

    }

    public static void consultarDatos(){

    }

}
