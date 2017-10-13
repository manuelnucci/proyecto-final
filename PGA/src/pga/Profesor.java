package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Profesor extends Persona
{
    private static int legajoProfesor = 0;
    private static final String ID_LEGAJO = "PRO";
    
    private Hashtable <String, Asignatura> competencias;
    
    public Profesor()
    {
        super();
    }

    public Profesor(String nombre, String apellido, String domicilio, String mail, String telefono, Hashtable<String, Asignatura> competencias)
    {
        super(nombre, apellido, ID_LEGAJO + String.format("%04d", legajoProfesor++), domicilio, mail, telefono);
        this.competencias = competencias;
    }

    public void setCompetencias(Hashtable<String, Asignatura> competencias)
    {
        this.competencias = competencias;
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
