package pga;

import gui.VentanaPrincipal;

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
        Controlador c = new Controlador(manager, v);
        v.setControlador(c);
        manager.altaAlumno("Sebastian", "Canonaco", "Guanajjani5645", "4823342", "sebas@aaaaaa");
        manager.altaAlumno("Manuel", "Nucci", "ssGuanajjani5645", "4823342", "sebas@aaaaaa");
        manager.altaAlumno("Sebastian", "Cco", "Guanajjani5645", "4823342", "sebas@aaaaaa");
    }
}
