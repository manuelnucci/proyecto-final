package pga;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Clase que representa a los alumnos de la facultad.
 */
public class Alumno extends Persona
{
    private static int legajoAlumno = 0; // Número de legajo del último alumno registrado
    private static final String ID_LEGAJO = "ALU"; // Parte del formato con que se arma el legajo del alumno
    
    private HashMap <String, Asignatura> historiaAcademica; // Colección con las asignaturas aprobadas por el alumno
    // Las claves serán las IDs de la asignaturas
    
    /**
     * Constructor vacío necesario para la serialización en XML.
     */
    public Alumno()
    {
        super();
    }

    /**
     * Constructor que crea una nueva instancia de alumno.<br>
     * 
     * <b> Pre:</b> Los parámetros vienen ya siendo válidos. Hay una asignación directa. 
     * El mail ya cuenta con el formato correcto.<br>
     * <b> Post:</b> Se crea una nueva instancia de alumno con los parámetros validados.
     * 
     * @param nombre Nombre del alumno. Nombre != null y nombre != ""
     * @param apellido Apellido del alumno. Apellido != null y apellido != ""
     * @param domicilio Domicilio del alumno. Domicilio != null y domicilio != ""
     * @param telefono Telefono del alumno. Telefono != null y telefono != ""
     * @param mail Mail del alumno. Mail != null y mail != ""
     */
    public Alumno(String nombre, String apellido, String domicilio, String telefono, String mail)
    {
        super(nombre, apellido, ID_LEGAJO + String.format("%04d", ++legajoAlumno), domicilio, telefono, mail);
        this.historiaAcademica = new HashMap <String, Asignatura>();
    }

    public static void setLegajoAlumno(int legajoAlumno)
    {
        Alumno.legajoAlumno = legajoAlumno;
    }

    public static int getLegajoAlumno()
    {
        return legajoAlumno;
    }

    public void setHistoriaAcademica(HashMap<String, Asignatura> historiaAcademica)
    {
        this.historiaAcademica = historiaAcademica;
    }

    public HashMap<String, Asignatura> getHistoriaAcademica()
    {
        return historiaAcademica;
    }

    /**
     * Método que devuelve una cadena con la información completa del alumno, tanto sus atributos personales como
     * su historia académica.<br>
     * 
     * <b>Pre:</b> La historia academica ya se encuentra inicializada.<br>
     * <b>Post:</b> Se devuelve un String con la información del alumno.
     * 
     * @return String con la información del alumno.
     */
    public String infoAlumno()
    {
        Iterator<Asignatura> it = this.historiaAcademica.values().iterator();
        String cad;
        
        cad = super.toString() + "\nHistoria academica:";
        
        while(it.hasNext())
            cad += "\n\t" + it.next().getNombre();
        
        return cad;
    }
}
