package pga;

import java.util.HashMap;

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
    private HashMap<String, Alumno> alumnos; // Las claves serán los legajos de los alumnos
    private HashMap<String, Profesor> profesores; // Las claves serán los legajos de los profesores
    
    public Cursada()
    {
        super();    
    }

    public Cursada(String nombre, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin)
    {
        this.id = ID_LEGAJO + String.format("%04d", numCursada++);
        this.nombre = nombre;
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.alumnos = new HashMap<String, Alumno>(); // Los alumnos estarán en una tabla hash cuya clave será
                                                        // el legajo del alumno
        this.profesores = new HashMap<String, Profesor>(); // Los profesores estarán en una tabla hash cuya clave será
                                                             // el legajo del profesos
    }

    public String getId()
    {
        return id;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setAsignatura(Asignatura asignatura)
    {
        this.asignatura = asignatura;
    }

    public Asignatura getAsignatura()
    {
        return asignatura;
    }

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }

    public String getPeriodo()
    {
        return periodo;
    }

    public void setDia(String dia)
    {
        this.dia = dia;
    }

    public String getDia()
    {
        return dia;
    }

    public void setHoraInicio(String horaInicio)
    {
        this.horaInicio = horaInicio;
    }

    public String getHoraInicio()
    {
        return horaInicio;
    }

    public void setHoraFin(String horaFin)
    {
        this.horaFin = horaFin;
    }

    public String getHoraFin()
    {
        return horaFin;
    }

    public void setAlumnos(HashMap<String, Alumno> alumnos)
    {
        this.alumnos = alumnos;
    }

    public HashMap<String, Alumno> getAlumnos()
    {
        return alumnos;
    }

    public void setProfesores(HashMap<String, Profesor> profesores)
    {
        this.profesores = profesores;
    }

    public HashMap<String, Profesor> getProfesores()
    {
        return profesores;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Cursada))
        {
            return false;
        }
        final Cursada other = (Cursada) object;
        if (!(id == null ? other.id == null : id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public int compareTo(Object object) {   
        return this.id.compareTo(((Cursada) object).getId()); // Las cursadas serán ordenadas por su ID
    }

    @Override
    public String toString()
    {
        return "Id: " + this.getId() + "\nAsignatura: " + this.getAsignatura().getNombre() + "\nPeriodo: " +
               this.getPeriodo() + "\nDia: " + this.getDia() + "\nHora de inicio: " + this.getHoraInicio() +
               "\nHora de fin: " + this.horaFin;
    }
}
