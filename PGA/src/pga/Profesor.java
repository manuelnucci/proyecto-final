package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Profesor extends Persona
{
    private Hashtable <String, Asignatura> competencias;
    
    public Profesor()
    {
        super();
    }

    public Hashtable <String, Asignatura> getCompetencias()
    {
        return competencias;
    }

    @Override
    public String toString()
    {
        Iterator <Asignatura> i = this.competencias.values().iterator();
        String cad;
        Asignatura a;
        
        cad = super.toString();
        
        while(i.hasNext())
        {
            a = i.next();
            cad += " " + a.getId() + a.getNombre();
        }
        
        return cad;
    }
}
