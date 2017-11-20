package pga;

import gui.VentanaPrincipal;

import java.io.FileNotFoundException;

/**
 * Clase lanzadora de la aplicación. Desde aquí se deserializa el archivo y se crean las clases que representarán
 * al modelo, la interfaz gráfica y el controlador o nexo entre ellas.
 */
public class Principal
{
    public Principal()
    {
        super();
    }

    /**
     * El el método main se crean las instancias de Manager, VentanaPrincipal y Controlador definiendo
     * quien conoce a quien, para luego delegar a estos objetos la posterior evolución de la ejecución.
     * 
     * @param args No se recibe ningún argumento como parámetro.
     */
    public static void main(String[] args)
    {
        Manager manager;
        try
        {
            manager = PersistenciaXML.leerArchivo();
            VentanaPrincipal v = new VentanaPrincipal();
            Controlador c = new Controlador(manager, v);
            v.setControlador(c);
        } catch (FileNotFoundException e)
        {
            System.out.println("Error al intentar leer el archivo.");
        }
    }
}
