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
    
    protected Asignatura asignatura;
    protected Cursada cursada;
    
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
        
        this.asignatura = new Asignatura("Mate A"); 
        this.cursada = new Cursada("Cursada Mate A", this.asignatura, "01-2017", "Lunes", "09:00", "12:00");
        this.cursada.getProfesores().put(this.profesor_a.getLegajo(), this.profesor_a);
        
        HashMap<String, Cursada> hashCur = new HashMap<>();
        hashCur.put(this.cursada.getClave(), this.cursada);
        this.manager.getCursadas().put(this.cursada.getClave(), hashCur);
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

    public void tearDown() throws Exception
    {
        this.manager.getAlumnos().clear();
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
        this.manager.getProfesores().clear();
    }

}
