package exceptions;

import pga.Entidad;

public class EntidadRepetidaException extends Exception
{
    private Entidad entidad;
    
    public EntidadRepetidaException(Entidad entidad, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
    }
    
    public EntidadRepetidaException(String mensaje)
    {
        super(mensaje);
    }

    public Entidad getEntidad()
    {
        return entidad;
    }
}
