package exceptions;


/**
 * Clase que representa un tipo de las excepciones con que trabaja el sistema.
 * Su lanzamiento ocurre cuando el formato del mail ingresado no cumple con el
 * estándar previsto en la aplicación.
 */
public class EmailInvalidoException extends Exception
{
    private String mail; // Mail con formato incorrecto.

    /**
     * Constructor de la clase que crea una nueva instancia de EmailInvalidoException.<br>
     * 
     * <b>Pre:</b> El mail es un String no nulo ni vacío cuyo formato es inválido.<br>
     * <b>Post:</b> Se crea una nueva instancia de la clase.
     * 
     * @param mail Mail del alumno con un formato no válido. Mail != null && mail != "".
     * @param mensaje Mensaje que será mostrado en el bloque catch informando el problema ocurrido. Mensaje != null && mensaje != ""
     */
    public EmailInvalidoException(String mail, String mensaje)
    {
        super(mensaje);
        this.mail = mail;
    }

    public String getMail()
    {
        return mail;
    }
}
