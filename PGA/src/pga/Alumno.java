package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Alumno extends Persona
{
    private static int legajoAlumno = 0;
    private static final String ID_LEGAJO = "ALU";
    
    private Hashtable <String, Asignatura> historiaAcademica;
    
    public Alumno()
    {
        super();
    }

    public Alumno(String nombre, String apellido, String domicilio, String mail, String telefono, Hashtable<String, Asignatura> historiaAcademica)
    {
        super(nombre, apellido, ID_LEGAJO + String.format("%04d", legajoAlumno++), domicilio, mail, telefono);
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
