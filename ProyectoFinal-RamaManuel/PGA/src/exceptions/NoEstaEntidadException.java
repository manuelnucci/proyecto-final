package exceptions;

import pga.Entidad;

/**
 * Clase que representa un tipo de las excepciones con que trabaja el sistema.
 * Su lanzamiento ocurre cuando al buscar en una colección un elemento que
 * debiera estar presente, éste no existe en la misma.
 */
public class NoEstaEntidadException extends Exception
{
    private Entidad entidad; // Entidad que sirve de información en la zona donde se atrapa a la excepción.
    
    /**
     * Constructor de la clase que crea una nueva instancia de NoEstaEntidadException.<br>
     * 
     * <b>Pre:</b> La entidad existe en el contexto del sistema.<br>
     * <b>Post:</b> Se crea una nueva instancia de la clase.
     * 
     * @param entidad Entidad que sirve como información. Entidad != null.
     * @param mensaje Mensaje que será mostrado en el bloque catch informando el problema ocurrido. Mensaje != null y mensaje != ""
     */
    public NoEstaEntidadException(Entidad entidad, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
    }

    /**
    * Constructor de la clase que crea una nueva instancia de NoEstaEntidadException.<br>
    * 
    * <b>Pre:</b> El mensaje que viene por parámetro no es nulo ni vacío.<br>
    * <b>Post:</b> Se crea una nueva instancia de la clase.
    * 
    * @param mensaje Mensaje que será mostrado en el bloque catch informando el problema ocurrido. Mensaje != null y mensaje != ""
    */
    public NoEstaEntidadException(String mensaje)
    {
        super(mensaje);
    }
    
    public Entidad getEntidad()
    {
        return entidad;
    }
}
