package testsCajaBlanca;

import java.util.HashMap;

import pga.Asignatura;
import pga.Cursada;
import pga.Manager;


public class TestFixtureCursada
{
    protected Manager manager;
    
    protected Asignatura asignatura;
    
    protected Cursada cursada_a;
    protected Cursada cursada_b;
    protected Cursada cursada_c;
    
    public TestFixtureCursada()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAltaCursada() throws Exception
    {
        this.asignatura = new Asignatura("Programación");
        this.cursada_a = new Cursada("Mi cursada", this.asignatura, "01-2018", "Martes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCur = new HashMap<>();
        hashCur.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCur);
    }
    
    public void setUpModificaCursadaCamino4() throws Exception
    {
        this.asignatura = new Asignatura("Programación 3");
        
        HashMap<String, Asignatura> hashAsignatura = new HashMap<>();
        hashAsignatura.put(this.asignatura.getId(), this.asignatura);
        this.manager.getAsignaturas().put(this.asignatura.getClave().toUpperCase(), hashAsignatura);
        
        this.cursada_a = new Cursada("cursada1", this.asignatura, "01-2017", "Lunes", "14:00", "16:00");
        
        HashMap<String, Cursada> hashCur = new HashMap<>();
        hashCur.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCur);
    }
    
    public void setUpModificaCursadaCamino5() throws Exception
    {
        this.asignatura = new Asignatura("Programación 3");
        
        HashMap<String, Asignatura> hashAsignatura = new HashMap<>();
        hashAsignatura.put(this.asignatura.getId(), this.asignatura);
        this.manager.getAsignaturas().put(this.asignatura.getClave().toUpperCase(), hashAsignatura);
        
        this.cursada_a = new Cursada("cursada1", this.asignatura, "01-2017", "Lunes", "14:00", "16:00");
        
        HashMap<String, Cursada> hashCur = new HashMap<>();
        hashCur.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCur);
        
        this.cursada_b = new Cursada("cursada2", this.asignatura, "01-2017", "Lunes", "14:00", "16:00");
    }
    
    public void setUpModificaCursadaCamino9() throws Exception
    {
        this.asignatura = new Asignatura("Programación 3");
        
        HashMap<String, Asignatura> hashAsignatura = new HashMap<>();
        hashAsignatura.put(this.asignatura.getId(), this.asignatura);
        this.manager.getAsignaturas().put(this.asignatura.getClave().toUpperCase(), hashAsignatura);
        
        this.cursada_a = new Cursada("cursada1", this.asignatura, "01-2017", "Lunes", "14:00", "16:00");
        this.cursada_b = new Cursada("CURSADA1", this.asignatura, "01-2017", "Lunes", "14:00", "16:00");
        
        HashMap<String, Cursada> hashCur_ab = new HashMap<>();
        
        hashCur_ab.put(this.cursada_a.getId(), this.cursada_a);
        hashCur_ab.put(this.cursada_b.getId(), this.cursada_b);
        
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCur_ab);
        
        this.cursada_c = new Cursada("CURSADA2", this.asignatura, "01-2017", "Lunes", "14:00", "16:00");
        
        HashMap<String, Cursada> hashCur_c = new HashMap<>();
        hashCur_c.put(this.cursada_c.getId(), this.cursada_c);
        this.manager.getCursadas().put(this.cursada_c.getClave().toUpperCase(), hashCur_c);
    }
    
    public void tearDown() throws Exception
    {
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
    }
}
