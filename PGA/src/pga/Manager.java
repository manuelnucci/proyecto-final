package pga;

import java.util.Hashtable;
import java.util.Iterator;

public class Manager
{
    public static final int ALU = 0;
    public static final int PRO = 1;
    public static final int ASI = 2;
    public static final int TAMANO_MAIL = 12;
    public static final int TAMANO_LEGAJO = 7;
    public static final int TAMANO_PERIODO = 7;
    public static final int TAMANO_HORA = 7;
    private Hashtable<String, Asignatura> asignaturas;
    private Hashtable<String, Alumno> alumnos;
    private Hashtable<String, Cursada> cursadas;
    private Hashtable<String, Profesor> profesores;
    
    
    public Manager()
    {
        super();
    }
    public Manager(String nombreArchivo)
    {
        super();
        this.asignaturas = new Hashtable<String, Asignatura>();
        this.alumnos = new Hashtable<String, Alumno>();
        this.cursadas = new Hashtable<String, Cursada>();
        this.profesores = new Hashtable<String, Profesor>();
        this.leerArchivo(nombreArchivo);
    }
    
    public void guardarArchivo(String nombreArchivo)
    {
        
    }
    
    public void leerArchivo(String nombreArchivo)
    {
        
    }
    
    public void altaAlumno(String nombre, String apellido, String legajo, String domicilio, String mail, String telefono,
                            Hashtable<String, Asignatura> historia) throws EntidadRepetidaException
    {
        if(!this.alumnos.containsKey(legajo))
            this.alumnos.put(legajo, new Alumno(nombre, apellido, legajo, domicilio, mail, telefono, historia));
        else
            throw new EntidadRepetidaException("Alumno repetido");
    }
    
    public void bajaAlumno(Alumno alumno) throws NoEstaEntidadException
    {
        Iterator<Cursada> i;
        
        if(this.alumnos.containsKey(alumno.getLegajo()))
        {
            i = this.cursadas.values().iterator();
            while(i.hasNext())
            {
                i.next().getAlumnos().remove(alumno.getLegajo());
            }
            this.alumnos.remove(alumno.getLegajo());
        }
        else
            throw new NoEstaEntidadException("Alumno no encontrado en el sistema");
    }
    
    public void bajaAlumnoDeCursada(Alumno alumno, Cursada cursada) throws NoEstaEntidadException
    {
        if(cursada.getAlumnos().remove(alumno.getLegajo()) == null)
            throw new NoEstaEntidadException("Alumno no encontrado en la cursada");
    }
    
    public void modificaAlumno(Alumno alumno, String nombre, String apellido, String legajo, String domicilio, String mail, String telefono,
                            Hashtable<String, Asignatura> historia) throws EntidadRepetidaException
    {
        if(!this.alumnos.containsKey(legajo))
        {    
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.setLegajo(legajo);
            alumno.setDomicilio(domicilio);
            alumno.setMail(mail);
            alumno.setHistoriaAcademica(historia);
        }
        else
            throw new EntidadRepetidaException("Alumno repetido al intentar modificarlo");      
    }
    
    public Alumno ubicarAlumno(String legajo) throws NoEstaEntidadException
    {
        Alumno ret = this.alumnos.get(legajo);
        
        if(ret == null)
            throw new NoEstaEntidadException("Alumno no ubicado");
        
        return ret;
    }
    
    public void bajaProfesorDeCursada(Profesor profesor, Cursada cursada) throws NoEstaEntidadException
    {
        if(cursada.getProfesores().remove(profesor.getLegajo()) == null)
            throw new NoEstaEntidadException("Profesor no encontrado en la cursada");
    }
    
    
    
    public void altaCursada(String id, Asignatura asignatura, String periodo, String dia, String hora) throws EntidadRepetidaException
    {
        if(!this.cursadas.containsKey(id))
            this.cursadas.put(id, new Cursada(id, asignatura, periodo, dia, hora));
        else
            throw new EntidadRepetidaException("Cursada repetida");
    }
    
    public void bajaCursada(Cursada cursada) throws NoEstaEntidadException
    {
        Cursada c = this.cursadas.remove(cursada.getId());
        
        if(c == null)
            throw new NoEstaEntidadException("Cursada no encontrada");
    }
    
    public void modificacionCursada(Cursada cursada, Asignatura asignatura, String periodo, String dia, String horaInicio, String horaFin)
    {
        
    }
    
