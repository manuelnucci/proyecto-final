package testsCajaBlanca;

import java.util.HashMap;

import pga.Alumno;
import pga.Manager;

public class TestFixtureAlumno
{
    protected Manager manager;
    
    protected Alumno alumno_a;
    protected Alumno alumno_b;
    protected Alumno alumno_c;
    
    public TestFixtureAlumno()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAltaAlumno() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Alumno> hash = new HashMap<String, Alumno>();
        hash.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpBajaAlumnoCamino1() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpBajaAlumnoCamino2() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Otro 2345", "123456789", "otro@gmail.com");
        
        HashMap<String, Alumno> hash = new HashMap<String, Alumno>();
        hash.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash);
        
        this.alumno_b = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpBajaAlumnoCamino3() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        this.alumno_b = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Alumno> hash = new HashMap<String, Alumno>();
        
        hash.put(this.alumno_a.getLegajo(), this.alumno_a);
        hash.put(this.alumno_b.getLegajo(), this.alumno_b);
        
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpModificaAlumnoCamino2() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Alumno> hash = new HashMap<String, Alumno>();
        hash.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpModificaAlumnoCamino4() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Alumno> hash = new HashMap<String, Alumno>();
        hash.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash);
        
        this.alumno_b = new Alumno("Manuelita", "Nuccia", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpModificaAlumnoCamino5() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Alumno> hash = new HashMap<String, Alumno>();
        hash.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash);
        
        this.alumno_b = new Alumno("Manuel", "Nuccia", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpModificaAlumnoCamino6() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        this.alumno_b = new Alumno("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Alumno> hash = new HashMap<String, Alumno>();
        
        hash.put(this.alumno_a.getLegajo(), this.alumno_a);
        hash.put(this.alumno_b.getLegajo(), this.alumno_b);
        
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash);
        
        this.alumno_c = new Alumno("Manuelita", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Alumno> hash_c = new HashMap<String, Alumno>();
        hash_c.put(this.alumno_c.getLegajo(), this.alumno_c);
        this.manager.getAlumnos().put(this.alumno_c.getClave().toUpperCase(), hash_c);
    }
    
    public void tearDown() throws Exception
    {
        this.manager.getAlumnos().clear();
        this.manager.getCursadas().clear();
    }
}
