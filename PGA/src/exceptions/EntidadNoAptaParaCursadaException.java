package exceptions;

import pga.Entidad;

/**
 * Clase que representa un tipo de las excepciones con que trabaja el sistema.
 * Su lanzamiento ocurre cuando algunas de las entidades (alumno o profesor) no son
 * aptas para estar incriptas en la cursada.
 */
public class EntidadNoAptaParaCursadaException extends Exception
{
    private Entidad entidad; // Entidad que sirve de información en la zona donde se atrapa a la excepción.

    /**
     * Constructor de la clase que crea una nueva instancia de EntidadNoAptaParaCursadaException.<br>
     * 
     * <b>Pre:</b> La entidad existe en el contexto del sistema.<br>
     * <b>Post:</b> Se crea una nueva instancia de la clase.
     * 
     * @param entidad Entidad que sirve como información. Entidad != null.
     * @param mensaje Mensaje que será mostrado en el bloque catch informando el problema ocurrido. Mensaje != null y mensaje != ""
     */
    public EntidadNoAptaParaCursadaException(Entidad entidad, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
    }

    public Entidad getEntidad()
    {
        return entidad;
    }
}
