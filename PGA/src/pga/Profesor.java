package pga;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Clase que representa a los profesores de la facultad.
 */
public class Profesor extends Persona
{
    private static int legajoProfesor = 0; // Número de legajo del último profesor registrado
    private static final String ID_LEGAJO = "PRO"; // Parte del formato con que se arma el legajo del profesor
    
    private HashMap <String, Asignatura> competencias; // Colección con las asignaturas que puede enseñar el profesor
    // Las claves serán las IDs de la asignaturas
    
    /**
     * Constructor vacío necesario para la serialización en XML.
     */
    public Profesor()
    {
        super();
    }

    /**
     * Constructor que crea una nueva instancia de profesor.<br>
     * 
     * <b> Pre:</b> Los parámetros vienen ya siendo válidos. Hay una asignación directa. 
     * El mail ya cuenta con el formato correcto.<br>
     * <b> Post:</b> Se crea una nueva instancia de profesor con los parámetros validados.
     * 
     * @param nombre Nombre del profesor. Nombre != null y nombre != ""
     * @param apellido Apellido del profesor. Apellido != null y apellido != ""
     * @param domicilio Domicilio del profesor. Domicilio != null y domicilio != ""
     * @param telefono Telefono del profesor. Telefono != null y telefono != ""
     * @param mail Mail del profesor. Mail != null y mail != ""
     */
    public Profesor(String nombre, String apellido, String domicilio, String telefono, String mail)
    {
        super(nombre, apellido, ID_LEGAJO + String.format("%04d", ++legajoProfesor), domicilio, telefono, mail);
        this.competencias = new HashMap<String, Asignatura>();
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

    /**
     * Método que devuelve una cadena con la información completa del profesor, tanto sus atributos personales como
     * sus competencias.<br>
     * 
     * <b>Pre:</b> La colección de competencias ya se encuentra inicializada.<br>
     * <b>Post:</b> Se devuelve un String con la información del profesor.
     * 
     * @return String con la información del profesor.
     */
    public String infoProfesor()
    {
        Iterator<Asignatura> it = this.competencias.values().iterator();
        String cad;
        
        cad = super.toString() + "\nCompetencias:";
        
        while(it.hasNext())
            cad += "\n\t" + it.next().getNombre();
        
        return cad;
    }
}
