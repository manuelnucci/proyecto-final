package pga;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedOutputStream;

import java.io.FileOutputStream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Manager
{
    private static Manager instancia = null;
    // Las claves serán los nombres y apellidos de los alumnos
    private HashMap<String, TreeSet<Alumno>> alumnos = new HashMap<String, TreeSet<Alumno>>();
    // Las claves serán los nombres y apellidos de los profesores
    private HashMap<String, TreeSet<Profesor>> profesores = new HashMap<String, TreeSet<Profesor>>(); 
    // Las claves serán los nombres de las asignaturas
    private HashMap<String, TreeSet<Asignatura>> asignaturas = new HashMap<String, TreeSet<Asignatura>>(); 
    // Las claves serán los nombres de las cursadas
    private HashMap<String, TreeSet<Cursada>> cursadas = new HashMap<String, TreeSet<Cursada>>();

    private Manager()
    {
        super();
    }
    
    /**
     * Patrón Singleton
     */
    public static Manager getInstancia()
    {
        if (instancia == null)
            instancia = new Manager();
        
        return instancia;
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
        Iterator<TreeSet<Cursada>> itT;
        Iterator<Cursada> it;
        String nombreCompleto = alumno.getNombre() + alumno.getApellido();
        
        if (this.alumnos.containsKey(nombreCompleto) && this.alumnos.get(nombreCompleto).remove(alumno))
            // Si el alumno existe en la facultad y fue posible eliminarlo proseguimos a eliminarlo de todas las cursadas
        {
            if (this.alumnos.get(nombreCompleto).isEmpty()) // El Tree ha quedado vacío
                this.alumnos.remove(nombreCompleto);
            
            // Eliminamos al alumno de todas las cursadas inscripto
            itT = this.cursadas.values().iterator();
            // La sentencia anterior nos devuelve un iterator de TreeSet 
            while(itT.hasNext())
            {
                it = itT.next().iterator();
                while (it.hasNext())
                    it.next().getAlumnos().remove(alumno.getLegajo()); // Se lo busca por legajo aquí
                    // El remove puede dar T o F, logre eliminarlo o no seguimos avanzando.
            }
        }
        else
            throw new NoEstaEntidadException("Alumno no encontrado en el sistema.");
    }
    
    public void modificaAlumno(Alumno alumno, String nombre, String apellido, String domicilio, String telefono, 
                               String mail, HashMap<String, Asignatura> historiaAcademica) 
                               throws NoEstaEntidadException // RF03
    {   
        String nombreViejo;
        String nombreNuevo;
        
        if (!alumno.getNombre().equals(nombre) || !alumno.getApellido().equals(apellido))
        {
            nombreViejo = alumno.getNombre() + alumno.getApellido();
            
            if (this.alumnos.containsKey(nombreViejo) && this.alumnos.get(nombreViejo).remove(alumno))
            {
                if (this.alumnos.get(nombreViejo).isEmpty()) // El Tree ha quedado vacío
                    this.alumnos.remove(nombreViejo);
                
                alumno.setNombre(nombre);
                alumno.setApellido(apellido);
                nombreNuevo = nombre + apellido;
                
                if (this.alumnos.containsKey(nombreNuevo))
                    this.alumnos.get(nombreNuevo).add(alumno); // Agregamos al TreeSet el alumno
                else
                {
                    TreeSet<Alumno> tree = new TreeSet<Alumno>(); // Creamos una nueva cubeta y depositamos al alumno allí
                    tree.add(alumno);
                    this.alumnos.put(nombreNuevo, tree); 
                }
            }
            else
                throw new NoEstaEntidadException("Alumno no encontrado en el sistema.");
        }
        
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
            TreeSet<Profesor> tree = new TreeSet<Profesor>(); // Creamos una nueva cubeta y depositamos al profesor allí
            tree.add(profesor);
            this.profesores.put(nombreCompleto, tree); 
        }
    }
    
    public void bajaProfesor(Profesor profesor) throws NoEstaEntidadException // RF02
    {
        Iterator<TreeSet<Cursada>> itT;
        Iterator<Cursada> it;
        String nombreCompleto = profesor.getNombre() + profesor.getApellido();
        
        if (this.profesores.containsKey(nombreCompleto) && this.profesores.get(nombreCompleto).remove(profesor))
            // Si el profesor existe en la facultad y fue posible eliminarlo proseguimos a eliminarlo de todas las cursadas
        {
            if (this.profesores.get(nombreCompleto).isEmpty()) // El Tree ha quedado vacío, sin profesores
                this.profesores.remove(nombreCompleto);
            
            // Eliminamos al profesor de todas las cursadas inscripto
            itT = this.cursadas.values().iterator();
            // La sentencia anterior nos devuelve un iterator de TreeSet 
            while(itT.hasNext())
            {
                it = itT.next().iterator();
                while (it.hasNext())
                    it.next().getProfesores().remove(profesor.getLegajo()); // Se lo busca por legajo aquí
                    // El remove puede dar T o F, logre eliminarlo o no seguimos avanzando.
            }
        }
        else
            throw new NoEstaEntidadException("Profesor no encontrado en el sistema.");
    }
    
    public void modificaProfesor(Profesor profesor, String nombre, String apellido, String domicilio, String telefono, 
                                 String mail,HashMap<String, Asignatura> competencias)
                                 throws NoEstaEntidadException // RF03
    {   
        String nombreViejo;
        String nombreNuevo;
        
        if (!profesor.getNombre().equals(nombre) || !profesor.getApellido().equals(apellido))
        {
            nombreViejo = profesor.getNombre() + profesor.getApellido();
            
            if (this.profesores.containsKey(nombreViejo) && this.profesores.get(nombreViejo).remove(profesor))
            {
                if (this.profesores.get(nombreViejo).isEmpty()) // El Tree ha quedado vacío
                    this.profesores.remove(nombreViejo);
                
                profesor.setNombre(nombre);
                profesor.setApellido(apellido);
                nombreNuevo = nombre + apellido;
                
                if (this.profesores.containsKey(nombreNuevo))
                    this.profesores.get(nombreNuevo).add(profesor); // Agregamos al TreeSet el profesor
                else
                {
                    TreeSet<Profesor> tree = new TreeSet<Profesor>(); // Creamos una nueva cubeta y depositamos al 
                                                                      // profesor allí
                    tree.add(profesor);
                    this.profesores.put(nombreNuevo, tree); 
                }
            }
            else
                throw new NoEstaEntidadException("Profesor no encontrado en el sistema.");
        }
        
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
        {
            this.cursadas.get(cursada.getNombre()).remove(cursada);
            if (this.cursadas.get(cursada.getNombre()).isEmpty()) // Si hemos dejado al TreeSet sin cursadas eliminamos
                                                                  // también al Tree y a su clave del HashMap
                this.cursadas.remove(cursada.getNombre());
        }
        // Si esta última parte es correcta, ¿qué sucede cuando se elimina un profesor del sistema? ¿Se verifica que
        // la cursada no haya quedado sin profesores? Si es así, ¿se la elimina?
    }
    
    /*
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     */
    
    public void altaAsignatura(String nombre, HashMap<String, Asignatura> correlatividades) // RF01
    {
        Asignatura asignatura = Factory.getAsignatura(nombre, correlatividades);
        
        if (this.asignaturas.containsKey(nombre))
            this.asignaturas.get(nombre).add(asignatura); // Agregamos al TreeSet la asignatura
        else
        {
            TreeSet<Asignatura> tree = new TreeSet<Asignatura>(); // Creamos una nueva cubeta y depositamos a la 
                                                                  // asignatura allí
            tree.add(asignatura);
            this.asignaturas.put(nombre, tree); 
        }
    }
    
    public void bajaAsignatura(Asignatura asignatura) throws NoEstaEntidadException // RF02
    {
        Iterator<TreeSet<Cursada>> itT;
        Iterator<Cursada> it;
        Cursada cursada;
        
        if (this.asignaturas.containsKey(asignatura.getNombre()) && this.asignaturas.get(asignatura.getNombre()).remove(asignatura))
            // Si hemos encontrado la asignatura y podido eliminarla
        {   
            if (this.asignaturas.get(asignatura.getNombre()).isEmpty()) // Si el Tree de las asignaturas ha quedado vacío
                                                                        // lo eliminamos del HashMap
                this.asignaturas.remove(asignatura.getNombre());
            
            // Eliminamos todas las cursadas en las que la asignatura aparece
            itT = this.cursadas.values().iterator();
            while(itT.hasNext())
            {
                it = itT.next().iterator();
                while (it.hasNext())
                {
                    cursada = it.next();
                    if (cursada.getAsignatura().equals(asignatura))
                    {
                        this.cursadas.get(cursada.getNombre()).remove(cursada); // Eliminamos la cursada de su Tree
                        if (this.cursadas.get(cursada.getNombre()).isEmpty()) // Si el Tree queda vacío se lo debe
                                                                              // eliminar del HashMap
                            this.cursadas.remove(cursada.getNombre());
                    }
                }
            }
        }
        else
            throw new NoEstaEntidadException("Asignatura no encontrada en el sistema.");
    }
    
    public void modificaAsignatura(Asignatura asignatura, String nombre, HashMap<String, Asignatura> correlatividades)
        throws NoEstaEntidadException // RF03
    {           
        if (!asignatura.getNombre().equals(nombre))
        {            
            if (this.asignaturas.containsKey(asignatura.getNombre()) && this.asignaturas.get(asignatura.getNombre()).remove(asignatura))
            {
                if (this.asignaturas.get(asignatura.getNombre()).isEmpty()) // El Tree ha quedado vacío
                    this.asignaturas.remove(asignatura.getNombre());
                
                asignatura.setNombre(nombre);
                
                if (this.asignaturas.containsKey(nombre))
                    this.asignaturas.get(nombre).add(asignatura); // Agregamos al TreeSet la asignatura
                else
                {
                    TreeSet<Asignatura> tree = new TreeSet<Asignatura>(); // Creamos una nueva cubeta y depositamos a la
                                                                      // asignatura allí
                    tree.add(asignatura);
                    this.asignaturas.put(nombre, tree); 
                }
            }
            else
                throw new NoEstaEntidadException("Asignatura no encontrada en el sistema.");
        }
        
        asignatura.setCorrelatividades(correlatividades);
    }
    
    public TreeSet<Asignatura> ubicarAsignatura(String nombre) throws NoEstaEntidadException // RF05
    {
        TreeSet<Asignatura> ret = this.asignaturas.get(nombre);
        
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
                            String horaFin) // RF06
    {
        /**
         * El requisito de verificar que la cursada sea viable (RF17) no tiene sentido ya que podrían existir dos 
         * cursadas, incluso de la misma asignatura, en el mismo día y horario.
         */        
        Cursada cursada = Factory.getCursada(nombre, asignatura, periodo, dia, horaInicio, horaFin);
        
        if (this.cursadas.containsKey(nombre))
            this.cursadas.get(nombre).add(cursada); // Agregamos al TreeSet la cursada
        else
        {
            TreeSet<Cursada> tree = new TreeSet<Cursada>(); // Creamos una nueva cubeta y depositamos a la 
                                                            // cursada allí
            tree.add(cursada);
            this.cursadas.put(nombre, tree); 
        }
    }
    
    public void bajaCursada(Cursada cursada) throws NoEstaEntidadException // RF07
    {        
        if (this.cursadas.containsKey(cursada.getNombre()) && this.cursadas.get(cursada.getNombre()).remove(cursada))
            // Si hemos encontrado la cursada y podido eliminarla
            if (this.cursadas.get(cursada.getNombre()).isEmpty()) // Si el Tree de las cursadas ha quedado vacío
                                                                  // lo eliminamos del HashMap
                this.cursadas.remove(cursada.getNombre());
        else
            throw new NoEstaEntidadException("Cursada no encontrada en el sistema.");
    }
    
    public void modificaCursada(Cursada cursada, String nombre, Asignatura asignatura, String periodo, String dia, 
                                String horaInicio, String horaFin) throws NoEstaEntidadException //RF08
    {
        if (!cursada.getNombre().equals(nombre))
        {            
            if (this.cursadas.containsKey(cursada.getNombre()) && this.cursadas.get(cursada.getNombre()).remove(cursada))
            {
                if (this.cursadas.get(cursada.getNombre()).isEmpty()) // El Tree ha quedado vacío
                    this.cursadas.remove(cursada.getNombre());
                
                cursada.setNombre(nombre);
                
                if (this.cursadas.containsKey(nombre))
                    this.cursadas.get(nombre).add(cursada); // Agregamos al TreeSet la cursada
                else
                {
                    TreeSet<Cursada> tree = new TreeSet<Cursada>(); // Creamos una nueva cubeta y depositamos a la
                                                                    // cursada allí
                    tree.add(cursada);
                    this.cursadas.put(nombre, tree); 
                }
            }
            else
                throw new NoEstaEntidadException("Cursada no encontrada en el sistema.");
        }
        
        cursada.setAsignatura(asignatura);
        cursada.setPeriodo(periodo);
        cursada.setDia(dia);
        cursada.setHoraInicio(horaInicio);
        cursada.setHoraFin(horaFin);   
    }
    
    public TreeSet<Cursada> ubicarCursada(String nombre) throws NoEstaEntidadException // RF05
    {
        TreeSet<Cursada> ret = this.cursadas.get(nombre);
        
        if(ret == null)
            throw new NoEstaEntidadException("Cursada no ubicada.");
        
        return ret;
    }
    
    /*
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     * ***************************************************************************************************************
     */
    
    public boolean horariosSolapan(Cursada c1, Cursada c2)
    {
        return c1.getDia().equals(c2.getDia()) && ((c1.getHoraInicio().compareTo(c2.getHoraInicio()) >= 0 && 
                                                    c1.getHoraInicio().compareTo(c2.getHoraFin()) <= 0) || 
                                                   (c1.getHoraFin().compareTo(c2.getHoraInicio()) >= 0 && 
                                                    c1.getHoraFin().compareTo(c2.getHoraFin()) <= 0)); 
    }
    
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
        Iterator<TreeSet<Cursada>> itT;
        Iterator<Cursada> it;
        Cursada c;
        boolean sigue = true;
        
        itT = this.cursadas.values().iterator();
        while (itT.hasNext() && sigue)
        {
            it = itT.next().iterator();
            while(it.hasNext() && sigue)
            {
                c = it.next();
                if(c.getAlumnos().containsKey(alumno.getLegajo()))
                    sigue = !this.horariosSolapan(cursada, c);
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
                throw new EntidadNoAptaParaCursadaException("El profesor no está habilitado para dictar la cursada.");

    }
    public void verificaProfesorOcupado(Profesor profesor, Cursada cursada) throws EntidadNoAptaParaCursadaException
        // RF20
    {        
        Iterator<TreeSet<Cursada>> itT;
        Iterator<Cursada> it;
        Cursada c;
        boolean sigue = true;
        
        itT = this.cursadas.values().iterator();
        while (itT.hasNext() && sigue)
        {
            it = itT.next().iterator();
            while(it.hasNext() && sigue)
            {
                c = it.next();
                if(c.getProfesores().containsKey(profesor.getLegajo()))
                    sigue = !this.horariosSolapan(cursada, c);
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
