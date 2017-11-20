package tests;

import java.util.HashMap;

import pga.Asignatura;
import pga.Cursada;
import pga.Manager;
import pga.Profesor;

public class TestFixtureProfesor
{
    protected Manager manager;
    
    protected Profesor profesor_a;
    protected Profesor profesor_b;
    protected Profesor profesor_c;
    
    protected Asignatura asignatura_a;
    protected Asignatura asignatura_b;
    protected Asignatura asignatura_c;
    protected Asignatura asignatura_d;
    
    protected Cursada cursada_a;
    protected Cursada cursada_b;
    protected Cursada cursada_c;
    protected Cursada cursada_d;
    
    public TestFixtureProfesor()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAgregarYModif() throws Exception
    {
        this.profesor_a = new Profesor("Leonel", "Guccione", "Calle 123", "4868749", "leonelg@gmail.com");
        
        HashMap<String, Profesor> hash_a = new HashMap<>();
        hash_a.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave(), hash_a);
    }
    
    public void setUpBaja() throws Exception
    {
        this.profesor_a = new Profesor("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        this.profesor_b = new Profesor("Martin", "Perez", "Catamarca 2050", "2235235475", "mpr@live.com");
        this.profesor_c = new Profesor("Esteban", "Dido", "Jujuy 3403", "224543454", "edido@gmail.com");
        
        HashMap<String, Profesor> hash_a = new HashMap<>();
        hash_a.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave(), hash_a);
        
        HashMap<String, Profesor> hash_c = new HashMap<>();
        hash_c.put(profesor_c.getLegajo(), profesor_c);
        this.manager.getProfesores().put(profesor_c.getClave(), hash_c);
        
        this.asignatura_a = new Asignatura("Mate A"); 
        this.cursada_a = new Cursada("Cursada Mate A", this.asignatura_a, "01-2017", "Lunes", "09:00", "12:00");
        this.cursada_a.getProfesores().put(this.profesor_a.getLegajo(), this.profesor_a);
        
        HashMap<String, Cursada> hashCur = new HashMap<>();
        hashCur.put(this.cursada_a.getClave(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave(), hashCur);
    }
    
    public void setUpUbicar() throws Exception
    {
        this.profesor_a = new Profesor("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        this.profesor_b = new Profesor("Martin", "Perez", "Catamarca 2050", "2235235475", "mpr@live.com");
        this.profesor_c = new Profesor("Mario", "Neta", "Alvear 4354", "2235235475", "mario@gmail.com");
        
        HashMap<String, Profesor> hash_a = new HashMap<>();
        hash_a.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave(), hash_a);
        
        HashMap<String, Profesor> hash_b = new HashMap<>();
        hash_b.put(profesor_b.getLegajo(), profesor_b);
        this.manager.getProfesores().put(profesor_b.getClave(), hash_b);
        
        HashMap<String, Profesor> hash_c = new HashMap<>();
        hash_c.put(profesor_c.getLegajo(), profesor_c);
        this.manager.getProfesores().put(profesor_c.getClave(), hash_c);
    }
    
    public void setUpAgregarACursada() throws Exception
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<String, Asignatura>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave(), hashAsignatura_a);
        
        this.asignatura_b = new Asignatura("Mate B");
        
        HashMap<String, Asignatura> correlatividades = new HashMap<String, Asignatura>();
        correlatividades.put(this.asignatura_a.getId(), this.asignatura_a);
        this.asignatura_b.setCorrelatividades(correlatividades);
        
        HashMap<String, Asignatura> hashAsignatura_b = new HashMap<String, Asignatura>();
        hashAsignatura_b.put(this.asignatura_b.getId(), this.asignatura_b);
        this.manager.getAsignaturas().put(this.asignatura_b.getClave(), hashAsignatura_b);
        
        this.asignatura_c = new Asignatura("Química");
        
        HashMap<String, Asignatura> hashAsignatura_c = new HashMap<String, Asignatura>();
        hashAsignatura_c.put(this.asignatura_c.getId(), this.asignatura_c);
        this.manager.getAsignaturas().put(this.asignatura_c.getClave(), hashAsignatura_c);
        
        this.asignatura_d = new Asignatura("Algebra A");
        
        HashMap<String, Asignatura> hashAsignatura_d = new HashMap<String, Asignatura>();
        hashAsignatura_d.put(this.asignatura_d.getId(), this.asignatura_d);
        this.manager.getAsignaturas().put(this.asignatura_d.getClave(), hashAsignatura_d);
        
        this.profesor_a = new Profesor("Mate", "Cito", "Jujuy 5403", "4675464", "mate@gmail.com");
        
        HashMap<String, Asignatura> competencias_a = new HashMap<String, Asignatura>();
        competencias_a.put(this.asignatura_a.getId(), this.asignatura_a);
        competencias_a.put(this.asignatura_d.getId(), this.asignatura_d);
        this.profesor_a.setCompetencias(competencias_a);
        
        HashMap<String, Profesor> hashProfesor_a = new HashMap<String, Profesor>();
        hashProfesor_a.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave(), hashProfesor_a);
        
        this.profesor_b = new Profesor("Cristiano", "Ronaldo", "Alvear 342", "4654364", "ronald@live.com");
        
        HashMap<String, Asignatura> competencias_b = new HashMap<String, Asignatura>();
        competencias_b.put(this.asignatura_b.getId(), this.asignatura_b);
        competencias_b.put(this.asignatura_c.getId(), this.asignatura_c);
        this.profesor_b.setCompetencias(competencias_b);
        
        HashMap<String, Profesor> hashProfesor_b = new HashMap<String, Profesor>();
        hashProfesor_b.put(this.profesor_b.getLegajo(), this.profesor_b);
        this.manager.getProfesores().put(this.profesor_b.getClave(), hashProfesor_b);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        
        this.cursada_a.getProfesores().put(this.profesor_a.getLegajo(), this.profesor_a);
        
        HashMap<String, Cursada> hashCursada_a = new HashMap<String, Cursada>();
        hashCursada_a.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave(), hashCursada_a);
        
        this.cursada_b = new Cursada("Cursada Mate B 1", asignatura_b, "01-2017", "Lunes", "16:00", "18:00");
        
        HashMap<String, Cursada> hashCursada_b = new HashMap<String, Cursada>();
        hashCursada_b.put(this.cursada_b.getId(), this.cursada_b);
        this.manager.getCursadas().put(this.cursada_b.getClave(), hashCursada_b);
        
        this.cursada_c = new Cursada("Cursada Química 1", asignatura_c, "01-2017", "Martes", "12:00", "14:00");
        
        this.cursada_c.getProfesores().put(this.profesor_b.getLegajo(), this.profesor_b);
        
        HashMap<String, Cursada> hashCursada_c = new HashMap<String, Cursada>();
        hashCursada_c.put(this.cursada_c.getId(), this.cursada_c);
        this.manager.getCursadas().put(this.cursada_c.getClave(), hashCursada_c);
        
        this.cursada_d = new Cursada("Cursada Álgebra 1", asignatura_d, "01-2017", "Lunes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCursada_d = new HashMap<String, Cursada>();
        hashCursada_d.put(this.cursada_d.getId(), this.cursada_d);
        this.manager.getCursadas().put(this.cursada_d.getClave(), hashCursada_d);
    }
    
    public void setUpBajaDeCursada() throws Exception
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<String, Asignatura>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave(), hashAsignatura_a);
        
        this.profesor_a = new Profesor("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        
        HashMap<String, Asignatura> competencias_a = new HashMap<String, Asignatura>();
        competencias_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.profesor_a.setCompetencias(competencias_a);
        
        HashMap<String, Profesor> hashProfesor_a = new HashMap<String, Profesor>();
        hashProfesor_a.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave(), hashProfesor_a);
        
        this.profesor_b = new Profesor("Donald", "Duck", "Castelli 8503", "4644543", "dduck@gmail.com");
        
        HashMap<String, Asignatura> competencias_b = new HashMap<String, Asignatura>();
        competencias_b.put(this.asignatura_a.getId(), this.asignatura_a);
        this.profesor_b.setCompetencias(competencias_b);
        
        HashMap<String, Profesor> hashProfesor_b = new HashMap<String, Profesor>();
        hashProfesor_b.put(this.profesor_b.getLegajo(), this.profesor_b);
        this.manager.getProfesores().put(this.profesor_b.getClave(), hashProfesor_b);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        
        this.cursada_a.getProfesores().put(this.profesor_a.getLegajo(), this.profesor_a);
        
        HashMap<String, Cursada> hashCursada_a = new HashMap<String, Cursada>();
        hashCursada_a.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave(), hashCursada_a);
    }

    public void tearDown() throws Exception
    {
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
        this.manager.getProfesores().clear();
    }
}