    public void verificaAlumnoAptoParaCursada(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        this.verificaAlumnoHabilitado(alumno, cursada);
        this.verificaAlumnoOcupado(alumno, cursada);
    }
    
    public void verificaAlumnoHabilitado(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        Iterator<Asignatura> ia;
        boolean sigue = true;
        
        ia = cursada.getAsignatura().getCorrelatividades().values().iterator();
        while(ia.hasNext() && sigue)
            sigue = alumno.getHistoriaAcademica().containsKey(ia.next().getId());
        
        if(!sigue)
            throw new EntidadNoAptaParaCursadaException("El alumno no cumple con las correlatividades");
    }
    
    public void verificaAlumnoOcupado(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        Iterator<Cursada> ic;
        Cursada c;
        boolean sigue = true;
        
        ic = this.cursadas.values().iterator();
        while(ic.hasNext() && sigue)
        {
            c = ic.next();
            if(c.getAlumnos().containsKey(alumno.getLegajo()))
            {
                sigue = !((cursada.getHoraInicio().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraInicio().compareTo(c.getHoraFin()) <= 0) ||
                        (cursada.getHoraFin().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraFin().compareTo(c.getHoraFin()) <= 0)); 
            }
        }
        
        if(!sigue)
            throw new EntidadNoAptaParaCursadaException("El alumno no cumple con las franjas horarias");
    }
    
    public void verificaProfesorAptoParaCursada(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        this.verificaProfesorHabilitado(profesor, cursada);
        this.verificaProfesorOcupado(profesor, cursada);
    }
            
    public void verificaProfesorHabilitado(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        if(!profesor.getCompetencias().containsKey(cursada.getAsignatura().getId()))
                throw new EntidadNoAptaParaCursadaException("El profesor no esta habilitado para la cursada");

    }
    public void verificaProfesorOcupado(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        Iterator<Asignatura> ia;
        Iterator<Cursada> ic;
        Cursada c;
        boolean sigue = true;
        
        ic = this.cursadas.values().iterator();
        while(ic.hasNext() && sigue)
        {
            c = ic.next();
            if(c.getProfesores().containsKey(profesor.getLegajo()))
            {
                sigue = !((cursada.getHoraInicio().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraInicio().compareTo(c.getHoraFin()) <= 0) ||
                        (cursada.getHoraFin().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraFin().compareTo(c.getHoraFin()) <= 0)); 
            }
        }
            
        if(!sigue)
            throw new EntidadNoAptaParaCursadaException("El profesor no cumple con las franjas horarias");
    }
    
    public boolean verificaId(String id, int tipo)
    {
        boolean ret = false;
        String parteNum;
        
        if(id.length() == TAMANO_LEGAJO)
        {
            parteNum = id.substring(3);
            if(parteNum.compareTo("0000") >= 0 && parteNum.compareTo("9999") <= 0)
            {
                parteNum = id.substring(0, 2);
                switch(tipo)
                {
                    case ALU:   ret = parteNum.equals("ALU");
                                break;
                    case PRO:   ret = parteNum.equals("PRO");
                                break;
                    case ASI:   ret = parteNum.equals("ASI");
                                break;
                    default:    ret = parteNum.equals("CUR");
                                break;
                }
            }
        }
        return ret;
    }
    
    public boolean verificaMail(String mail)
    {
        return (mail.length() == TAMANO_MAIL && mail.indexOf("@") == 5);
    }
    
    public boolean verificaCursadaPeriodo(String periodo)
    {
        boolean ret = false;
        String cad;
        
        if(periodo.length() == TAMANO_PERIODO && periodo.indexOf("-") == 2)
        {
            cad = periodo.substring(0,1);
            if(cad.equals("01") || cad.equals("02"))
            {
                cad = periodo.substring(3, 6);
                ret = cad.compareTo("2000") >= 0 && cad.compareTo("2100") <= 0;
            }
        }
        return ret;
    }
    
    public boolean verificaCursadaHora(String hora)
    {
        boolean ret = false;
        String cad;
        
        if(hora.length() == TAMANO_HORA && hora.indexOf(":") == 2)
        {
            cad = hora.substring(0,1);
            if(cad.compareTo("00") >= 0 && cad.compareTo("23") <= 0)
            {
                cad = hora.substring(3, 4);
                ret = cad.compareTo("00") >= 0 && cad.compareTo("59") <= 0;
            }
        }
        return ret;
    }
}