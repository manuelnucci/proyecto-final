package tests;

import java.util.HashMap;

import pga.Asignatura;
import pga.Cursada;
import pga.Manager;

public class TestFixtureCursada
{
    protected Manager manager;
    
    protected Asignatura asignatura_a;
    protected Asignatura asignatura_b;
    protected Asignatura asignatura_c;
    protected Asignatura asignatura_d;
    
    protected Cursada cursada_a;
    protected Cursada cursada_b;
    protected Cursada cursada_c;
    
    public TestFixtureCursada()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAltayModif()
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hash_a = new HashMap<>();
        this.manager.getAsignaturas().put(this.asignatura_a.getClave(), hash_a);
        
        this.asignatura_b = new Asignatura("Quimica");
        
        HashMap<String, Asignatura> hash_b = new HashMap<>();
        this.manager.getAsignaturas().put(this.asignatura_b.getClave(), hash_b);
        
        this.cursada_b = new Cursada(" Cursada Quimica 1", this.asignatura_b, "01-2017", "Lunes", "12:00", "14:00");
        HashMap<String, Cursada> hashCur_b = new HashMap<>();
        hashCur_b.put(this.cursada_a.getClave(), this.cursada_b);
        this.manager.getCursadas().put(this.cursada_b.getClave(), hashCur_b);
        
        this.asignatura_c = new Asignatura("Fisica");
        
        HashMap<String, Asignatura> hash_c = new HashMap<>();
        this.manager.getAsignaturas().put(this.asignatura_c.getClave(), hash_c);
        
        this.cursada_c = new Cursada(" Cursada Fisica 1", this.asignatura_c, "02-2017", "Martes", "12:00", "14:00");
        
        this.asignatura_d = new Asignatura("Estadistica");
    }
    
    public void setUpBaja()
    {
        
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hash_a = new HashMap<>();
        this.manager.getAsignaturas().put(this.asignatura_a.getClave(), hash_a);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        this.cursada_b = new Cursada("Cursada Mate A 2", asignatura_a, "01-2017", "Lunes", "16:00", "18:00");
        
        HashMap<String, Cursada> hashCur_a = new HashMap<>();
        hashCur_a.put(this.cursada_a.getClave(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave(), hashCur_a);
        
    }
    
    public void setUpUbicar()
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hash_a = new HashMap<>();
        this.manager.getAsignaturas().put(this.asignatura_a.getClave(), hash_a);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        this.cursada_b = new Cursada("Cursada Mate A 2", asignatura_a, "01-2017", "Lunes", "16:00", "18:00");
        this.cursada_c = new Cursada("Cursada Mate A 3", asignatura_a, "01-2017", "Martes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCur_a = new HashMap<>();
        hashCur_a.put(this.cursada_a.getClave(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave(), hashCur_a);
        
        HashMap<String, Cursada> hashCur_b = new HashMap<>();
        hashCur_b.put(this.cursada_b.getClave(), this.cursada_b);
        this.manager.getCursadas().put(this.cursada_b.getClave(), hashCur_b);
        
        HashMap<String, Cursada> hashCur_c = new HashMap<>();
        hashCur_c.put(this.cursada_c.getClave(), this.cursada_c);
        this.manager.getCursadas().put(this.cursada_c.getClave(), hashCur_c);
    }
    
    public void tearDown()
    {
        this.manager.getCursadas().clear();
        this.manager.getAsignaturas().clear();
        this.manager.getAlumnos().clear();
        this.manager.getProfesores().clear();
    }
}
