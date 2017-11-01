package exceptions;

import pga.Entidad;

public class NoEstaEntidadException extends Exception
{
    private Entidad entidad;
    
    public NoEstaEntidadException(Entidad entidad, String mensaje)
    {
        super(mensaje);
        this.entidad = entidad;
    }

    public NoEstaEntidadException(String mensaje)
    {
        super(mensaje);
    }
    
    public Entidad getEntidad()
    {
        return entidad;
    }
}
