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
        Iterator <Asignatura> it = this.competencias.values().iterator();
        String cad;
        Asignatura a;
        
        cad = super.toString();
        
        while(it.hasNext())
        {
            a = it.next();
            cad += " " + a.getId() + a.getNombre();
        }
        
        return cad;
    }
}
