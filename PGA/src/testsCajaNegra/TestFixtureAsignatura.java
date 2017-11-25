package testsCajaNegra;

import java.util.HashMap;

import pga.Alumno;
import pga.Asignatura;
import pga.Cursada;
import pga.Manager;
import pga.Profesor;

public class TestFixtureAsignatura
{
    protected Manager manager;
    
    protected Alumno alumno;
    
    protected Asignatura asignatura_a;
    protected Asignatura asignatura_b;
    protected Asignatura asignatura_c;
    
    protected Cursada cursada;
    protected Profesor profesor;
    
    public TestFixtureAsignatura()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAgregarYModif() throws Exception
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hash = new HashMap<String, Asignatura>();
        hash.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpBaja() throws Exception
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<String, Asignatura>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hashAsignatura_a);
        
        this.asignatura_b = new Asignatura("Algebra");
        
        this.asignatura_c = new Asignatura("Mate B");
        
        HashMap<String, Asignatura> correlatividades = new HashMap<String, Asignatura>();
        correlatividades.put(this.asignatura_a.getId(), this.asignatura_a);
        this.asignatura_c.setCorrelatividades(correlatividades);
        
        HashMap<String, Asignatura> hashAsignatura_c = new HashMap<String, Asignatura>();
        hashAsignatura_c.put(this.asignatura_c.getId(), this.asignatura_c);
        this.manager.getAsignaturas().put(this.asignatura_c.getClave().toUpperCase(), hashAsignatura_c);
        
        
        this.profesor = new Profesor("Susana", "Torio", "Garay 1543", "4735453", "storio@yahoo.com");
        
        HashMap<String, Asignatura> competenecias = new HashMap<String, Asignatura>();
        competenecias.put(this.asignatura_a.getId(), this.asignatura_a);
        this.profesor.setCompetencias(competenecias);
        
        HashMap<String, Profesor> hashProfesor = new HashMap<String, Profesor>();
        hashProfesor.put(this.profesor.getLegajo(), this.profesor);
        this.manager.getProfesores().put(this.profesor.getClave().toUpperCase(), hashProfesor);
        
        
        this.cursada = new Cursada("Cursada Mate A", this.asignatura_a, "01-2017", "Lunes", "09:00", "12:00");
        
        HashMap<String, Cursada> hashCursada = new HashMap<String, Cursada>();
        hashCursada.put(this.cursada.getId(), this.cursada);
        this.manager.getCursadas().put(this.cursada.getClave().toUpperCase(), hashCursada);
    }
    
    public void setUpUbicar() throws Exception
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<String, Asignatura>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getId(), hashAsignatura_a);
        
        this.asignatura_b = new Asignatura("Mate B");
        
        HashMap<String, Asignatura> hashAsignatura_b = new HashMap<String, Asignatura>();
        hashAsignatura_b.put(this.asignatura_b.getId(), this.asignatura_b);
        this.manager.getAsignaturas().put(this.asignatura_b.getClave().toUpperCase(), hashAsignatura_b);
        
        this.asignatura_c = new Asignatura("Química");
        
        HashMap<String, Asignatura> hashAsignatura_c = new HashMap<String, Asignatura>();
        hashAsignatura_c.put(this.asignatura_c.getId(), this.asignatura_c);
        this.manager.getAsignaturas().put(this.asignatura_c.getClave().toUpperCase(), hashAsignatura_c);
    }
    
    public void tearDown() throws Exception
    {
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
        this.manager.getProfesores().clear();
    }
}
