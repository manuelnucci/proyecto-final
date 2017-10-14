package pga;

import java.util.HashMap;
import java.util.Iterator;

public class Asignatura implements Comparable
{
    private static int numAsignatura = 0;
    private static final String ID_LEGAJO = "ASI";
    
    private String id;
    private String nombre;
    private HashMap<String, Asignatura> correlatividades; // Las claves serán las IDs de la asignaturas
    
    public Asignatura()
    {
        super();
    }

    public Asignatura(String nombre, HashMap<String, Asignatura> correlatividades)
    {
        this.id = ID_LEGAJO + String.format("%04d", numAsignatura++);
        this.nombre = nombre;
        this.correlatividades = correlatividades;
    }

    public String getId()
    {
        return id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setCorrelatividades(HashMap<String, Asignatura> correlatividades)
    {
        this.correlatividades = correlatividades;
    }

    public HashMap<String, Asignatura> getCorrelatividades()
    {
        return correlatividades;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Asignatura))
        {
            return false;
        }
        final Asignatura other = (Asignatura) object;
        if (!(nombre == null ? other.nombre == null : nombre.equals(other.nombre)))
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
        result = PRIME * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public int compareTo(Object object) {
        return this.nombre.compareTo(((Asignatura) object).getNombre()); // Las asignaturas serán ordenadas por su nombre
    }    

    @Override
    public String toString()
    {
        Iterator<Asignatura> it = this.correlatividades.values().iterator();
        String cad;
        Asignatura asignatura;
        
        cad = "Id: " + this.getId() + "\nNombre: " + this.getNombre() + "\nCorrelatividades: ";
        
        while(it.hasNext())
        {
            asignatura = it.next();
            cad += "\n\tId: " + asignatura.getId() + ", Nombre: " + asignatura.getNombre();
        }
        
        return cad;
    }
}
