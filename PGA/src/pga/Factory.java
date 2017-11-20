package pga;


/**
 * Clase encargada de la instanciación de clases de la aplicación. Se aplica obviamente el patrón Factory.
 * Se la declara final para evitar su extensión.
 */
public final class Factory
{
    public static final int ALUMNO = 0; // Constante pública para indicar que se desea instanciar un Alumno.
    public static final int PROFESOR = 1; // Constante pública para indicar que se desea instanciar un Profesor.

    /**
     * Constructor de la clase. Se lo declara privado para evitar la instanciación de la clase Factory,
     * la cual es una mera creadora de otras clases.
     */
    private Factory()
    {
        super();
    }

    /**
     * Método estático que devuelve una instancia de Persona (Alumno o Profesor) dependiendo de la constante
     * utilizada.<br>
     * 
     * <b>Pre:</b> Los parámetros que luego se convertirán en atributos de la clase Alumno o Profesor se encuentran
     * validados. El mail cuenta con su formato correcto.<br>
     * <b>Post:</b> Se devuelve una instancia de Persona o nulo en el caso que la constante "tipo" no concuerde con
     * las constantes declaradas en Factory.
     * 
     * @param tipo Entero que indica qué tipo de Persona se desea instanciar. No hay restricciones para este parámetro.
     * @param nombre Nombre de la persona. Nombre != null y nombre != ""
     * @param apellido Apellido de la persona. Apellido != null y apellido != ""
     * @param domicilio Domicilio de la persona. Domicilio != null y domicilio != ""
     * @param telefono Telefono de la persona. Telefono != null y telefono != ""
     * @param mail Mail de la persona. Mail != null y mail != ""
     * @return Se devuelve una Persona o null en el caso que "tipo" no concuerde ni con ALUMNO ni PROFESOR (constantes públicas).
     */
    public static Persona getPersona(int tipo, String nombre, String apellido, String domicilio, String telefono, String mail)
    {
        Persona ret;
        
        if (tipo == ALUMNO)
            ret = new Alumno(nombre, apellido, domicilio, telefono, mail);
        else 
            if (tipo == PROFESOR)
                ret = new Profesor(nombre, apellido, domicilio, telefono, mail);
            else
                ret = null;
        return ret;       
    }

    /**
     * Método estático que devuelve una instancia de Asignatura.<br>
     * 
     * <b>Pre:</b> El nombre de la futura asignatura ya se encuenta validado.<br>
     * <b>Post:</b> Se retorna una instancia de Asignatura.
     * 
     * @param nombre Nombre de la asignatura. Nombre != null y nombre != "".
     * @return Se devuelve una instancia de Asignatura.
     */
    public static Asignatura getAsignatura(String nombre)
    {
        return new Asignatura(nombre);
    }

    /**
     * Método estático que devuelve una instancia de Cursada.<br>
     * 
     * <b>Pre:</b> Los parámetros que luego se convertirán en atributos de la clase Cursada se encuentran
     * validados. El periodo y las horas de inicio y fin cumplen con el formato correcto.<br>
     * <b>Post:</b> Se retorna una instancia de Cursada.
     * 
     * @param nombre Nombre de la cursada. Nombre != null y nombre != "".
     * @param asignatura Asignatura a la cual pertenece la cursada. Asignatura != null.
     * @param periodo Período en que se dicta la cursada. Periodo != null y periodo != "".
     * @param dia Día en que se dicta la cursada. Dia != null y dia != "".
     * @param horaInicio Hora de inicio de la cursada. HoraInicio != null y HoraInicio != "".
     * @param horaFin Hora de finalización de la cursada. HoraFin != null y HoraFin != "".
     * @return Se devuelve una nueva instancia de Cursada.
     */
    public static Cursada getCursada(String nombre, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin)
    {
        return new Cursada(nombre, asignatura, periodo, dia, horaInicio, horaFin);
    }
}
