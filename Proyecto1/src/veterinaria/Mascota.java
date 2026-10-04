package veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private int id;
    private Cliente dueño;
    private short edad;
    private String especie;
    private String raza;
    private List<Consulta> historial;

    public Mascota(String nombre, int id, Cliente dueño, short edad, String especie, String raza){
        this.nombre = nombre;
        this.id = id;
        this.dueño = dueño;
        this.edad = edad;
        this.especie = especie;
        this.raza = raza;
        List<Consulta> consultas = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    public void setHistorial(List<Consulta> historial) {
        this.historial = historial;
    }

    public List<Consulta> getHistorial() {
        return historial;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void imprimirDatos(){
        System.out.println("=====Datos de la mascota=====");
        System.out.println("Nombre: " + getNombre());
        System.out.println("ID: " + getId());
        System.out.println("Dueño: " + getDueño().getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Especie: ");
        System.out.println("Raza: " + getRaza());
        System.out.println();
    }

    public void imprimirHistorial(){
        System.out.println("=====Historial de "+ nombre +" con ID: "+ id+"======");
        for(Consulta consulta: historial){
            consulta.imprimirConsulta();
        }
    }

    public void agregarConsulta(Consulta consulta){
        historial.add(consulta);
    }

}
