package exceptions;

import pga.Entidad;

/**
 * Clase que representa un tipo de las excepciones con que trabaja el sistema.
 * Su lanzamiento ocurre cuando se intenta agregar a alguna colección una entidad
 * que ya esta incluida en la misma.
 */
public class EntidadRepetidaException extends Exception
{
    private Entidad entidad; // Entidad que sirve de información en la zona donde se atrapa a la excepción.
    
    /**
    * Constructor de la clase que crea una nueva instancia de EntidadRepetidaException.<br>
    * 
    * <b>Pre:</b> La entidad existe en el contexto del sistema.<br>
    * <b>Post:</b> Se crea una nueva instancia de la clase.
    * 
    * @param entidad Entidad que sirve como información. Entidad != null.
    * @param mensaje Mensaje que será mostrado en el bloque catch informando el problema ocurrido. Mensaje != null y mensaje != ""
    */
    public EntidadRepetidaException(Entidad entidad, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
    }

    public Entidad getEntidad()
    {
        return entidad;
    }
}
