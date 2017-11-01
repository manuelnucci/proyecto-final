package pga;

import exceptions.NoEstaEntidadException;

import gui.VentanaPrincipal;

import java.util.HashMap;

import sun.swing.StringUIClientPropertyKey;

public class Controlador
{
    private Manager modelo;
    private VentanaPrincipal ventana;
    
    public Controlador(Manager modelo, VentanaPrincipal ventana)
    {
        super();
        this.modelo = modelo;
        this.ventana = ventana;
    }
    
    public HashMap<String, Alumno> ubicarAlumno(String nombre, String apellido) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAlumno(nombre, apellido);
    }
    
    public HashMap<String, Asignatura> ubicarAsignatura(String nombre) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAsignatura(nombre);
    }
    
    public void altaAsignatura(String nombre) // RF01
    {
        this.modelo.altaAsignatura(nombre);
    }
    
    public void guardarArchivo()
    {
        PersistenciaXML.guardarArchivo(this.modelo);
    }
    
}
