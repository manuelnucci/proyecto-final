package pga;

public class NoEstaEntidadException extends Exception
{
    private String mensaje;
    
    public NoEstaEntidadException(String mensaje)
    {
        this.mensaje = mensaje;
    }

    public String getMensaje()
    {
        return mensaje;
    }
}
