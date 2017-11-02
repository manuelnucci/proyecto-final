package pga;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Clase que representa a las Asignaturas que existen en la universidad.
 */
public class Asignatura implements Comparable, Entidad
{
    private static int numAsignatura = 0; // Número de id de la última asignatura registrada
    private static final String ID_LEGAJO = "ASI"; // Parte del formato con que se arma el id de la asignatura
    
    private String id; // Identificación de la asignatura
    private String nombre; // Nombre de la asignatura
    private HashMap<String, Asignatura> correlatividades; // Colección de las asignaturas correlativas con la asignatura en cuestión
    // Las claves serán las IDs de la asignaturas
    
    /**
     * Constructor vacío necesario para la serialización en XML.
     */
    public Asignatura()
    {
        super();
    }

    /**
     * Constructor que crea una instancia de Asignatura.<br>
     * 
     * <b>Pre:</b> El nombre ya se encuentra validado.<br>
     * <b>Post:</b> Se crea una nueva instancia de la Asignatura.
     * 
     * @param nombre Nombre de la asignatura. Nombre != null y nombre != "".
     */
    public Asignatura(String nombre)
    {
        this.id = ID_LEGAJO + String.format("%04d", ++numAsignatura);
        this.nombre = nombre;
        this.correlatividades = new HashMap<String, Asignatura>();
    }

    public static void setNumAsignatura(int numAsignatura)
    {
        Asignatura.numAsignatura = numAsignatura;
    }

    public static int getNumAsignatura()
    {
        return numAsignatura;
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
     * Método que devuelve la clave con que está hasheada la asignatura.
     * En este caso la clave es el nombre de la asignatura.
     * 
     * <b>Pre:</b> La asignatura debe poseer un nombre no nulo ni vacío.
     * <b>Post:</b> Se devuelve la clave de la asignatura.
     * 
     * @return Nombre de la asignatura.
     */
    @Override
    public String getClave()
    {
        return this.nombre;
    }

    public void setCorrelatividades(HashMap<String, Asignatura> correlatividades)
    {
        this.correlatividades = correlatividades;
    }

    public HashMap<String, Asignatura> getCorrelatividades()
    {
        return correlatividades;
    }

    /**
     * Método que compara dos asignaturas. El criterio de igualdad será por id.
     * 
     * <b>Pre:</b> El objeto que viene por parámetro debe ser una Asignatura.<br>
     * <b>Post:</b> Se devuelve verdadero o falso dependiendo si las asignaturas son iguales o no.
     * 
     * @param object Objeto a comparar con la asignatura actual. Object != null.
     * @return Verdadero si los objetos cumplen el criterio de igualdad o falso en caso contrario.
     */
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Asignatura))
        {
            return false;
        }
        final Asignatura other = (Asignatura) object;
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
     * Método que compara asignaturas a través de sus ids.<br>
     * 
     * <b>Pre:</b> El objeto que viene por parámetro no es nulo y debe ser una asignatura.<br>
     * <b>Post:</b> Se devuelve un entero en función de qué objeto sea mayor en base a la comparación.
     * 
     * @param object objeto a comparar con la instancia actual. Object != null.
     * @return Entero menor, igual o mayor a 0 según el resultado de la comparación.
     */
    @Override
    public int compareTo(Object object) {
        return this.id.compareTo(((Asignatura) object).getId()); // Las asignaturas serán ordenadas por su ID
    }    

    /**
     * Método que devuelve una cadena con la información completa de la asignatura, tanto su nombre como sus 
     * correlatividades.<br>
     * 
     * <b>Pre:</b> La colección de correlatividades ya se encuentra inicializada.<br>
     * <b>Post:</b> Se devuelve un String con la información de la asignatura.
     * 
     * @return String con la información de la asignatura.
     */
    public String infoAsignatura()
    {
        Iterator<Asignatura> it = this.correlatividades.values().iterator();
        String cad;
        Asignatura asignatura;
        
        cad = "Id: " + this.id + "\nNombre: " + this.nombre + "\nCorrelatividades: ";
        
        while(it.hasNext())
        {
            asignatura = it.next();
            cad += "\n\tId: " + asignatura.getId() + ", Nombre: " + asignatura.getNombre();
        }
        
        return cad;
    }

    /**
     * Método que devuelve una cadena con la información básica de la asignatura: su id y su nombre.<br>
     * 
     * <b>Pre:</b> La asignatura cuenta con un id y un nombre.<br>
     * <b>Post:</b> Se devuelve la información de la asignatura.
     * 
     * @return String con la información básica de la materia.
     */
    @Override
    public String toString()
    {
        return "Id: " + this.id + "\nNombre: " + this.nombre;
    }
}
