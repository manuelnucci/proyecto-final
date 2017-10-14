package pga;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Principal
{
    Manager manager;
    
    public Principal()
    {
        super();
        this.leerArchivo("SistemaPGA.xml");
        this.guardarArchivo("SistemaPGA.xml");
    }
    
    public void leerArchivo(String nombreArchivo)
    {
        if(new File(nombreArchivo).isFile())
        {
            XMLDecoder decoder = null;
            try
            {
                decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(nombreArchivo)));
            }
            catch(Exception e)
            {
                System.out.println("ERROR");
            }
            
            this.manager = (Manager)decoder.readObject();
            decoder.close();
        }
        else
        {
            manager = Manager.getInstancia();
        }
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
        
        encoder.writeObject(this.manager);
        encoder.close();
        /*encoder.writeObject(Alumno.getLegajoAlumno());
        encoder.writeObject(Profesor.getLegajoProfesor());
        encoder.writeObject(Asignatura.getNumAsignatura());
        encoder.writeObject(Cursada.getNumCursada());*/
    }
}
