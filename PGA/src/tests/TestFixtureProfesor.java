package tests;

import org.junit.After;
import org.junit.Before;

import pga.Alumno;
import pga.Asignatura;
import pga.Cursada;
import pga.Manager;
import pga.Profesor;

public class TestFixtureProfesor
{
    protected Manager manager;
    protected Alumno alumno;
    protected Profesor profesor;
    protected Asignatura asignatura;
    protected Cursada cursada;
    
    public void setUp()
    {
        //TODO
        
    }
    
    public void tearDown()
    {
        //TODO
        
    }
    
    
    public TestFixtureProfesor()
    {
        this.manager = Manager.getInstancia();
    }
}
