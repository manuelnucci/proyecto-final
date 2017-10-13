package pga;

import java.util.Hashtable;

public class Cursada implements Comparable
{
    private static int numCursada = 0;
    private static final String ID_LEGAJO = "CUR";
    
    private String id;
    private String nombre;
    private Asignatura asignatura;
    private String periodo;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private Hashtable<String, Profesor> profesores;
    private Hashtable<String, Alumno> alumnos;
    
    public Cursada()
    {
        super();    
    }


    public Cursada(Asignatura asignatura, String periodo, String dia, String horaInicio)
    {
        this.id = ID_LEGAJO + String.format("%04d", numCursada++);
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.profesores = new Hashtable<String, Profesor>();
        this.alumnos = new Hashtable<String, Alumno>();
    }

    public String getId()
    {
        return id;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public Asignatura getAsignatura()
    {
        return asignatura;
    }

    public String getPeriodo()
    {
        return periodo;
    }

    public String getDia()
    {
        return dia;
    }

    public String getHoraInicio()
    {
        return horaInicio;
    }

    public String getHoraFin()
    {
        return horaFin;
    }

    public Hashtable<String, Profesor> getProfesores()
    {
        return profesores;
    }

    public Hashtable<String, Alumno> getAlumnos()
    {
        return alumnos;
    }

    @Override
    public int compareTo(Object object) {
        Cursada cursada = (Cursada) object;
        
        return this.nombre.compareTo(cursada.getNombre());
    }

    @Override
    public String toString()
    {
        return this.getId() + this.getAsignatura().getNombre() + this.getPeriodo() + this.getDia() + this.getHoraInicio();
    }
}
