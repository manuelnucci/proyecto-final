package pga;

import exceptions.EntidadNoAptaParaCursadaException;
import exceptions.NoEstaEntidadException;

import gui.VentanaPrincipal;

import java.util.HashMap;

/*
 * Clase que sirve como intermediaria entre el modelo y la interfaz gráfica.
 * Posee métodos que funcionan como mensajeros invocando métodos del modelo y, si fuese necesario,
 * devuelven los resultados a la GUI para que los utilice luego.
 */
public class Controlador
{
    private Manager modelo; // Modelo del sistema con todos sus métodos.
    private VentanaPrincipal ventana; // Referencia a la ventana principal de la interfaz gráfica.

    /**
     * Constructor que crea una nueva instancia del Controlador
     * 
     * <b>Pre:</b> Los parámetros deben ser válidos.
     * <b>Post:</b> Se crea una nueva instancia del controlador.
     * 
     * @param modelo Es el modelo o sistema. Modelo != null.
     * @param ventana Es la interfaz de la aplicación. Ventana != null
     */
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
    
    public void bajaAlumno(Alumno alumno) throws NoEstaEntidadException
    {
        this.modelo.bajaAlumno(alumno);
    }
    
    public void modificaAlumno(Alumno alumno, String nombre, String apellido, String domicilio, String telefono, 
                               String mail) throws NoEstaEntidadException
    {
        this.modelo.modificaAlumno(alumno, nombre, apellido, domicilio, telefono, mail);
    }
    
    public HashMap<String, Alumno> ubicarAlumno(String nombre, String apellido) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAlumno(nombre, apellido);
    }
    
    public void altaAlumnoACursada(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        this.modelo.altaAlumnoACursada(alumno, cursada);
    }
    
    public HashMap<String, Asignatura> ubicarAsignatura(String nombre) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAsignatura(nombre);
    }
    
    public HashMap<String, Cursada> ubicarCursada(String nombre) throws NoEstaEntidadException
    {
        return this.modelo.ubicarCursada(nombre);
    }
    
    public void guardarArchivo()
    {
        PersistenciaXML.guardarArchivo(this.modelo);
    }  
}
