package pga;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Manager
{
    private static Manager instancia = null;
    
    private HashMap<String, TreeSet<Alumno>> alumnos;
    private HashMap<String, TreeSet<Profesor>> profesores;
    private HashMap<String, Asignatura> asignaturas;
    private HashMap<String, Cursada> cursadas;
    
    private Manager()
    {
        super();
    }
    
    private Manager(String nombreArchivo)
    {
        super();
        this.alumnos = new HashMap<String, TreeSet<Alumno>>();
        this.profesores = new HashMap<String, TreeSet<Profesor>>();
        this.asignaturas = new HashMap<String, Asignatura>();
        this.cursadas = new HashMap<String, Cursada>();
        this.leerArchivo(nombreArchivo); // Leemos el archivo XML con los datos de la última sesión
    }
    
    /**
     * Patrón Singleton
     */
    public static Manager getInstancia(String nombreArchivo)
    {
        if (instancia == null)
            instancia = new Manager(nombreArchivo);
        
        return instancia;
    }
    
    public void guardarArchivo(String nombreArchivo)
    {
        
    }
    
    public void leerArchivo(String nombreArchivo)
    {
        
    }

    public void altaAlumno(String nombre, String apellido, String domicilio, String telefono, String mail,
                            HashMap<String, Asignatura> historiaAcademica) // RF01
    {
        Alumno alumno = (Alumno) Factory.getPersona(Factory.ALUMNO, nombre, apellido, domicilio, telefono, mail, historiaAcademica);
        String nombreCompleto = alumno.getNombre() + alumno.getApellido();
        
        if (this.alumnos.containsKey(nombreCompleto))
            this.alumnos.get(nombreCompleto).add(alumno); // Agregamos al TreeSet el alumno
        else
        {
            TreeSet<Alumno> tree = new TreeSet<Alumno>(); // Creamos una nueva cubeta y depositamos al alumno allí
            tree.add(alumno);
            this.alumnos.put(nombreCompleto, tree); 
        }
    }
    
    public void bajaAlumno(Alumno alumno) throws NoEstaEntidadException // RF02
    {
        Iterator<Cursada> it;
        String nombreCompleto = alumno.getNombre() + alumno.getApellido();
        
        if (this.alumnos.containsKey(nombreCompleto) && this.alumnos.get(nombreCompleto).remove(alumno))
            // Si el alumno existe en la facultad y fue posible eliminarlo proseguimos a eliminarlo de todas las cursadas
        {
            if (this.alumnos.get(nombreCompleto).isEmpty()) // El Tree ha quedado vacío
                this.alumnos.remove(nombreCompleto);
            
            it = this.cursadas.values().iterator(); // Eliminamos al alumno de todas las cursadas inscripto
            while(it.hasNext())
            {
                it.next().getAlumnos().remove(alumno.getLegajo()); // Se lo busca por legajo aquí
                // El remove puede dar T o F, logre eliminarlo o no seguimos avanzando.
            }
        }
        else
            throw new NoEstaEntidadException("Alumno no encontrado en el sistema.");
    }
    
    public void modificaAlumno(Alumno alumno, String nombre, String apellido, String domicilio, String telefono, String mail,
                            HashMap<String, Asignatura> historiaAcademica) // RF03
    {   
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setTelefono(telefono);
        alumno.setMail(mail);
        alumno.setHistoriaAcademica(historiaAcademica);     
    }
    
    public TreeSet<Alumno> ubicarAlumno(String nombre, String apellido) throws NoEstaEntidadException // RF05
    {
        TreeSet<Alumno> ret = this.alumnos.get(nombre + apellido);
        
        if(ret == null)
            throw new NoEstaEntidadException("Alumno no ubicado.");
        
        return ret;
    }
    
    public void altaAlumnoACursada(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException 
        // RF11, RF13
    {
        this.verificaAlumnoAptoParaCursada(alumno, cursada);
        cursada.getAlumnos().put(alumno.getLegajo(), alumno); // La clave del alumno será su legajo dentro de la Cursada
    }
                                
    public void bajaAlumnoDeCursada(Alumno alumno, Cursada cursada) throws NoEstaEntidadException // RF11, RF14
    {
        if(cursada.getAlumnos().remove(alumno.getLegajo()) == null)
            throw new NoEstaEntidadException("Alumno no encontrado en la cursada.");
    }
    
    /*
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     */
    
    public void altaProfesor(String nombre, String apellido, String domicilio, String telefono, String mail,
                            HashMap<String, Asignatura> competencias) // RF01
    {
        Profesor profesor = (Profesor) Factory.getPersona(Factory.PROFESOR, nombre, apellido, domicilio, telefono, mail, competencias);
        String nombreCompleto = profesor.getNombre() + profesor.getApellido();
        
        if (this.profesores.containsKey(nombreCompleto))
            this.profesores.get(nombreCompleto).add(profesor); // Agregamos al TreeSet el profesor
        else
        {
            TreeSet<Profesor> tree = new TreeSet<Profesor>(); // Creamos una nueva cubeta y depositamos al alumno allí
            tree.add(profesor);
            this.profesores.put(nombreCompleto, tree); 
        }
    }
    
    public void bajaProfesor(Profesor profesor) throws NoEstaEntidadException // RF02
    {
        Iterator<Cursada> it;
        String nombreCompleto = profesor.getNombre() + profesor.getApellido();
        
        if (this.profesores.containsKey(nombreCompleto) && this.profesores.get(nombreCompleto).remove(profesor))
            // Si el profesor existe en la facultad y fue posible eliminarlo proseguimos a eliminarlo de todas las cursadas
        {
            if (this.profesores.get(nombreCompleto).isEmpty()) // El Tree ha quedado vacío, sin profesores
                this.profesores.remove(nombreCompleto);
            
            it = this.cursadas.values().iterator(); // Eliminamos al profesor de todas las cursadas que dicta
            while(it.hasNext())
            {
                it.next().getProfesores().remove(profesor.getLegajo()); // Se lo busca por legajo aquí
                // El remove puede dar T o F, logre eliminarlo o no seguimos avanzando.
            }
        }
        else
            throw new NoEstaEntidadException("Profesor no encontrado en el sistema.");
    }
    
    public void modificaProfesor(Profesor profesor, String nombre, String apellido, String domicilio, String telefono, String mail,
                            HashMap<String, Asignatura> competencias) // RF03
    {   
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setDomicilio(domicilio);
        profesor.setTelefono(telefono);
        profesor.setMail(mail);
        profesor.setCompetencias(competencias);     
    }
    
    public TreeSet<Profesor> ubicarProfesor(String nombre, String apellido) throws NoEstaEntidadException // RF05
    {
        TreeSet<Profesor> ret = this.profesores.get(nombre + apellido);
        
        if(ret == null)
            throw new NoEstaEntidadException("Profesor no ubicado.");
        
        return ret;
    }
    
    public void altaProfesorACursada(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
        // RF12, RF15
    {
        this.verificaProfesorAptoParaCursada(profesor, cursada);
        cursada.getProfesores().put(profesor.getLegajo(), profesor); // La clave del profesor será su legajo dentro de 
                                                                     // la Cursada
    }
                                
    public void bajaProfesorDeCursada(Profesor profesor, Cursada cursada) throws NoEstaEntidadException // RF12, RF16
    {
        if(cursada.getProfesores().remove(profesor.getLegajo()) == null)
            throw new NoEstaEntidadException("Profesor no encontrado en la cursada.");
        
        if (cursada.getProfesores().isEmpty()) // Si la cursada ha quedado sin profesores se la debe eliminar
            this.cursadas.remove(cursada.getNombre());
    }
    
    /*
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     */
    
    public void altaAsignatura(String nombre, HashMap<String, Asignatura> correlatividades) 
        throws EntidadRepetidaException // RF01
    {
        Asignatura asignatura = Factory.getAsignatura(nombre, correlatividades);
        
        if (this.asignaturas.containsKey(nombre)) // Las asignaturas no pueden tener el mismo nombre
            throw new EntidadRepetidaException("Asignatura repetida.");
        else
            this.asignaturas.put(nombre, asignatura);
    }
    
    public void bajaAsignatura(Asignatura asignatura) throws NoEstaEntidadException // RF02
    {
        Iterator<Cursada> it;
        Cursada cursada;
        
        if (this.asignaturas.remove(asignatura.getNombre()) == null)
            throw new NoEstaEntidadException("Asignatura no encontrada en el sistema.");
        else
        {            
            it = this.cursadas.values().iterator(); // Eliminamos todas las cursadas en las que la asignatura aparece
            while(it.hasNext())
            {
                cursada = it.next();
                if (cursada.getAsignatura().equals(asignatura))
                    this.cursadas.remove(cursada.getNombre());
            }
        }
    }
    
    public void modificaAsignatura(Asignatura asignatura, String nombre, HashMap<String, Asignatura> correlatividades) 
        throws EntidadRepetidaException // RF03
    {   
        if (this.asignaturas.containsKey(nombre))
            throw new EntidadRepetidaException("Nombre de asignatura repetido. Imposible modificarla.");
        else
        {
            asignatura.setNombre(nombre);
            asignatura.setCorrelatividades(correlatividades);
        }
    }
    
    public Asignatura ubicarAsignatura(String nombre) throws NoEstaEntidadException // RF05
    {
        Asignatura ret = this.asignaturas.get(nombre);
        
        if(ret == null)
            throw new NoEstaEntidadException("Asignatura no ubicada.");
        
        return ret;
    }
    
    /*
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     */

    public void altaCursada(String nombre, Asignatura asignatura, String periodo, String dia, String horaInicio, 
        String horaFin)throws EntidadRepetidaException // RF06
    {
        /**
         * El requisito de verificar que la cursada sea viable (RF17) no tiene sentido ya que podrían existir dos 
         * cursadas, incluso de la misma asignatura, en el mismo día y horario.
         * Verificamos únicamente que no exista otra cursada con el mismo nombre.
         */
        if(this.cursadas.containsKey(nombre)) // Si existe una cursada ya con el mismo nombre
            throw new EntidadRepetidaException("Cursada repetida. Ya existe una cursada con el mismo nombre.");
        else    
            this.cursadas.put(nombre, Factory.getCursada(asignatura, periodo, dia, horaInicio, horaFin));
    }
    
    public void bajaCursada(Cursada cursada) throws NoEstaEntidadException // RF07
    {
        if(this.cursadas.remove(cursada.getNombre()) == null)
            throw new NoEstaEntidadException("Cursada no encontrada en el sistema.");
    }
    
    public void modificaCursada(Cursada cursada, String nombre, Asignatura asignatura, String periodo, String dia, 
        String horaInicio, String horaFin) throws EntidadRepetidaException
    {
        if (this.cursadas.containsKey(nombre))
            throw new EntidadRepetidaException("Nombre de cursada repetido. Imposible modificarla.");
        {
            cursada.setNombre(nombre);
            cursada.setAsignatura(asignatura);
            cursada.setPeriodo(periodo);
            cursada.setDia(dia);
            cursada.setHoraInicio(horaInicio);
            cursada.setHoraFin(horaFin);   
        }
    }
    
    public Cursada ubicarCursada(String nombre) throws NoEstaEntidadException // RF05
    {
        Cursada ret = this.cursadas.get(nombre);
        
        if(ret == null)
            throw new NoEstaEntidadException("Cursada no ubicada.");
        
        return ret;
    }
    
    /*
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     */
    
    public void verificaAlumnoAptoParaCursada(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        this.verificaAlumnoHabilitado(alumno, cursada);
        this.verificaAlumnoOcupado(alumno, cursada);
    }
    
    public void verificaAlumnoHabilitado(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
        // RF19
    {
        Iterator<Asignatura> it;
        boolean sigue = true;
        
        it = cursada.getAsignatura().getCorrelatividades().values().iterator();
        while(it.hasNext() && sigue)
            sigue = alumno.getHistoriaAcademica().containsKey(it.next().getId()); // La clave de la asignatura es su ID
        
        if(!sigue)
            throw new EntidadNoAptaParaCursadaException("El alumno no cumple con las correlatividades para inscribirse" +
                "a la cursada.");
    }
    
    public void verificaAlumnoOcupado(Alumno alumno, Cursada cursada) throws EntidadNoAptaParaCursadaException
        // RF21
    {
        Iterator<Cursada> it;
        Cursada c;
        boolean sigue = true;
        
        it = this.cursadas.values().iterator();
        while(it.hasNext() && sigue)
        {
            c = it.next();
            if(c.getAlumnos().containsKey(alumno.getLegajo()))
            {
                sigue = !((cursada.getHoraInicio().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraInicio().compareTo(c.getHoraFin()) <= 0) ||
                        (cursada.getHoraFin().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraFin().compareTo(c.getHoraFin()) <= 0)); 
            }
        }
        
        if(!sigue)
            throw new EntidadNoAptaParaCursadaException("El alumno no cumple con las franjas horarias para inscribirse" +
                "a la cursada.");
    }
    
    public void verificaProfesorAptoParaCursada(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        this.verificaProfesorHabilitado(profesor, cursada);
        this.verificaProfesorOcupado(profesor, cursada);
    }
            
    public void verificaProfesorHabilitado(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
        // RF18
    {
        if(!profesor.getCompetencias().containsKey(cursada.getAsignatura().getId()))
                throw new EntidadNoAptaParaCursadaException("El profesor no esta habilitado para dictar la cursada.");

    }
    public void verificaProfesorOcupado(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
        // RF20
    {
        Iterator<Cursada> it;
        Cursada c;
        boolean sigue = true;
        
        it = this.cursadas.values().iterator();
        while(it.hasNext() && sigue)
        {
            c = it.next();
            if(c.getProfesores().containsKey(profesor.getLegajo()))
            {
                sigue = !((cursada.getHoraInicio().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraInicio().compareTo(c.getHoraFin()) <= 0) ||
                        (cursada.getHoraFin().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraFin().compareTo(c.getHoraFin()) <= 0)); 
            }
        }
            
        if(!sigue)
            throw new EntidadNoAptaParaCursadaException("El profesor no cumple con las franjas horarias para inscribirse" +
                "a la cursada.");
    }
    
    /*public void verificaPersonaOcupado(Persona persona, Cursada cursada) throws EntidadNoAptaParaCursadaException
    {
        Iterator<Cursada> it;
        Cursada c;
        boolean sigue = true;
        
        it = this.cursadas.values().iterator();
        while(it.hasNext() && sigue)
        {
            c = it.next();
            if((persona.getLegajo().startsWith("ALU") && c.getAlumnos().containsKey(persona.getLegajo())) || 
                persona.getLegajo().startsWith("PRO") && c.getProfesores().containsKey(persona.getLegajo()))
            {
                sigue = !((cursada.getHoraInicio().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraInicio().compareTo(c.getHoraFin()) <= 0) ||
                        (cursada.getHoraFin().compareTo(c.getHoraInicio()) >= 0 && 
                            cursada.getHoraFin().compareTo(c.getHoraFin()) <= 0)); 
            }
        }
        
        if(!sigue)
            throw new EntidadNoAptaParaCursadaException("El alumno no cumple con las franjas horarias");
    }*/
}
