package veterinaria.estructuras;
import veterinaria.Mascota;
import veterinaria.Consulta;
import java.util.HashSet;

public class setMascotas {
    private HashSet<Mascota> mascotas;

    public setMascotas(){
        mascotas=new HashSet<>();
    }

    public HashSet<Mascota> getMascotas(){
        return mascotas;
    }
    
    public void addMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    public void removeMascota(String nombreMascota){
        mascotas.removeIf(mascota -> mascota.getNombre().equals(nombreMascota));
    }

    public boolean buscarMascota(String nombreMascota){
        for(Mascota mascota: mascotas){
            if(mascota.getNombre().equals(nombreMascota)){
                return true; 
            }
        }
        return false;
    }

    public void registrarConsultaAMascota(String nombreMascota, Consulta newConsulta){
        for(Mascota mascota: mascotas){
            if(mascota.getNombre().equals(nombreMascota)){
                mascota.agregarConsulta(newConsulta);
            }
        }
    }

    public boolean isEmpty(){
        if(mascotas.isEmpty()){
            return true;
        }
        return false;
    }

    public void imprimirMascotas(){
        for(Mascota mascota : mascotas) {
        System.out.println("ID: " + mascota.getId() + " | Nombre: " + mascota.getNombre());
        }
    }

    public Mascota getMascotaBuscada(String nombreMascota){
     for(Mascota mascota: mascotas){
            if(mascota.getNombre().equals(nombreMascota)){
                return mascota;
            }
        }  
    return null; 
    }







}
