package veterinaria.estructuras;
import java.util.ArrayList;
import veterinaria.Consulta;

public class listConsultas {
    ArrayList<Consulta> consultas;

    public listConsultas(){
        consultas= new ArrayList<>();
    }

    public ArrayList<Consulta> getClientes(){
        return consultas;
    }

    public void addConsulta(Consulta consulta){
        consultas.add(consulta);
    }

    public void removeConsulta(Consulta consulta){
        consultas.remove(consulta);
    }

    public int sizeConsulta(){
        return consultas.size();
    }

    public void imprimirConsultas(){
        for(Consulta consulta: consultas){
            consulta.imprimirConsulta();
        }
    }


}
