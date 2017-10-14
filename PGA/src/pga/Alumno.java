package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Alumno extends Persona
{
    private static int legajoAlumno = 0;
    private static final String ID_LEGAJO = "ALU";
    
    private Hashtable <String, Asignatura> historiaAcademica; // Las claves serán la ID de la asignaturas
    
    public Alumno()
    {
        super();
    }

    public Alumno(String nombre, String apellido, String domicilio, String telefono, String mail, Hashtable<String, Asignatura> historiaAcademica)
    {
        super(nombre, apellido, ID_LEGAJO + String.format("%04d", legajoAlumno++), domicilio, telefono, mail);
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
        Iterator<Asignatura> it = this.historiaAcademica.values().iterator();
        String cad;
        
        cad = super.toString() + "\nHistoria academica:";
        
        while(it.hasNext())
            cad += "\n\t" + it.next().getNombre();
        
        return cad;
    }
}
