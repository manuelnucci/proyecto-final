package exceptions;

import pga.Entidad;

public class EntidadNoAptaParaCursadaException extends Exception
{
    private Entidad entidad;
    
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
