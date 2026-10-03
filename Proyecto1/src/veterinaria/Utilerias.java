package veterinaria;

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
}