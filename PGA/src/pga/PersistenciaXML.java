package pga;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.HashMap;

public class PersistenciaXML
{
    private static final String SERIALIZED_FILE_NAME = "SistemaPGA.xml";
    
    public PersistenciaXML()
    {
        super();
    }
    
    public static Manager leerArchivo()
    {
        Manager ret;
        
        if (new File(SERIALIZED_FILE_NAME).exists())
        {
            XMLDecoder decoder = null;
            try
            {
                decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
            }
            catch(Exception e)
            {
                System.out.println("Error al intentar leer el archivo.");
            }
            ret = Manager.getInstancia(); // Creamos un Manager y luego le seteamos sus colecciones 
            ret.setAlumnos((HashMap<String, HashMap<String, Alumno>>)decoder.readObject());
            ret.setProfesores((HashMap<String, HashMap<String, Profesor>>)decoder.readObject());
            ret.setAsignaturas((HashMap<String, HashMap<String, Asignatura>>)decoder.readObject());
            ret.setCursadas((HashMap<String, HashMap<String, Cursada>>)decoder.readObject());
            Alumno.setLegajoAlumno((Integer) decoder.readObject());
            Profesor.setLegajoProfesor((Integer) decoder.readObject());
            Asignatura.setNumAsignatura((Integer) decoder.readObject());
            Cursada.setNumCursada((Integer) decoder.readObject());
            decoder.close();
        }
        else // Si el archivo no existe es por ser la primer corrida del sistema. Se debe por lo tanto crear un Manager
        {
            ret = Manager.getInstancia();
        }
        return ret;
    }
    
    public static void guardarArchivo(Manager manager)
    {
        XMLEncoder encoder = null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
        }
        catch(Exception e)
        {
            System.out.println("Error al intentar guardar el archivo.");
        }
        encoder.writeObject(manager.getAlumnos());
        encoder.writeObject(manager.getProfesores());
        encoder.writeObject(manager.getAsignaturas());
        encoder.writeObject(manager.getCursadas());
        encoder.writeObject(Alumno.getLegajoAlumno());
        encoder.writeObject(Profesor.getLegajoProfesor());
        encoder.writeObject(Asignatura.getNumAsignatura());
        encoder.writeObject(Cursada.getNumCursada());
        encoder.close();
    }
}
