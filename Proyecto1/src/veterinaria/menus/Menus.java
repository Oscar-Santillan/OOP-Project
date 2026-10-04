package veterinaria.menus;

public class Menus {
    public static void mostrarMenuPrincipal(){
        System.out.println("=====Sistema de veterinaria=====");
        System.out.println("1. Mascotas.");
        System.out.println("2. Clientes.");
        System.out.println("3. Consultas.");
        System.out.println("4. Salir.");
        System.out.print("Ingresa una opción: ");
        System.out.println();
    }

    public static void mostrarMenuMascotas(){
        System.out.println("=====Mascotas=====");
        System.out.println("1. Registrar mascota.");
        System.out.println("2. Modificar los datos de una mascota");
        System.out.println("3. Eliminar Mascota.");
        System.out.println("4. Regresar.");
        System.out.print("Ingresa una opción: ");
        System.out.println();
    }

    public static void menuEditarMascota(){
        System.out.println("=====Modificar Datos de la mascota=====");
        System.out.println("1. Edad.");
        System.out.println("2. Dueño.");
        System.out.println("3. Raza.");
        System.out.println("4. Regresar.");
        System.out.print("Ingresa una opción: ");
        System.out.println();
    }

    public static void mostrarMenuClientes(){
        System.out.println("=====Clientes=====");
        System.out.println("1. Registrar cliente.");
        System.out.println("2. Consultar datos del dueño.");
        System.out.println("3. Regresar.");
        System.out.print("Ingresa una opción: ");
        System.out.println();
    }

    public static void mostrarMenuConsultas(){
        System.out.println("=====Consultas=====");
        System.out.println("1. Registrar nueva consulta.");
        System.out.println("2. Mostrar historial de la mascota.");
        System.out.println("3. Mostrar el histórico de consultas.");
        System.out.println("4. Regresar.");
        System.out.print("Ingresa una opción: ");
        System.out.println();
    }


}
