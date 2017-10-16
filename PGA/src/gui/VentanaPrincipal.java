package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    private JPanel panelPrincipal;
    private JMenuBar menuBar;
    private JMenu menuAlumno, menuProfesor, menuAsignatura, menuCursada;
    private JMenuItem miAlumnoAlta , miAlumnoBaja, miAlumnoModificacion, miAlumnoConsulta;
    private JMenuItem miProfesorAlta , miProfesorBaja, miProfesorModificacion, miProfesorConsulta;
    private JMenuItem miAsignaturaAlta , miAsignaturaBaja, miAsignaturaModificacion, miAsignaturaConsulta;
    private JMenuItem miCursadaAlta , miCursadaBaja, miCursadaModificacion, miCursadaConsulta;
    
    public VentanaPrincipal()
    {
        super();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PGA");
        this.setSize(new Dimension(750,550));
        this.initComponents();
        this.addListeners();
    }

    public void initComponents()
    {
        //Crea menu y sus opciones
        this.menuBar = new JMenuBar();
        this.menuAlumno = new JMenu("Alumnos");
        this.menuProfesor = new JMenu("Profesores");
        this.menuAsignatura = new JMenu("Asignaturas");
        this.menuCursada = new JMenu("Cursadas");
        //Anade las opciones al menu
        this.menuBar.add(menuAlumno);
        this.menuBar.add(menuProfesor);
        this.menuBar.add(menuAsignatura);
        this.menuBar.add(menuCursada);
        //Crea las subopciones/items de cada entidad
        this.miAlumnoAlta = new JMenuItem("Alta");
        this.miAlumnoBaja = new JMenuItem("Baja");
        this.miAlumnoModificacion = new JMenuItem("Modificacion");
        this.miAlumnoConsulta = new JMenuItem("Consulta");
        this.miProfesorAlta = new JMenuItem("Alta");
        this.miProfesorBaja = new JMenuItem("Baja");
        this.miProfesorModificacion = new JMenuItem("Modificacion");
        this.miProfesorConsulta = new JMenuItem("Consulta");
        this.miAsignaturaAlta = new JMenuItem("Alta");
        this.miAsignaturaBaja = new JMenuItem("Baja");
        this.miAsignaturaModificacion = new JMenuItem("Modificacion");
        this.miAsignaturaConsulta = new JMenuItem("Consulta");
        this.miCursadaAlta = new JMenuItem("Alta");
        this.miCursadaBaja = new JMenuItem("Baja");
        this.miCursadaModificacion = new JMenuItem("Modificacion");
        this.miCursadaConsulta = new JMenuItem("Consulta");
        //Anade las subopciones en cada menu
        this.menuAlumno.add(miAlumnoAlta);
        this.menuAlumno.add(miAlumnoBaja);
        this.menuAlumno.add(miAlumnoModificacion);
        this.menuAlumno.add(miAlumnoConsulta);
        this.menuProfesor.add(miProfesorAlta);
        this.menuProfesor.add(miProfesorBaja);
        this.menuProfesor.add(miProfesorModificacion);
        this.menuProfesor.add(miProfesorConsulta);
        this.menuAsignatura.add(miAsignaturaAlta);
        this.menuAsignatura.add(miAsignaturaBaja);
        this.menuAsignatura.add(miAsignaturaModificacion);
        this.menuAsignatura.add(miAsignaturaConsulta);
        this.menuCursada.add(miCursadaAlta);
        this.menuCursada.add(miCursadaBaja);
        this.menuCursada.add(miCursadaModificacion);
        this.menuCursada.add(miCursadaConsulta);
        //Setea el menu al JFrame VentanaPrincipal
        this.setJMenuBar(menuBar);
    }
    
    public void addListeners()
    {
        this.miAlumnoAlta.addActionListener(this);
        this.miAlumnoBaja.addActionListener(this);
        this.miAlumnoModificacion.addActionListener(this);
        this.miAlumnoConsulta.addActionListener(this);
        this.miProfesorAlta.addActionListener(this);
        this.miProfesorBaja.addActionListener(this);
        this.miProfesorModificacion.addActionListener(this);
        this.miProfesorConsulta.addActionListener(this);
        this.miAsignaturaAlta.addActionListener(this);
        this.miAsignaturaBaja.addActionListener(this);
        this.miAsignaturaModificacion.addActionListener(this);
        this.miAsignaturaConsulta.addActionListener(this);
        this.miCursadaAlta.addActionListener(this);
        this.miCursadaBaja.addActionListener(this);
        this.miCursadaModificacion.addActionListener(this);
        this.miCursadaConsulta.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.miAlumnoAlta)
        {
            System.out.println("AlumnoAlta");
            AlumnoAlta a = new AlumnoAlta();
        }
        if(e.getSource() == this.miAlumnoConsulta)
            System.out.println("AlumnoConsulta");
        if(e.getSource() == this.miProfesorBaja)
            System.out.println("ProfesorBaja");
        if(e.getSource() == this.miCursadaModificacion)
            System.out.println("CursadaModificacion");
    }
    
    public static void main(String[] args)
    {
        VentanaPrincipal v = new VentanaPrincipal();
        v.setVisible(true);
    }
}
