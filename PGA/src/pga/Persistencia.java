package pga;

import java.beans.XMLEncoder;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Persistencia
{
    Manager manager;
    
    public Persistencia()
    {
        super();
    }
    
    public void guardarArchivo(String nombreArchivo)
    {
        XMLEncoder encoder = null;
        try
        {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(nombreArchivo)));
        }
        catch(Exception e)
        {
            System.out.println("ERROR");
        }
        
        encoder.writeObject(this.alumnos);
        encoder.writeObject(this.profesores);
        encoder.writeObject(this.asignaturas);
        encoder.writeObject(this.cursadas);
    }
    
    public void leerArchivo(String nombreArchivo)
    {
        
    }
}
