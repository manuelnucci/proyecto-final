package pga;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.HashMap;

/**
 * Clase encargada de la persistencia del sistema entre sesiones del mismo.
 * Todos los datos del sistema son almacenados en un archivo XML (estándar internacional).}
 * Se declara final a la clase para evitar la instanciación de la misma.
 */
public final class PersistenciaXML
{
    private static final String SERIALIZED_FILE_NAME = "SistemaPGA.xml"; // Nombre del archivo XML
    
    /**
     * Constructor de la clase. Se lo declara privado para evitar la instanciación de la clase.
     */
    private PersistenciaXML()
    {
        super();
    }

    /**
     * Método que se especializa en la lectura del archivo y posterior inicialización de las clases del sistema.
     * Si el archivo no existe por ser la primer corrida del sistema se lo crea y se da inicio al sistema normalmente.<br>
     *
     * <b>Pre:</b> No cuenta con precondiciones este método.<br>
     * <b>Post:</b> En el caso que el archivo exista se setean una a una las colecciones de la clase Manager que
     * engloba todo el funcionamiento del sistema así como también las variables estáticas de las clases Alumno,
     * Asignatura, Cursada y Profesor. Posteriormente se devuelve una instancia de Manager.
     * Si el archivo no existiese se crea una nueva instancia de Manager y se la retorna comenzando el sistema desde
     * cero.
     * En el caso que el archivo exista pero no se tengan permisos de lectura se lanzará una excepción notificando
     * esto.
     *
     * @return Instancia de la clase Manager.
     * @throws FileNotFoundException Excepción lanzada si el archivo no puede leerse.
     */
    public static Manager leerArchivo() throws FileNotFoundException
    {
        Manager ret;
        
        if (new File(SERIALIZED_FILE_NAME).exists())
        {            
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
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
            ret = Manager.getInstancia();
        return ret;   
    }

    /**
     * Método encargado de guardar el estado del sistema cuando el usuario decide cerrar la aplicación.<br>
     *
     * <b>Pre:</b> El parámetro manager no es nulo.<br>
     * <b>Post:</b> Se crea o actualiza (dependiendo si existía o no) un achivo XML que almacena todo el estado del
     * sistema. Si el archivo no es de escritura se lanza una excepción notificando esta situación.
     *
     * @param manager Manager del modelo. Manager != null.
     * @throws FileNotFoundException Excepción lanzada en el caso que el archivo no sea de escritura.
     */
    public static void guardarArchivo(Manager manager) throws FileNotFoundException
    {
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(SERIALIZED_FILE_NAME)));
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
