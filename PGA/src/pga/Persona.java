package pga;

public class Persona implements Comparable
{
    private String nombre;
    private String apellido;
    private String legajo;
    private String domicilio;
    private String telefono;
    private String mail;

    public Persona()
    {
        super();
    }

    public Persona(String nombre, String apellido, String legajo, String domicilio, String telefono, String mail)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.mail = mail;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setLegajo(String legajo)
    {
        this.legajo = legajo;
    }

    public String getLegajo()
    {
        return legajo;
    }

    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }

    public String getDomicilio()
    {
        return domicilio;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getMail()
    {
        return mail;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Persona))
        {
            return false;
        }
        final Persona other = (Persona) object;
        if (!(legajo == null ? other.legajo == null : legajo.equals(other.legajo)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((legajo == null) ? 0 : legajo.hashCode());
        return result;
    }

    @Override
    public int compareTo(Object object) {
        return this.legajo.compareTo(((Persona) object).getLegajo());
    }
    
    @Override
    public String toString()
    {
        return "Nombre y apellido: " + this.nombre + " " + this.apellido + "\nLegajo: " + this.legajo + "\nDomicilio: " 
               + this.domicilio + "\nTelefono " + this.telefono + "\nMail " + this.mail;
    }
}
