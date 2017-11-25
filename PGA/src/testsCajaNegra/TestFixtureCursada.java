package testsCajaNegra;

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
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hashAsignatura_a);
        
        this.asignatura_b = new Asignatura("Quimica");
        
        HashMap<String, Asignatura> hashAsignatura_b = new HashMap<>();
        hashAsignatura_b.put(this.asignatura_b.getId(), this.asignatura_b);
        this.manager.getAsignaturas().put(this.asignatura_b.getClave().toUpperCase(), hashAsignatura_b);
        
        this.cursada_b = new Cursada("Cursada Química 1", this.asignatura_b, "01-2017", "Lunes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCur_b = new HashMap<>();
        hashCur_b.put(this.cursada_b.getId(), this.cursada_b);
        this.manager.getCursadas().put(this.cursada_b.getClave().toUpperCase(), hashCur_b);
        
        this.asignatura_c = new Asignatura("Física");
        
        HashMap<String, Asignatura> hashAsignatura_c = new HashMap<>();
        hashAsignatura_c.put(this.asignatura_c.getId(), this.asignatura_c);
        this.manager.getAsignaturas().put(this.asignatura_c.getClave().toUpperCase(), hashAsignatura_c);
        
        this.cursada_c = new Cursada(" Cursada Fisica 1", this.asignatura_c, "02-2017", "Martes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCur_c = new HashMap<>();
        hashCur_c.put(this.cursada_c.getId(), this.cursada_c);
        this.manager.getCursadas().put(this.cursada_c.getClave().toUpperCase(), hashCur_c);
        
        this.asignatura_d = new Asignatura("Estadística");
        
        HashMap<String, Asignatura> hashAsignatura_d = new HashMap<>();
        hashAsignatura_d.put(this.asignatura_d.getId(), this.asignatura_d);
        this.manager.getAsignaturas().put(this.asignatura_d.getClave().toUpperCase(), hashAsignatura_d);
    }
    
    public void setUpBaja()
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hashAsignatura_a);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCur_a = new HashMap<>();
        hashCur_a.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCur_a);
        
        this.cursada_b = new Cursada("Cursada Mate A 2", asignatura_a, "01-2017", "Lunes", "16:00", "18:00");
    }
    
    public void setUpUbicar()
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hashAsignatura_a);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        this.cursada_b = new Cursada("Cursada Mate A 2", asignatura_a, "01-2017", "Lunes", "16:00", "18:00");
        this.cursada_c = new Cursada("Cursada Mate A 3", asignatura_a, "01-2017", "Martes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCur_a = new HashMap<>();
        hashCur_a.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCur_a);
        
        HashMap<String, Cursada> hashCur_b = new HashMap<>();
        hashCur_b.put(this.cursada_b.getId(), this.cursada_b);
        this.manager.getCursadas().put(this.cursada_b.getClave().toUpperCase(), hashCur_b);
        
        HashMap<String, Cursada> hashCur_c = new HashMap<>();
        hashCur_c.put(this.cursada_c.getId(), this.cursada_c);
        this.manager.getCursadas().put(this.cursada_c.getClave().toUpperCase(), hashCur_c);
    }
    
    public void tearDown()
    {
        this.manager.getCursadas().clear();
        this.manager.getAsignaturas().clear();
    }
}
