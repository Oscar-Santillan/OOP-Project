package veterinaria;

import java.util.Scanner;

public class Utilerias {
    public static int leerEntero(Scanner entrada){
        int numero = entrada.nextInt();
        entrada.nextLine();
        return numero;
    }
}
