package veterinaria.opciones;

import java.util.HashMap;            // Importaciones a Hashmap y a la entrada de datos del usuario.
import java.util.Scanner;

import veterinaria.Cliente;          
import veterinaria.Direccion;        
import veterinaria.Utilerias;
import veterinaria.menus.Menus;

public class OpcionesClientes {

    public static void ejecutar(HashMap<Integer, Cliente> clientes)
    {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do{
            Menus.mostrarMenuClientes();
            opcion = Utilerias.leerEntero(entrada);

            switch (opcion)
            {
                //Registrar cliente
                case 1 -> 
                {
                    registrarCliente(clientes, entrada);
                }

                //Consultar datos del cliente
                case 2 -> 
                {
                    consultarDatos(clientes, entrada);
                }

                //Regresar
                case 3 -> 
                {
                    System.out.println("Regresando...");
                }

                default -> 
                {
                    System.out.println("Ingresa una opción válida...");
                }

            }

        }while(opcion != 3);

    }

    public static void registrarCliente(HashMap<Integer, Cliente> clientes, Scanner entrada)
    {

        System.out.println("---Registrar cliente---");

        System.out.print("Numero de cliente: ");
        int numCliente = Utilerias.leerEntero(entrada);

        if(clientes.containsKey(numCliente))
        {
            System.out.println("Ya existe un cliente con ese numero.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Telefono: ");
        String telefono = entrada.nextLine();

        System.out.println("---Direccion---");

        System.out.print("Calle: ");
        String calle = entrada.nextLine();

        System.out.print("Numero: ");
        short numero = entrada.nextShort();
        entrada.nextLine();

        System.out.print("Colonia: ");
        String colonia = entrada.nextLine();

        System.out.print("Alcaldia: ");
        String alcaldia = entrada.nextLine();

        System.out.print("Estado: ");
        String estado = entrada.nextLine();

        System.out.print("Codigo postal: ");
        String codigoPostal = entrada.nextLine();

        Direccion direccion = new Direccion(
                calle,
                numero,
                colonia,
                alcaldia,
                estado,
                codigoPostal
        );

        Cliente cliente = new Cliente(
                numCliente,
                nombre,
                telefono,
                direccion
        );

        clientes.put(numCliente, cliente);

        System.out.println("Cliente registrado correctamente.");

    }

    public static void consultarDatos(HashMap<Integer, Cliente> clientes, Scanner entrada){

        System.out.println("---Consultar cliente---");

        System.out.print("Numero de cliente: ");
        int numCliente = Utilerias.leerEntero(entrada);

        Cliente cliente = clientes.get(numCliente);

        if(cliente == null)
        {
            System.out.println("No existe un cliente con ese numero.");
            return;
        }

        cliente.imprimirInformacion();

    }

}