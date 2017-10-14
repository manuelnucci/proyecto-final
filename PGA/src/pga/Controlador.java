package pga;

import gui.Ventana;

import sun.swing.StringUIClientPropertyKey;

public class Controlador
{
    private Manager modelo;
    private Ventana ventana;
    
    public Controlador(Manager modelo, Ventana ventana)
    {
        super();
        this.modelo = modelo;
        this.ventana = ventana;
    }
}
