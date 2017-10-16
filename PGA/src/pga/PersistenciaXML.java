package pga;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
        
        if(new File(SERIALIZED_FILE_NAME).isFile())
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
            ret = (Manager)decoder.readObject();
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
        encoder.writeObject(manager);
        encoder.close();
        
        /*encoder.writeObject(Alumno.getLegajoAlumno());
        encoder.writeObject(Profesor.getLegajoProfesor());
        encoder.writeObject(Asignatura.getNumAsignatura());
        encoder.writeObject(Cursada.getNumCursada());*/
    }
}
