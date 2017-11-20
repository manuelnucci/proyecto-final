package tests;

import java.util.HashMap;

import pga.Asignatura;
import pga.Manager;

public class TestFixtureAsignatura
{
    protected Manager manager;
    
    protected Asignatura asignatura;
    
    public TestFixtureAsignatura()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAgregarYModif() throws Exception
    {
        this.asignatura = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hash = new HashMap<String, Asignatura>();
        hash.put(this.asignatura.getId(), this.asignatura);
        this.manager.getAsignaturas().put(this.asignatura.getId(), hash);
    }
    
    public void setUpBaja() throws Exception
    {

    }
    
    public void tearDown() throws Exception
    {
        this.manager.getAlumnos().clear();
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
        this.manager.getProfesores().clear();
    }
}
