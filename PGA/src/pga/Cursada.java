package pga;

import java.util.HashMap;

/**
 * Clase que representa a las cursadas existentes dentro de la facultad.
 */
public class Cursada implements Comparable, Entidad
{
    private static int numCursada = 0; // Número de id de la última cursada registrada
    private static final String ID_LEGAJO = "CUR"; // Parte del formato con que se arma el id de la cursada
    
    private String id; // Identificación de la cursada
    private String nombre; // Nombre de la cursada
    private Asignatura asignatura; // Asignatura a la cual pertenece la cursada
    private String periodo; // Periodo en que se dicta la cursada (incluye año y cuatrimestre)
    private String dia; // Día de la semana en que se dicta la cursada
    private String horaInicio; // Hora de inicio de la cursada
    private String horaFin; // Hora de finalización de la cursada
    private HashMap<String, Alumno> alumnos; // Colección de los alumnos inscriptos en la cursada
    // Las claves serán los legajos de los alumnos
    private HashMap<String, Profesor> profesores; // Colección de los profesores que enseñan en la cursada
    // Las claves serán los legajos de los profesores
    
    /**
     * Constructor vacío necesario para la serialización en XML.
     */
    public Cursada()
    {
        super();    
    }

    /**
     * Constructor que crea una nueva instancia de la Cursada.<br>
     * 
     * <b>Pre:</b> Los parámetros ya se encuentran validados. Tanto el período
     * como las horas de inicio y fin cumplen con los formatos estipulados.<br>
     * <b>Post:</b> Se crea una nueva instancia de Cursada.
     * 
     * @param nombre Nombre de la cursada. Nombre != null y nombre != "".
     * @param asignatura Asignatura a la cual pertenece la cursada. Asignatura != null.
     * @param periodo Período en que se dicta la cursada. Periodo != null y periodo != "".
     * @param dia Día en que se dicta la cursada. Dia != null y dia != "".
     * @param horaInicio Hora de inicio de la cursada. HoraInicio != null y HoraInicio != "".
     * @param horaFin Hora de finalización de la cursada. HoraFin != null y HoraFin != "".
     */
    public Cursada(String nombre, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin)
    {
        this.id = ID_LEGAJO + String.format("%04d", ++numCursada);
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.alumnos = new HashMap<String, Alumno>(); // Los alumnos estarán en una tabla hash cuya clave será
                                                      // el legajo del alumno
        this.profesores = new HashMap<String, Profesor>(); // Los profesores estarán en una tabla hash cuya clave será
                                                           // el legajo del profesor
    }

    public static void setNumCursada(int numCursada)
    {
        Cursada.numCursada = numCursada;
    }

    public static int getNumCursada()
    {
        return numCursada;
    }

    public String getId()
    {
        return id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    /**
     * Método que devuelve la clave con que está hasheada la cursada.
     * En este caso la clave es el nombre de la cursada.
     * 
     * <b>Pre:</b> La cursada debe poseer un nombre no nulo ni vacío.
     * <b>Post:</b> Se devuelve la clave de la cursada.
     * 
     * @return Nombre de la cursada.
     */
    @Override
    public String getClave()
    {
        return this.nombre;
    }
    
    public void setAsignatura(Asignatura asignatura)
    {
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura()
    {
        return asignatura;
    }

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }

    public String getPeriodo()
    {
        return periodo;
    }

    public void setDia(String dia)
    {
        this.dia = dia;
    }

    public String getDia()
    {
        return dia;
    }

    public void setHoraInicio(String horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public String getHoraInicio()
    {
        return horaInicio;
    }

    public void setHoraFin(String horaFin)
    {
        this.horaFin = horaFin;
    }

    public String getHoraFin()
    {
        return horaFin;
    }

    public HashMap<String, Alumno> getAlumnos()
    {
        return alumnos;
    }

    public HashMap<String, Profesor> getProfesores()
    {
        return profesores;
    }

    /**
     * Método que compara dos cursadas. El criterio de igualdad será por id.
     * 
     * <b>Pre:</b> El objeto que viene por parámetro debe ser una Cursada.<br>
     * <b>Post:</b> Se devuelve verdadero o falso dependiendo si las cursadas son iguales o no.
     * 
     * @param object Objeto a comparar con la cursada actual. Object != null.
     * @return Verdadero si los objetos cumplen el criterio de igualdad o falso en caso contrario.
     */
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Cursada))
        {
            return false;
        }
        final Cursada other = (Cursada) object;
        if (!(id == null ? other.id == null : id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Método que compara cursadas a través de sus ids.<br>
     * 
     * <b>Pre:</b> El objeto que viene por parámetro no es nulo y debe ser una cursada.<br>
     * <b>Post:</b> Se devuelve un entero en función de qué objeto sea mayor en base a la comparación.
     * 
     * @param object objeto a comparar con la instancia actual. Object != null.
     * @return Entero menor, igual o mayor a 0 según el resultado de la comparación.
     */
    @Override
    public int compareTo(Object object) {   
        return this.id.compareTo(((Cursada) object).getId()); // Las cursadas serán ordenadas por su ID
    }

    /**
     * Método que devuelve una cadena con la información de la cursada.<br>
     * 
     * <b>Pre:</b> La cursada cuenta con todos sus atributos no nulos (exceptuando las colecciones que
     * no son pertinentes para este método).<br>
     * <b>Post:</b> Se devuelve la información de la cursada.
     * 
     * @return String con la información de la cursada.
     */
    @Override
    public String toString()
    {
        return "Id: " + this.id + "\nAsignatura: " + this.getAsignatura().getNombre() + "\nPeriodo: " +
               this.periodo + "\nDia: " + this.dia + "\nHora de inicio: " + this.horaInicio +
               "\nHora de fin: " + this.horaFin;
    }
}
