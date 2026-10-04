package veterinaria.opciones;
import veterinaria.menus.Menus;
import veterinaria.Mascota;
import veterinaria.Cliente;
import veterinaria.Utilerias;
import veterinaria.Consulta;
import veterinaria.estructuras.listConsultas;
import veterinaria.estructuras.setMascotas;
import java.util.Scanner;
import java.util.HashSet;
import java.time.LocalDateTime;
import java.util.HashMap;

public class OpcionesConsultas {
    public static void ejecutar(HashMap<Integer,Cliente> clientes,listConsultas consultasGeneral){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            Menus.mostrarMenuConsultas();
            opcion = Utilerias.leerEntero(entrada);

            switch (opcion){
                //Registrar nueva consulta
                case 1 -> {registrarConsulta(clientes, consultasGeneral);}
                //Consultar el historial de consultas de la mascota
                case 2 -> {consultarHistorial(clientes);}
                //Consultar el histórico de consultas de la veterinaria
                case 3 -> {consultarHistorico(consultasGeneral);}
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
        Scanner entrada = new Scanner(System.in);
        int idCliente,folio,opcion;
        String nombreMascota,motivoConsulta,diagnostico,tratamiento,fecha=null,hora=null;

        System.out.println("=====Registrar Consultas=====");
        System.out.println("Ingrese el ID del cliente:");
        idCliente=entrada.nextInt();
        entrada.nextLine();
        
        
        if(clientes.containsKey(idCliente)){
            Cliente cliente = clientes.get(idCliente);
            System.out.println("Ingrese el nombre de su mascota:");
            nombreMascota=entrada.nextLine();
            
            while(nombreMascota.isBlank() || !Utilerias.contieneLetras(nombreMascota)){
                System.out.println("Nombre de mascota invalido. Ingresa un nombre:");
                nombreMascota = entrada.nextLine();
                }
            
            if(cliente.getMascotas().buscarMascota(nombreMascota)){

                folio = consultas.sizeConsulta()+1;
                System.out.println("Folio de consulta: "+folio);
                
                System.out.println("Ingrese el motivo de la consulta:");
                motivoConsulta=entrada.nextLine();
                
                while(motivoConsulta.isBlank() || !Utilerias.contieneLetras(motivoConsulta)){
                    System.out.println("Motivo invalido. Ingrese un motivo valido: ");
                    motivoConsulta=entrada.nextLine();
                }
                
                System.out.println("Ingrese el diagnostico: ");
                diagnostico=entrada.nextLine();
                while(diagnostico.isBlank()|| !Utilerias.contieneLetras(diagnostico)){
                    System.out.println("Diagnostico no valido. Ingrese un diagnostico valido: ");
                    diagnostico=entrada.nextLine();
                }

                System.out.println("Ingrese su tratamiento: ");
                tratamiento=entrada.nextLine();
                while(tratamiento.isBlank() || !Utilerias.contieneLetras(tratamiento)){
                    System.out.println("Tratamiento invalida. Ingrese un tratamiento valido: ");
                    tratamiento=entrada.nextLine();
                }

                opcion=Utilerias.ingresarFecha(fecha, hora);
                if(opcion==1){
                    Consulta consulta = new Consulta(folio, motivoConsulta, diagnostico, tratamiento);
                    clientes.get(idCliente).getMascotas().registrarConsultaAMascota(nombreMascota, consulta);
                    consultas.addConsulta(consulta);
                }
                else{
                    Utilerias.ingresarFecha(fecha, hora);
                    Consulta consulta = new Consulta(folio, fecha, hora, motivoConsulta, diagnostico, tratamiento);
                    clientes.get(idCliente).getMascotas().registrarConsultaAMascota(nombreMascota, consulta);
                    consultas.addConsulta(consulta);
                }

            }
            else{
                System.out.println("Esa Mascota no se encuentra registrada");
                System.out.print("Verifique que está bien escrito,");
                System.out.println(" de lo contrario, registre a la Mascota");   
            }

        }
        else{
            System.out.println("El ID ingresado no existe");
            System.out.print("Verifique que está bien escrito,");
            System.out.println(" de lo contrario, registre al Cliente y su respectiva Mascota");
        }

    }

    public static void consultarHistorial(HashMap<Integer, Cliente> clientes){
        Scanner scan=new Scanner(System.in);
        System.out.println("=====Consultar Historial Individual=====");
        System.out.println("Ingrese el ID de su cliente: ");
        int idCliente=Utilerias.leerEntero(scan);        
        if(clientes.containsKey(idCliente)){
            Cliente cliente = clientes.get(idCliente);

            System.out.println("Ingrese el nombre de su mascota: ");
            String nombreMascota=scan.nextLine();

            while(nombreMascota.isBlank() || !Utilerias.contieneLetras(nombreMascota)){
                System.out.println("Nombre de mascota invalido. Ingresa un nombre:");
                nombreMascota = scan.nextLine();
                }

            if(cliente.getMascotas().buscarMascota(nombreMascota)){
                Mascota mascota = cliente.getMascotas().getMascotaBuscada(nombreMascota);
                mascota.imprimirHistorial();
            }
            else{
                System.out.println("La mascota no se encuentra registrada");   
            }
        }
    else{
        System.out.println("El ID ingresado no existe");
        System.out.print("Verifique que está bien escrito,");
        System.out.println(" de lo contrario, registre al Cliente y su respectiva Mascota");
    }

    }

    public static void consultarHistorico(listConsultas consultas){
        System.out.println("=====Historico de Consultas=====");
        consultas.imprimirConsultas();
    }
}
