package pga;

import java.util.Hashtable;

public class Factory
{
    public static final int ALUMNO = 0;
    public static final int PROFESOR = 1;
    
    public Factory()
    {
        super();
    }
    
    public static Persona getPersona(int tipo, String nombre, String apellido, String domicilio, String telefono, String mail,
                            Hashtable<String, Asignatura> asignaturas)
    {
        Persona ret;
        
        if (tipo == ALUMNO)
            ret = new Alumno(nombre, apellido, domicilio, telefono, mail, asignaturas);
        else 
            if (tipo == PROFESOR)
                ret = new Profesor(nombre, apellido, domicilio, telefono, mail, asignaturas);
            else
                ret = null;
        return ret;       
    }
    
    public static Asignatura getAsignatura(String nombre, Hashtable<String, Asignatura> correlatividades)
    {
        return new Asignatura(nombre, correlatividades);
    }
    
    public static Cursada getCursada(Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin)
    {
        return new Cursada(asignatura, periodo, dia, horaInicio, horaFin);
    }
}
