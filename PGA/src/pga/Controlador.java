package pga;

public class Controlador
{
    private Manager modelo;
    private GUI vista;
    
    public Controlador(Manager modelo, GUI vista)
    {
        super();
        this.modelo = modelo;
        this.vista = vista;
    }
}
