package tests;

import java.util.HashMap;

import pga.Alumno;
import pga.Asignatura;
import pga.Cursada;
import pga.Manager;
import pga.Profesor;

public class TestFixtureAlumno
{
    protected Manager manager;
    
    protected Alumno alumno_a;
    protected Alumno alumno_b;
    protected Alumno alumno_c;
    
    protected Profesor profesor1;
    protected Profesor profesor2;
    protected Profesor profesor3;
    
    protected Asignatura asignatura;
    protected Cursada cursada;
    
    public TestFixtureAlumno()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAgregarYModif() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Rawson 273", "4518663", "manuucci96@gmail.com");
        
        HashMap<String, Alumno> hash_a = new HashMap<String, Alumno>();
        hash_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave(), hash_a);
    }
    
    public void setUpBaja() throws Exception
    {
        this.alumno_a = new Alumno("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        this.alumno_b = new Alumno("Martin", "Perez", "Catamarca 2050", "2235235475", "mpr@live.com");
        this.alumno_c = new Alumno("Esteban", "Dido", "Jujuy 3403", "224543454", "edido@gmail.com");
        
        HashMap<String, Alumno> hash_a = new HashMap<String, Alumno>();
        hash_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave(), hash_a);
        
        HashMap<String, Alumno> hash_c = new HashMap<String, Alumno>();
        hash_c.put(alumno_c.getLegajo(), alumno_c);
        this.manager.getAlumnos().put(alumno_c.getClave(), hash_c);
        
        this.asignatura = new Asignatura("Mate A");
        this.cursada = new Cursada("Cursada Mate A", this.asignatura, "01-2017", "Lunes", "09:00", "12:00");
        this.cursada.getAlumnos().put(this.alumno_a.getLegajo(), this.alumno_a);
        
        HashMap<String, Cursada> hashCur = new HashMap<String, Cursada>();
        hashCur.put(this.cursada.getClave(), this.cursada);
        this.manager.getCursadas().put(this.cursada.getClave(), hashCur);
    }
    
    public void setUpUbicar() throws Exception
    {
        this.alumno_a = new Alumno("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        this.alumno_b = new Alumno("Martin", "Perez", "Catamarca 2050", "2235235475", "mpr@live.com");
        this.alumno_c = new Alumno("Mario", "Neta", "Alvear 4354", "2235235475", "mario@gmail.com");
        
        HashMap<String, Alumno> hash_a = new HashMap<String, Alumno>();
        hash_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave(), hash_a);
        
        HashMap<String, Alumno> hash_b = new HashMap<String, Alumno>();
        hash_b.put(alumno_b.getLegajo(), alumno_b);
        this.manager.getAlumnos().put(alumno_b.getClave(), hash_b);
        
        HashMap<String, Alumno> hash_c = new HashMap<String, Alumno>();
        hash_c.put(alumno_c.getLegajo(), alumno_c);
        this.manager.getAlumnos().put(alumno_c.getClave(), hash_c);
    }

    public void tearDown() throws Exception
    {
        this.manager.getAlumnos().clear();
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
        this.manager.getProfesores().clear();
    }
}
