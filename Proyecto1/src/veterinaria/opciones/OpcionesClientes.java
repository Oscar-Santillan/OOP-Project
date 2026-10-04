package veterinaria.opciones;

import java.util.HashMap;
import java.util.Scanner;

import veterinaria.Cliente;
import veterinaria.Direccion;
import veterinaria.Utilerias;
import veterinaria.menus.Menus;

public class OpcionesClientes 
{

    public static void ejecutar(HashMap<Integer, Cliente> clientes, Scanner entrada)
    {
        int opcion;

        do
        {
            Menus.mostrarMenuClientes();
            opcion = Utilerias.leerEntero(entrada);

            switch (opcion){
                //Registrar cliente
                case 1 -> {
                    registrarCliente(clientes, entrada);
                }

                //Consultar datos del cliente
                case 2 -> {
                    consultarDatos(clientes, entrada);
                }

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

    public static Cliente registrarCliente(HashMap<Integer, Cliente> clientes, Scanner entrada)
    {

        System.out.println("=====Registrar cliente=====");

        // El numero de cliente se asigna automaticamente
        int numCliente = clientes.keySet().stream().mapToInt(Integer::intValue).max().orElse(0) + 1;

        System.out.println("Numero de cliente asignado: " + numCliente);

        // Nombre
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        while(nombre.isBlank() || !Utilerias.contieneLetras(nombre))
        {
            System.out.print("Nombre invalido. Ingresa un nombre: ");
            nombre = entrada.nextLine();
        }

        // Telefono
        System.out.print("Telefono: ");
        String telefono = entrada.nextLine();

        while(!Utilerias.telefonoValido(telefono))
        {
            System.out.print("Telefono invalido. Ingresa 10 digitos y comienza con 55 o 56: ");
            telefono = entrada.nextLine();
        }

        System.out.println("=====Direccion=====");

        // Calle
        System.out.print("Calle: ");
        String calle = entrada.nextLine();

        while(!Utilerias.calleValida(calle))
        {
            System.out.print("Calle invalida. Debe comenzar con Calle, Avenida o Paseo: ");
            calle = entrada.nextLine();
        }

        // Numero exterior
        System.out.print("Numero exterior: ");
        int numeroExterior = Utilerias.leerEntero(entrada);

        while(numeroExterior <= 0 || numeroExterior > 999)
        {
            System.out.print("Numero exterior invalido. Ingresa un numero de hasta 3 digitos: ");
            numeroExterior = Utilerias.leerEntero(entrada);
        }

        // Colonia
        System.out.print("Colonia: ");
        String colonia = entrada.nextLine();

        while(colonia.isBlank() || !Utilerias.contieneLetras(colonia))
        {
            System.out.print("Colonia invalida. Ingresa una colonia: ");
            colonia = entrada.nextLine();
        }

        // Alcaldia
        System.out.print("Alcaldia: ");
        String alcaldia = entrada.nextLine();

        while(alcaldia.isBlank() || !Utilerias.contieneLetras(alcaldia))
        {
            System.out.print("Alcaldia invalida. Ingresa una alcaldia: ");
            alcaldia = entrada.nextLine();
        }

        // Estado
        System.out.print("Estado: ");
        String estado = entrada.nextLine();

        while(estado.isBlank() || !Utilerias.contieneLetras(estado))
        {
            System.out.print("Estado invalido. Ingresa un estado: ");
            estado = entrada.nextLine();
        }

        // Codigo postal
        System.out.print("Codigo postal: ");
        String codigoPostal = entrada.nextLine();

        while(!Utilerias.codigoPostalValido(codigoPostal))
        {
            System.out.print("Codigo postal invalido. Ingresa exactamente 5 digitos: ");
            codigoPostal = entrada.nextLine();
        }

        // Crear direccion
        Direccion direccion = new Direccion(
                calle,
                (short) numeroExterior,
                colonia,
                alcaldia,
                estado,
                codigoPostal
        );

        // Crear cliente
        Cliente cliente = new Cliente(
                numCliente,
                nombre,
                telefono,
                direccion
        );

        // Guardar cliente
        clientes.put(numCliente, cliente);

        System.out.println("Cliente registrado correctamente.");
        return cliente;
    }

    public static void consultarDatos(HashMap<Integer, Cliente> clientes, Scanner entrada)
    {

        System.out.println("=====Consultar cliente=====");

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

    public static Cliente asignarDueño(int numCliente, HashMap<Integer, Cliente> clientes, Scanner entrada){
        Cliente cliente = clientes.get(numCliente);
        if (cliente == null){
            System.out.println("No existe cliente con ese número");
            System.out.println("¿Deseas registrar un nuevo cliente? (s/n)");
            String opcion = entrada.nextLine().trim();
            if(opcion.equalsIgnoreCase("s")){
                return registrarCliente(clientes, entrada);
            }
            return null;
        }
        return cliente;
    }
}
