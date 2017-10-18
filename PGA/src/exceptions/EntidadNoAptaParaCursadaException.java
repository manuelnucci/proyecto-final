package exceptions;

public class EntidadNoAptaParaCursadaException extends Exception
{
    private String mensaje;
    
    public EntidadNoAptaParaCursadaException(String mensaje)
    {
        this.mensaje = mensaje;
    }

    public String getMensaje()
    {
        return mensaje;
    }
}
