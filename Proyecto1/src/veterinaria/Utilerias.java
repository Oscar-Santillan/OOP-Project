package veterinaria;
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

    public static short leerShort(Scanner entrada){

        while(!entrada.hasNextShort()){
            System.out.print("Entrada inválida. Ingresa un número: ");
            entrada.nextLine();
        }

        short numero = entrada.nextShort();
        entrada.nextLine();

        return numero;
    }

    public static String horaActualAFormato(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime ahora = LocalDateTime.now();
        return ahora.format(formato);

    }

    public static LocalDateTime ingresarFecha(Scanner entrada){
        int opcion;
        do{
            System.out.println("¿Desea ingresar la fecha de hoy?\n1) Sí\n2) No");
            opcion = leerEntero(entrada);
            if(opcion == 1){
                return LocalDateTime.now();
            }
            if(opcion != 2){
                System.out.println("Ingrese un valor válido");
            }
        }while(opcion != 2);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm")
                .withResolverStyle(java.time.format.ResolverStyle.STRICT);
        while(true){
            System.out.println("Ingrese la fecha en formato 'dd/MM/yyyy'");
            String fecha = entrada.nextLine();
            System.out.println("Ingrese la hora en formato 'HH:mm'");
            String hora = entrada.nextLine();
            try{
                return LocalDateTime.parse(fecha + " " + hora, formato);
            }catch(java.time.format.DateTimeParseException ex){
                System.out.println("Fecha u hora inválida. Intente nuevamente.");
            }
        }
    }
}
