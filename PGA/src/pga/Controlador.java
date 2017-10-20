package pga;

import exceptions.NoEstaEntidadException;

import gui.VentanaPrincipal;

import java.util.HashMap;

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
    
    public boolean verificaMail(String mail)
    {
        return Formato.verificaMail(mail);
    }
    
    public void altaAlumno(String nombre, String apellido, String domicilio, String telefono, String mail)
    {
        this.modelo.altaAlumno(nombre, apellido, domicilio, telefono, mail);
    }
    
    public HashMap<String, Alumno> ubicarAlumno(String nombre, String apellido) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAlumno(nombre, apellido);
    }
    
    public HashMap<String, Asignatura> ubicarAsignatura(String nombre) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAsignatura(nombre);
    }
    
    public void guardarArchivo()
    {
        PersistenciaXML.guardarArchivo(this.modelo);
    }  
}
