package veterinaria;

import java.util.HashSet;
import java.util.Set;

public class Cliente 
{
    private int numCliente;
    private String nombre;
    private String telefono;
    private Direccion direccion;
    private Set<Mascota> mascotas;

    public Cliente(int numCliente, String nombre, String telefono, Direccion direccion) 
    {
        this.numCliente = numCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mascotas = new HashSet<>();
    }

    public int getNumCliente() 
    {
        return numCliente;
    }

    public void setNumCliente(int numCliente) 
    {
        this.numCliente = numCliente;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getTelefono() 
    {
        return telefono;
    }

    public void setTelefono(String telefono) 
    {
        this.telefono = telefono;
    }

    public Direccion getDireccion() 
    {
        return direccion;
    }

    public void setDireccion(Direccion direccion) 
    {
        this.direccion = direccion;
    }

    public Set<Mascota> getMascotas() 
    {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) 
    {
        mascotas.add(mascota);
    }

    public void eliminarMascota(Mascota mascota) 
    {
        mascotas.remove(mascota);
    }

    public void imprimirInformacion() 
    {
        System.out.println("---Datos del cliente---");
        System.out.println("Numero de cliente: " + getNumCliente());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Telefono: " + getTelefono());

        System.out.println("---Direccion---");
        direccion.imprimirDatos();

        System.out.println("---Mascotas---");

        if (mascotas.isEmpty()) 
            {

            System.out.println("El cliente no tiene mascotas registradas.");
        } 
        else 
            {
            for (Mascota mascota : mascotas) 
            {
                System.out.println("ID: " + mascota.getId() + " | Nombre: " + mascota.getNombre());
            }
        }

        System.out.println();
    }
}