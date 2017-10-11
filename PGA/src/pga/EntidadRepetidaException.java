package pga;

public class EntidadRepetidaException extends Exception
{
    private String mensaje;
    
    public EntidadRepetidaException(String mensaje)
    {
        this.mensaje = mensaje;
    }

    public String getMensaje()
    {
        return mensaje;
    }
}
