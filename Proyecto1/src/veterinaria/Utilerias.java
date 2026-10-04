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

    
}