package pga;

public class Persona
{
    private String nombre;
    private String apellido;
    private String legajo;
    private String domicilio;
    private String mail;
    private String telefono;

    public Persona()
    {
        super();
    }

    public Persona(String nombre, String apellido, String legajo, String domicilio, String mail, String telefono)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.domicilio = domicilio;
        this.mail = mail;
        this.telefono = telefono;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public void setLegajo(String legajo)
    {
        this.legajo = legajo;
    }

    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public String getLegajo()
    {
        return legajo;
    }

    public String getDomicilio()
    {
        return domicilio;
    }

    public String getMail()
    {
        return mail;
    }

    public String getTelefono()
    {
        return telefono;
    }


    @Override
    public String toString()
    {
        return this.apellido + this.nombre + this.legajo + this.domicilio + this.telefono + this.mail;
    }
}
