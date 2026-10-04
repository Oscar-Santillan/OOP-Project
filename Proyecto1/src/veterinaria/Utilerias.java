package veterinaria;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utilerias {

    public static int leerEntero(Scanner entrada)
    {
        while(!entrada.hasNextInt())
        {
            System.out.print("Entrada invalida. Ingresa un numero: ");
            entrada.nextLine();
        }

        int numero = entrada.nextInt();
        entrada.nextLine();

        return numero;
    }
    public static boolean contieneLetras(String texto)
    {
        for(int i = 0; i < texto.length(); i++)
        {
            if(Character.isLetter(texto.charAt(i)))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean telefonoValido(String telefono)
    {
        if(telefono.length() != 10){
            return false;
        }

        if(!telefono.startsWith("55") && !telefono.startsWith("56"))
        {
            return false;
        }

        for(int i = 0; i < telefono.length(); i++)
        {
            if(!Character.isDigit(telefono.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean calleValida(String calle)
    {
        String texto = calle.toLowerCase();

        return texto.startsWith("calle ") || texto.startsWith("avenida ") || texto.startsWith("paseo ");
    }

    public static boolean codigoPostalValido(String codigoPostal)
    {
        if(codigoPostal.length() != 5)
        {
            return false;
        }

        for(int i = 0; i < codigoPostal.length(); i++)
        {
            if(!Character.isDigit(codigoPostal.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

    public static String horaActualAFormato(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.format(formato);
    }

    public static int elegirEntradaFecha(){
        Scanner scan= new Scanner(System.in);
        int opcion;
        do{
        System.out.println("Desea ingresar la fecha de hoy?");
        System.out.println("1)Si\n2)No");
        opcion=scan.nextInt();
        scan.nextLine();

        if(opcion==1){
            return opcion; 
        }
        if(opcion==0){
            return opcion;
        } 
        else{
            System.out.println("Ingrese un valor valido");
        }}
        while(opcion!=1 && opcion!=0);
        return 0;
    }

    /* 
    public static int ingresarFecha(String fecha, String hora){
        

    }  */
    public static LocalDateTime ingresarFechayHora(){
        Scanner scan= new Scanner(System.in);
        String fecha,hora;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Ingrese la fecha con el formato 'dd-MM-yyyy'': ");
        fecha= scan.nextLine();
        
        System.out.println("Ingrese la hora con el formato 'HH:mm'");
        hora= scan.nextLine();

        LocalDateTime fechayHora= LocalDateTime.parse(fecha+" "+hora,format);
        
        return fechayHora;

    }


   /* public static boolean fechaValida(String fecha){
        if();

    } */

}