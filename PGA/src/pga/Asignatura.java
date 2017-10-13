package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Asignatura implements Comparable
{
    private static int numAsignatura = 0;
    private static final String ID_LEGAJO = "ASI";
    
    private String id;
    private String nombre;
    private Hashtable<String, Asignatura> correlatividades;
    
    public Asignatura()
    {
        super();
    }

    public Asignatura(String nombre, Hashtable<String, Asignatura> correlatividades)
    {
        this.id = ID_LEGAJO + String.format("%04d", numAsignatura++);
        this.nombre = nombre;
        this.correlatividades = correlatividades;
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
