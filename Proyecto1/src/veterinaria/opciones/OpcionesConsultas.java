package veterinaria.opciones;
import veterinaria.menus.Menus;
import veterinaria.Utilerias;
import java.util.Scanner;


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

    public static void registrarConsulta(){

    }

    public static void consultarHistorial(){

    }

    public static void consultarHistorico(){

    }
}
