package exceptions;


/**
 * Clase que representa un tipo de las excepciones con que trabaja el sistema.
 * Su lanzamiento ocurre cuando el formato de alguna de las horas (inicio o fin) ingresadas
 * no cumple con el estándar previsto en la aplicación.
 */
public class HoraInvalidaException extends Exception
{
    private String hora; // Hora con formato incorrecto.
    
    /**
     * Constructor de la clase que crea una nueva instancia de HoraInvalidaException.<br>
     * 
     * <b>Pre:</b> La hora es un String no nulo ni vacío cuyo formato es inválido.<br>
     * <b>Post:</b> Se crea una nueva instancia de la clase.
     * 
     * @param hora Hora de la cursada con un formato no válido. Hora != null && hora != "".
     * @param mensaje Mensaje que será mostrado en el bloque catch informando el problema ocurrido. Mensaje != null && mensaje != ""
     */
    public HoraInvalidaException(String hora, String mensaje)
    {
        super(mensaje);
        this.hora = hora;
    }

    public String getHora()
    {
        return hora;
    }
}
