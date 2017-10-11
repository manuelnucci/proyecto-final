package pga;

public class EntidadNoAptaParaCursadaException extends Exception
{
    private String mensaje;
    
    EntidadNoAptaParaCursadaException(String mensaje)
    {
        this.mensaje = mensaje;
    }

    public String getMensaje()
    {
        return mensaje;
    }
}
