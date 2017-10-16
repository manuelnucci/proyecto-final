package pga;

import java.util.HashMap;
import java.util.Iterator;

public class Profesor extends Persona
{
    private static int legajoProfesor = 0;
    private static final String ID_LEGAJO = "PRO";
    
    private HashMap <String, Asignatura> competencias; // Las claves serán las IDs de la asignaturas
    
    public Profesor()
    {
        super();
    }

    public Profesor(String nombre, String apellido, String domicilio, String telefono, String mail, HashMap<String, Asignatura> competencias)
    {
        super(nombre, apellido, ID_LEGAJO + String.format("%04d", legajoProfesor++), domicilio, telefono, mail);
        this.competencias = competencias;
    }

    public static void setLegajoProfesor(int legajoProfesor)
    {
        Profesor.legajoProfesor = legajoProfesor;
    }

    public static int getLegajoProfesor()
    {
        return legajoProfesor;
    }

    public void setCompetencias(HashMap<String, Asignatura> competencias)
    {
        this.competencias = competencias;
    }

    public HashMap<String, Asignatura> getCompetencias()
    {
        return competencias;
    }

    @Override
    public String toString()
    {
        Iterator<Asignatura> it = this.competencias.values().iterator();
        String cad;
        
        cad = super.toString() + "\nCompetencias:";
        
        while(it.hasNext())
            cad += "\n\t" + it.next().getNombre();
        
        return cad;
    }
}
