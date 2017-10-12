package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Alumno extends Persona
{
    private Hashtable <String, Asignatura> historiaAcademica;
    
    public Alumno()
    {
        super();
    }

    public Alumno(String nombree, String apellido, String legajo, String domicilio, String mail, String telefono, Hashtable<String, Asignatura> historiaAcademica)
    {
        super(nombree, apellido, legajo, domicilio, mail, telefono);
        this.historiaAcademica = historiaAcademica;
    }

    public void setHistoriaAcademica(Hashtable<String, Asignatura> historiaAcademica)
    {
        this.historiaAcademica = historiaAcademica;
    }

    public Hashtable<String, Asignatura> getHistoriaAcademica()
    {
        return historiaAcademica;
    }
    
    @Override
    public String toString()
    {
        Iterator<Asignatura> i = this.historiaAcademica.values().iterator();
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
