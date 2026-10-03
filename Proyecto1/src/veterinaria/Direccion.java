package veterinaria;

public class Direccion 
{
    private String calle;
    private short numero;
    private String colonia;
    private String alcaldia;
    private String estado;
    private String codigoPostal;

    public Direccion(String calle, short numero, String colonia, String alcaldia, String estado, String codigoPostal) 
    {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.alcaldia = alcaldia;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() 
    {
        return calle;
    }

    public void setCalle(String calle) 
    {
        this.calle = calle;
    }

    public short getNumero() 
    {
        return numero;
    }

    public void setNumero(short numero) 
    {
        this.numero = numero;
    }

    public String getColonia() 
    {
        return colonia;
    }

    public void setColonia(String colonia) 
    {
        this.colonia = colonia;
    }

    public String getAlcaldia() 
    {
        return alcaldia;
    }

    public void setAlcaldia(String alcaldia) 
    {
        this.alcaldia = alcaldia;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public String getCodigoPostal() 
    {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) 
    {
        this.codigoPostal = codigoPostal;
    }

    public void imprimirDatos() {
        System.out.println("Calle: " + getCalle());
        System.out.println("Numero: " + getNumero());
        System.out.println("Colonia: " + getColonia());
        System.out.println("Alcaldia: " + getAlcaldia());
        System.out.println("Estado: " + getEstado());
        System.out.println("Codigo Postal: " + getCodigoPostal());
    }
}