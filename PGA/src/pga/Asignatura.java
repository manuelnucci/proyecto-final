package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Asignatura implements Comparable
{
    private String id;
    private String nombre;
    private Hashtable<String, Asignatura> correlatividades;
    
    public Asignatura()
    {
        super();
    }


    public String getId()
    {
        return id;
    }

    public String getNombre()
    {
        return nombre;
    }


    public Hashtable<String, Asignatura> getCorrelatividades()
    {
        return correlatividades;
    }

    @Override
    public int compareTo(Object object) {
        Asignatura asignatura = (Asignatura) object;
        
        return this.nombre.compareTo(asignatura.getNombre());
    }

    @Override
    public String toString()
    {
        Iterator<Asignatura> i = this.correlatividades.values().iterator();
        String cad;
        Asignatura a;
        
        cad = this.getId() + this.getNombre();
        
        while(i.hasNext())
        {
            a = i.next();
            cad += " " + a.getId() + a.getNombre();
        }
        
        return cad;
    }
}
