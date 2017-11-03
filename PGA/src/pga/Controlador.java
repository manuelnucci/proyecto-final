package pga;

import exceptions.EmailInvalidoException;
import exceptions.EntidadNoAptaParaCursadaException;
import exceptions.EntidadRepetidaException;
import exceptions.HoraInvalidaException;
import exceptions.NoEstaEntidadException;
import exceptions.PeriodoInvalidoException;

import gui.VentanaPrincipal;

import java.io.FileNotFoundException;

import java.util.HashMap;

/**
 * Clase que sirve como intermediaria entre el modelo y la interfaz gráfica.
 * Posee métodos que funcionan como mensajeros invocando métodos del modelo y, si fuese necesario,
 * devuelven los resultados a la GUI para que los utilice luego.
 */
public class Controlador
{
    private Manager modelo; // Modelo del sistema con todos sus métodos.
    private VentanaPrincipal ventana; // Referencia a la ventana principal de la interfaz gráfica.
    
    /**
     * Constructor que crea una nueva instancia del Controlador.<br>
     * 
     * <b>Pre:</b> Los parámetros deben ser válidos.<br>
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
    
    public void altaAlumno(String nombre, String apellido, String domicilio, String telefono, String mail) throws EmailInvalidoException
    {
        this.modelo.altaAlumno(nombre, apellido, domicilio, telefono, mail);
    }
    
    public void bajaAlumno(Alumno alumno) throws NoEstaEntidadException
    {
        this.modelo.bajaAlumno(alumno);
    }
    
    public void modificaAlumno(Alumno alumno, String nombre, String apellido, String domicilio, String telefono, 
                               String mail) throws NoEstaEntidadException, EmailInvalidoException
    {
        this.modelo.modificaAlumno(alumno, nombre, apellido, domicilio, telefono, mail);
    }
    
    public void aprobarAsignatura(Alumno alumno, Asignatura asignatura) throws exceptions.EntidadRepetidaException
    {
        this.modelo.aprobarAsignatura(alumno, asignatura);
    }
    
    public void quitarAsignatura(Alumno alumno, Asignatura asignatura) throws NoEstaEntidadException
    {
        this.modelo.quitarAsignatura(alumno, asignatura);
    }
    
    public HashMap<String, Alumno> ubicarAlumno(String nombre, String apellido) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAlumno(nombre, apellido);
    }
    
    public void altaAlumnoACursada(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        this.modelo.altaAlumnoACursada(alumno, cursada);
    }
    
    public void bajaAlumnoDeCursada(Alumno alumno, Cursada cursada) throws NoEstaEntidadException
    {
        this.modelo.bajaAlumnoDeCursada(alumno, cursada);
    }
    
    /*---------------------------------------------------------------------------------------------------------------*/
    
    public void altaProfesor(String nombre, String apellido, String domicilio, String telefono, String mail) throws EmailInvalidoException
    {
        this.modelo.altaProfesor(nombre, apellido, domicilio, telefono, mail);
    }
    
    public void bajaProfesor(Profesor profesor) throws NoEstaEntidadException
    {
        this.modelo.bajaProfesor(profesor);
    }
    
    public void modificaProfesor(Profesor profesor, String nombre, String apellido, String domicilio, String telefono,
                                 String mail) throws NoEstaEntidadException, EmailInvalidoException
    {
        this.modelo.modificaProfesor(profesor, nombre, apellido, domicilio, telefono, mail);
    }
    
    public void agregarCompetencia(Profesor profesor, Asignatura asignatura) throws EntidadRepetidaException
    {
        this.modelo.agregarCompetencia(profesor, asignatura);
    }
    
    public void bajaCompetencia(Profesor profesor, Asignatura asignatura) throws NoEstaEntidadException
    {
        this.modelo.bajaCompetencia(profesor, asignatura);
    }    
    
    public HashMap<String, Profesor> ubicarProfesor(String nombre, String apellido) throws NoEstaEntidadException
    {
        return this.modelo.ubicarProfesor(nombre, apellido);
    }
    
    public void altaProfesorACursada(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        this.modelo.altaProfesorACursada(profesor, cursada);
    }
    
    public void bajaProfesorDeCursada(Profesor profesor, Cursada cursada) throws NoEstaEntidadException
    {
        this.modelo.bajaProfesorDeCursada(profesor, cursada);
    }
    
    /*---------------------------------------------------------------------------------------------------------------*/
    
    public void altaAsignatura(String nombre)
    {
        this.modelo.altaAsignatura(nombre);
    }
    
    public void bajaAsignatura(Asignatura asignatura) throws NoEstaEntidadException
    {
        this.modelo.bajaAsignatura(asignatura);
    }
    
    public void modificaAsignatura(Asignatura asignatura, String nombre)
        throws NoEstaEntidadException
    {
        this.modelo.modificaAsignatura(asignatura, nombre);
    }
    
    public void agregarCorrelativa(Asignatura asignatura, Asignatura correlativa) throws exceptions.EntidadRepetidaException
    {
        this.modelo.agregarCorrelativa(asignatura, correlativa);
    }
    
    public void bajaCorrelativa(Asignatura asignatura, Asignatura correlativa) throws NoEstaEntidadException
    {
        this.modelo.bajaCorrelativa(asignatura, correlativa);
    }
    
    public HashMap<String, Asignatura> ubicarAsignatura(String nombre) throws NoEstaEntidadException
    {
        return this.modelo.ubicarAsignatura(nombre);
    }
    
    /*---------------------------------------------------------------------------------------------------------------*/
    
    public void altaCursada(String nombre, Asignatura asignatura, String periodo, String dia, String horaInicio, 
                            String horaFin) throws PeriodoInvalidoException, HoraInvalidaException
    {
        this.modelo.altaCursada(nombre, asignatura, periodo, dia, horaInicio, horaFin);
    }
    
    public void bajaCursada(Cursada cursada) throws NoEstaEntidadException
    {
        this.modelo.bajaCursada(cursada);
    }
    
    public void modificaCursada(Cursada cursada, String nombre, Asignatura asignatura, String periodo, String dia, 
                                String horaInicio, String horaFin) throws NoEstaEntidadException, PeriodoInvalidoException, 
                                HoraInvalidaException
    {
        this.modelo.modificaCursada(cursada, nombre, asignatura, periodo, dia, horaInicio, horaFin);
    }
    
    public HashMap<String, Cursada> ubicarCursada(String nombre) throws NoEstaEntidadException
    {
        return this.modelo.ubicarCursada(nombre);
    }
    
    /*---------------------------------------------------------------------------------------------------------------*/
    
    public void guardarArchivo() throws FileNotFoundException
    {
        PersistenciaXML.guardarArchivo(this.modelo);
    }
}
