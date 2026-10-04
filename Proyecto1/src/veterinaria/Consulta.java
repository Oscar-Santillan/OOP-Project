package veterinaria;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private int folio;
    private LocalDateTime fechayHora;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
    private String nombrePaciente;
    private String nombreDueño;
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); 
    
    public Consulta(int folio,String motivoConsulta, String diagnostico, String tratamiento){
        this.folio=folio;
        this.motivoConsulta=motivoConsulta;
        this.tratamiento=tratamiento;
        this.diagnostico=diagnostico;
        this.fechayHora= LocalDateTime.parse(Utilerias.horaActualAFormato(),format);
    }
    
    public Consulta(int folio, LocalDateTime fechayHora,String motivoConsulta, String diagnostico, String tratamiento){
        this.folio=folio;
        this.motivoConsulta=motivoConsulta;
        this.tratamiento=tratamiento;
        this.diagnostico=diagnostico;
        this.fechayHora= fechayHora;

    }

    public int getFolio(){
        return folio;
    }
    
    public void setFolio(int folio){
        this.folio=folio;
    }
    
    public LocalDateTime getFechayHora(){
        return fechayHora;
    }
    
    public void setFechaYHora(String fechayHora){
        this.fechayHora= LocalDateTime.parse(fechayHora,format);
    }

    public String getMotivoConsulta(){
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta){
        this.motivoConsulta=motivoConsulta;
    }

    public String getDiagnostico(){
        return diagnostico;
    }
    
    public void setDiagnostico(String diagnostico){
        this.diagnostico=diagnostico;
    }

    public String getTratamiento(){
        return tratamiento;
    }

    public void setTratamiento(String trateminto){
        this.tratamiento=trateminto;
    }
    
    public void setNombrePaciente(String nombrePaciente){
        this.nombrePaciente = nombrePaciente;
    }

    public void setNombreDueño(String nombreDueño){
        this.nombreDueño = nombreDueño;
    }

    public void imprimirConsulta(){
        System.out.println("\n=====Datos de Consulta====");
        System.out.println("Fecha y Hora: "+fechayHora.toString());
        System.out.println("Folio: "+folio);
        System.out.println("Paciente: " + nombrePaciente);
        System.out.println("Dueño: " + nombreDueño);
        System.out.println("Motivo: "+motivoConsulta);
        System.out.println("Diagnostico: "+diagnostico);
        System.out.println("Tratamiento: "+tratamiento);
        System.out.println("");
    }
    

}
