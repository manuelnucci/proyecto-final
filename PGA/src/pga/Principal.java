package pga;

import gui.VentanaPrincipal;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Principal
{
    public Principal()
    {
        super();

    }
    
    public static void main(String[] args)
    {
        Principal p = new Principal();


        Manager manager = PersistenciaXML.leerArchivo();
        VentanaPrincipal v = new VentanaPrincipal();
        System.out.println("paso");
        Controlador c = new Controlador(manager, v);
        v.setControlador(c);
        manager.altaAlumno("Sebastian", "Canonaco", "Guanajjani5645", "4823342", "sebas@aaaaaa", null);
        manager.altaAlumno("Manuel", "Nucci", "ssGuanajjani5645", "4823342", "sebas@aaaaaa", null);
        manager.altaAlumno("Sebastian", "Cco", "Guanajjani5645", "4823342", "sebas@aaaaaa", null);
    }
}
