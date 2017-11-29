package testsCajaBlanca;

import java.util.HashMap;

import pga.Asignatura;
import pga.Cursada;
import pga.Manager;

public class TestFixtureAsignatura
{
    protected Manager manager;
    
    protected Asignatura asignatura_a;
    protected Asignatura asignatura_b;
    protected Asignatura asignatura_c;
    
    protected Cursada cursada;
    
    public TestFixtureAsignatura()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAltaAsignatura() throws Exception
    {
        this.asignatura_a = new Asignatura("Programación");
        
        HashMap<String, Asignatura> hash = new HashMap<String, Asignatura>();
        hash.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpBajaAsignaturaCamino2() throws Exception
    {
        this.asignatura_a = new Asignatura("Programación");
        
        HashMap<String, Asignatura> hash = new HashMap<>();
        hash.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hash);
        
        this.asignatura_b = new Asignatura("Programación");
    }
    
    public void setUpBajaAsignaturaCamino8() throws Exception
    {
        this.asignatura_a = new Asignatura("Programación");
        
        HashMap<String, Asignatura> hashA = new HashMap<>();
        hashA.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hashA);
        
        this.cursada = new Cursada("Mi cursada", this.asignatura_a, "01-2018", "Martes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashC = new HashMap<>();
        hashC.put(this.cursada.getId(), this.cursada);
        this.manager.getCursadas().put(this.cursada.getClave().toUpperCase(), hashC);
    }
    
    public void setUpModificaAsignaturaCamino1() throws Exception
    {
        this.asignatura_a = new Asignatura("Programación 3");
        
        HashMap<String, Asignatura> hash = new HashMap<String, Asignatura>();
        hash.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpModificaAsignaturaCamino2() throws Exception
    {
        this.asignatura_a = new Asignatura("Programación 3");
    }
    
    public void setUpModificaAsignaturaCamino3() throws Exception
    {
        this.asignatura_a = new Asignatura("Programación 3");
        
        HashMap<String, Asignatura> hash = new HashMap<String, Asignatura>();
        hash.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hash);
        
        this.asignatura_b = new Asignatura("ProgramacióN 3");
    }
    
    public void setUpModificaAsignaturaCamino4() throws Exception
    {
        this.asignatura_a = new Asignatura("Programación 3");
        this.asignatura_b = new Asignatura("ProgramacióN 3");
        
        HashMap<String, Asignatura> hash_ab = new HashMap<String, Asignatura>();
        
        hash_ab.put(this.asignatura_a.getId(), this.asignatura_a);
        hash_ab.put(this.asignatura_b.getId(), this.asignatura_b);
        
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hash_ab);
        
        this.asignatura_c = new Asignatura("ProgramacióN 2");
        
        HashMap<String, Asignatura> hash_c = new HashMap<String, Asignatura>();
        hash_c.put(this.asignatura_c.getId(), this.asignatura_c);
        this.manager.getAsignaturas().put(this.asignatura_c.getClave().toUpperCase(), hash_c);
    }
    
    public void tearDown() throws Exception
    {
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
    }
}
