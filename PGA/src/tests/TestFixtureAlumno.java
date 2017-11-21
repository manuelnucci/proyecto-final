package tests;

import java.util.HashMap;

import pga.Alumno;
import pga.Asignatura;
import pga.Cursada;
import pga.Manager;

public class TestFixtureAlumno
{
    protected Manager manager;
    
    protected Alumno alumno_a;
    protected Alumno alumno_b;
    protected Alumno alumno_c;
    
    protected Asignatura asignatura_a;
    protected Asignatura asignatura_b;
    protected Asignatura asignatura_c;
    
    protected Cursada cursada_a;
    protected Cursada cursada_b;
    protected Cursada cursada_c;
    protected Cursada cursada_d;
    
    public TestFixtureAlumno()
    {
        this.manager = Manager.getInstancia();
    }
    
    public void setUpAgregarYModif() throws Exception
    {
        this.alumno_a = new Alumno("Manuel", "Nucci", "Rawson 273", "4518663", "manuucci96@gmail.com");
        
        HashMap<String, Alumno> hash_a = new HashMap<String, Alumno>();
        hash_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash_a);
    }
    
    public void setUpBaja() throws Exception
    {
        this.alumno_a = new Alumno("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        this.alumno_b = new Alumno("Martin", "Perez", "Catamarca 2050", "2235235475", "mpr@live.com");
        this.alumno_c = new Alumno("Esteban", "Dido", "Jujuy 3403", "224543454", "edido@gmail.com");
        
        HashMap<String, Alumno> hash_a = new HashMap<String, Alumno>();
        hash_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash_a);
        
        HashMap<String, Alumno> hash_c = new HashMap<String, Alumno>();
        hash_c.put(alumno_c.getLegajo(), alumno_c);
        this.manager.getAlumnos().put(alumno_c.getClave().toUpperCase(), hash_c);
        
        this.asignatura_a = new Asignatura("Mate A");
        this.cursada_a = new Cursada("Cursada Mate A", this.asignatura_a, "01-2017", "Lunes", "09:00", "12:00");
        this.cursada_a.getAlumnos().put(this.alumno_c.getLegajo(), this.alumno_c);
        
        HashMap<String, Cursada> hashCur = new HashMap<String, Cursada>();
        hashCur.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCur);
    }
    
    public void setUpUbicar() throws Exception
    {
        this.alumno_a = new Alumno("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        this.alumno_b = new Alumno("Martin", "Perez", "Catamarca 2050", "2235235475", "mpr@live.com");
        this.alumno_c = new Alumno("Mario", "Neta", "Alvear 4354", "2235235475", "mario@gmail.com");
        
        HashMap<String, Alumno> hash_a = new HashMap<String, Alumno>();
        hash_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hash_a);
        
        HashMap<String, Alumno> hash_b = new HashMap<String, Alumno>();
        hash_b.put(alumno_b.getLegajo(), alumno_b);
        this.manager.getAlumnos().put(alumno_b.getClave().toUpperCase(), hash_b);
        
        HashMap<String, Alumno> hash_c = new HashMap<String, Alumno>();
        hash_c.put(alumno_c.getLegajo(), alumno_c);
        this.manager.getAlumnos().put(alumno_c.getClave().toUpperCase(), hash_c);
    }
    
    public void setUpAgregarACursada() throws Exception
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<String, Asignatura>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hashAsignatura_a);
        
        this.asignatura_b = new Asignatura("Mate B");
        
        HashMap<String, Asignatura> correlatividades = new HashMap<String, Asignatura>();
        correlatividades.put(this.asignatura_a.getId(), this.asignatura_a);
        this.asignatura_b.setCorrelatividades(correlatividades);
        
        HashMap<String, Asignatura> hashAsignatura_b = new HashMap<String, Asignatura>();
        hashAsignatura_b.put(this.asignatura_b.getId(), this.asignatura_b);
        this.manager.getAsignaturas().put(this.asignatura_b.getClave().toUpperCase(), hashAsignatura_b);
        
        this.asignatura_c = new Asignatura("Química");
        
        HashMap<String, Asignatura> hashAsignatura_c = new HashMap<String, Asignatura>();
        hashAsignatura_c.put(this.asignatura_c.getId(), this.asignatura_c);
        this.manager.getAsignaturas().put(this.asignatura_c.getClave().toUpperCase(), hashAsignatura_c);
        
        this.alumno_a = new Alumno("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        
        HashMap<String, Alumno> hashAlumno_a = new HashMap<String, Alumno>();
        hashAlumno_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hashAlumno_a);
        
        this.alumno_b = new Alumno("Donald", "Duck", "Salta 2403", "4645764", "dduck@gmail.com");
        
        HashMap<String, Asignatura> historiaAcademica = new HashMap<String, Asignatura>();
        historiaAcademica.put(this.asignatura_a.getId(), this.asignatura_a);
        this.alumno_b.setHistoriaAcademica(historiaAcademica);
        
        HashMap<String, Alumno> hashAlumno_b = new HashMap<String, Alumno>();
        hashAlumno_b.put(this.alumno_b.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_b.getClave().toUpperCase(), hashAlumno_b);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        
        this.cursada_a.getAlumnos().put(this.alumno_a.getLegajo(), this.alumno_a);
        
        HashMap<String, Cursada> hashCursada_a = new HashMap<String, Cursada>();
        hashCursada_a.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCursada_a);
        
        this.cursada_b = new Cursada("Cursada Mate B 1", asignatura_b, "01-2017", "Lunes", "16:00", "18:00");
        
        HashMap<String, Cursada> hashCursada_b = new HashMap<String, Cursada>();
        hashCursada_b.put(this.cursada_b.getId(), this.cursada_b);
        this.manager.getCursadas().put(this.cursada_b.getClave().toUpperCase(), hashCursada_b);
        
        this.cursada_c = new Cursada("Cursada Química 1", asignatura_c, "01-2017", "Martes", "12:00", "14:00");
        
        this.cursada_c.getAlumnos().put(this.alumno_b.getLegajo(), this.alumno_b);
        
        HashMap<String, Cursada> hashCursada_c = new HashMap<String, Cursada>();
        hashCursada_c.put(this.cursada_c.getId(), this.cursada_c);
        this.manager.getCursadas().put(this.cursada_c.getClave().toUpperCase(), hashCursada_c);
        
        this.cursada_d = new Cursada("Cursada Química 2", asignatura_c, "01-2017", "Lunes", "12:00", "14:00");
        
        HashMap<String, Cursada> hashCursada_d = new HashMap<String, Cursada>();
        hashCursada_d.put(this.cursada_d.getId(), this.cursada_d);
        this.manager.getCursadas().put(this.cursada_d.getClave().toUpperCase(), hashCursada_d);
    }
    
    public void setUpBajaDeCursada() throws Exception
    {
        this.asignatura_a = new Asignatura("Mate A");
        
        HashMap<String, Asignatura> hashAsignatura_a = new HashMap<String, Asignatura>();
        hashAsignatura_a.put(this.asignatura_a.getId(), this.asignatura_a);
        this.manager.getAsignaturas().put(this.asignatura_a.getClave().toUpperCase(), hashAsignatura_a);
        
        this.alumno_a = new Alumno("Susana", "Horia", "Salta 2403", "4645764", "shoria@gmail.com");
        
        HashMap<String, Alumno> hashAlumno_a = new HashMap<String, Alumno>();
        hashAlumno_a.put(this.alumno_a.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_a.getClave().toUpperCase(), hashAlumno_a);
        
        this.alumno_b = new Alumno("Donald", "Duck", "Salta 2403", "4645765", "dduck@gmail.com");
        
        HashMap<String, Alumno> hashAlumno_b = new HashMap<String, Alumno>();
        hashAlumno_b.put(this.alumno_b.getLegajo(), this.alumno_a);
        this.manager.getAlumnos().put(this.alumno_b.getClave().toUpperCase(), hashAlumno_b);
        
        this.cursada_a = new Cursada("Cursada Mate A 1", asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
        
        this.cursada_a.getAlumnos().put(this.alumno_a.getLegajo(), this.alumno_a);
        
        HashMap<String, Cursada> hashCursada_a = new HashMap<String, Cursada>();
        hashCursada_a.put(this.cursada_a.getId(), this.cursada_a);
        this.manager.getCursadas().put(this.cursada_a.getClave().toUpperCase(), hashCursada_a);
    }

    public void tearDown() throws Exception
    {
        this.manager.getAlumnos().clear();
        this.manager.getAsignaturas().clear();
        this.manager.getCursadas().clear();
    }
}
