package pga;

import java.util.Hashtable;

public class Factory
{
    public static final int ALUMNO = 0;
    public static final int PROFESOR = 1;
    private static int legajoAlumno = 0;
    private static int legajoProfesor = 0;
    private static int idAsignatura = 0;
    private static int idCursada = 0;
    
    public Factory()
    {
        super();
    }
    
    public static Persona getPersona(int tipo, String nombre, String apellido, String domicilio, String mail, String telefono,
                            Hashtable<String, Asignatura> asignaturas)
    {
        Persona ret;
        
        if (tipo == ALUMNO)
            ret = new Alumno(nombre, apellido, domicilio, mail, telefono, asignaturas);
        else 
            if (tipo == PROFESOR)
                ret = new Profesor(nombre, apellido, domicilio, mail, telefono, asignaturas);
            else
                ret = null;
        return ret;       
    }
    
    public static Cursada getCursada(Asignatura asignatura, String periodo, String dia, String horaInicio)
    {
        return new Cursada(asignatura, periodo, dia, horaInicio);
    }
    
    public static Asignatura getAsignatura(String nombre, Hashtable<String, Asignatura> correlatividades)
    {
        return new Asignatura(nombre, correlatividades);
    }
}
