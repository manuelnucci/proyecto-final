package testsCajaBlanca;

import java.util.HashMap;

import pga.Manager;
import pga.Profesor;

public class TestFixtureProfesor
{
    protected Manager manager;
    
    protected Profesor profesor_a;
    protected Profesor profesor_b;
    protected Profesor profesor_c;
    
    public TestFixtureProfesor()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpBajaProfesorCamino1() throws Exception
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpBajaProfesorCamino2() throws Exception
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Otro 2345", "123456789", "otro@gmail.com");
        
        HashMap<String, Profesor> hash = new HashMap<>();
        hash.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave().toUpperCase(), hash);
        
        this.profesor_b = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpBajaProfesorCamino3() throws Exception
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Otro 2345", "123456789", "otro@gmail.com");
        this.profesor_b = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Profesor> hash = new HashMap<>();
        
        hash.put(this.profesor_a.getLegajo(), this.profesor_a);
        hash.put(this.profesor_b.getLegajo(), this.profesor_b);
        
        this.manager.getProfesores().put(this.profesor_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpModificaProfesorCamino2() throws Exception
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Profesor> hash = new HashMap<>();
        hash.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave().toUpperCase(), hash);
    }
    
    public void setUpModificaProfesorCamino4() throws Exception
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Profesor> hash = new HashMap<>();
        hash.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave().toUpperCase(), hash);
        
        this.profesor_b = new Profesor("Manuelita", "Nuccia", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpModificaProfesorCamino5() throws Exception
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Profesor> hash = new HashMap<>();
        hash.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave().toUpperCase(), hash);
        
        this.profesor_b = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
    }
    
    public void setUpModificaProfesorCamino6() throws Exception
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        this.profesor_b = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Profesor> hash = new HashMap<>();
        
        hash.put(this.profesor_a.getLegajo(), this.profesor_a);
        hash.put(this.profesor_b.getLegajo(), this.profesor_b);
        
        this.manager.getProfesores().put(this.profesor_a.getClave().toUpperCase(), hash);
        
        this.profesor_c = new Profesor("Manuelita", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Profesor> hash_c = new HashMap<>();
        hash_c.put(this.profesor_c.getLegajo(), this.profesor_c);
        this.manager.getProfesores().put(this.profesor_c.getClave().toUpperCase(), hash_c);
    }
    
    public void setUpModificaProfesorCamino9() 
    {
        this.profesor_a = new Profesor("Manuel", "Nucci", "Alberti 2345", "987654321", "manu@gmail.com");
        
        HashMap<String, Profesor> hash = new HashMap<>();
        hash.put(this.profesor_a.getLegajo(), this.profesor_a);
        this.manager.getProfesores().put(this.profesor_a.getClave().toUpperCase(), hash);
    }

    public void tearDown() throws Exception
    {
        this.manager.getProfesores().clear();
    }
}
