package tests;

import pga.Alumno;
import pga.Asignatura;
import pga.Cursada;
import pga.Manager;
import pga.Profesor;

public class TestFixture
{
    protected Manager manager;
    protected Alumno alumno;
    protected Profesor profesor;
    protected Asignatura asignatura;
    protected Cursada cursada;
    
    public TestFixture()
    {
        this.manager = Manager.getInstancia();
        this.alumno = new Alumno("Martin", "Perez", "Catamarca 2050", "2235235475", "mprez@live.com");
    }
}
