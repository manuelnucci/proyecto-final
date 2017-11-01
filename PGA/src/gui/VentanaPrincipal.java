package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pga.Controlador;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    private JPanel panelPrincipal;
    private JMenuBar menuBar;
    private JMenu menuAlumno, menuProfesor, menuAsignatura, menuCursada;
    private JMenuItem miAlumnoAlta , miAlumnoBaja, miAlumnoModificacion, miAlumnoConsulta, miAlumnoAltaCursada, miAlumnoBajaCursada, miModificarHistoria;
    private JMenuItem miProfesorAlta , miProfesorBaja, miProfesorModificacion, miProfesorConsulta, miProfesorAltaCursada, miProfesorBajaCursada, miModificarCompetencias;
    private JMenuItem miAsignaturaAlta , miAsignaturaBaja, miAsignaturaModificacion, miAsignaturaConsulta, miModificarCorrelativas;
    private JMenuItem miCursadaAlta , miCursadaBaja, miCursadaModificacion, miCursadaConsulta;
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Controlador c;
    
    public VentanaPrincipal()
    {
        super();
        
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
         
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });       
        
        this.setLayout(new BorderLayout());
        this.setTitle("PGA");
        this.initComponents();
        this.addListeners();
        this.setSize(new Dimension(750,550));
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void initComponents()
    {
        //Crea menu y sus opciones
        this.menuBar = new JMenuBar();
        this.menuAlumno = new JMenu("Alumnos");
        this.menuProfesor = new JMenu("Profesores");
        this.menuAsignatura = new JMenu("Asignaturas");
        this.menuCursada = new JMenu("Cursadas");
        //Añade las opciones al menu
        this.menuBar.add(menuAlumno);
        this.menuBar.add(menuProfesor);
        this.menuBar.add(menuAsignatura);
        this.menuBar.add(menuCursada);
        //Crea las subopciones/items de cada entidad
        this.miAlumnoAlta = new JMenuItem("Alta");
        this.miAlumnoBaja = new JMenuItem("Baja");
        this.miAlumnoModificacion = new JMenuItem("Modificacion");
        this.miAlumnoConsulta = new JMenuItem("Consulta");
        this.miAlumnoAltaCursada = new JMenuItem("Alta cursada");
        this.miAlumnoBajaCursada = new JMenuItem("Baja cursada");
        this.miModificarHistoria = new JMenuItem("Modificar Historia");
        this.miProfesorAlta = new JMenuItem("Alta");
        this.miProfesorBaja = new JMenuItem("Baja");
        this.miProfesorModificacion = new JMenuItem("Modificacion");
        this.miProfesorConsulta = new JMenuItem("Consulta");
        this.miProfesorAltaCursada = new JMenuItem("Alta cursada");
        this.miProfesorBajaCursada = new JMenuItem("Baja cursada");
        this.miModificarCompetencias = new JMenuItem("Modificar Competencias");
        this.miAsignaturaAlta = new JMenuItem("Alta");
        this.miAsignaturaBaja = new JMenuItem("Baja");
        this.miAsignaturaModificacion = new JMenuItem("Modificacion");
        this.miAsignaturaConsulta = new JMenuItem("Consulta");
        this.miModificarCorrelativas = new JMenuItem("Modificar Correlativas");
        this.miCursadaAlta = new JMenuItem("Alta");
        this.miCursadaBaja = new JMenuItem("Baja");
        this.miCursadaModificacion = new JMenuItem("Modificacion");
        this.miCursadaConsulta = new JMenuItem("Consulta");
        //Anade las subopciones en cada menu
        this.menuAlumno.add(miAlumnoAlta);
        this.menuAlumno.add(miAlumnoBaja);
        this.menuAlumno.add(miAlumnoModificacion);
        this.menuAlumno.add(miAlumnoConsulta);
        this.menuAlumno.add(miAlumnoAltaCursada);
        this.menuAlumno.add(miAlumnoBajaCursada);
        this.menuAlumno.add(this.miModificarHistoria);
        this.menuProfesor.add(miProfesorAlta);
        this.menuProfesor.add(miProfesorBaja);
        this.menuProfesor.add(miProfesorModificacion);
        this.menuProfesor.add(miProfesorConsulta);
        this.menuProfesor.add(this.miProfesorAltaCursada);
        this.menuProfesor.add(this.miProfesorBajaCursada);
        this.menuProfesor.add(this.miModificarCompetencias);
        this.menuAsignatura.add(miAsignaturaAlta);
        this.menuAsignatura.add(miAsignaturaBaja);
        this.menuAsignatura.add(miAsignaturaModificacion);
        this.menuAsignatura.add(miAsignaturaConsulta);
        this.menuAsignatura.add(miModificarCorrelativas);
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
        this.miAlumnoAltaCursada.addActionListener(this);
        this.miAlumnoBajaCursada.addActionListener(this);
        this.miModificarHistoria.addActionListener(this);
        this.miProfesorAlta.addActionListener(this);
        this.miProfesorBaja.addActionListener(this);
        this.miProfesorModificacion.addActionListener(this);
        this.miProfesorConsulta.addActionListener(this);
        this.miProfesorAltaCursada.addActionListener(this);
        this.miProfesorBajaCursada.addActionListener(this);
        this.miModificarCompetencias.addActionListener(this);
        this.miAsignaturaAlta.addActionListener(this);
        this.miAsignaturaBaja.addActionListener(this);
        this.miAsignaturaModificacion.addActionListener(this);
        this.miAsignaturaConsulta.addActionListener(this);
        this.miModificarCorrelativas.addActionListener(this);
        this.miCursadaAlta.addActionListener(this);
        this.miCursadaBaja.addActionListener(this);
        this.miCursadaModificacion.addActionListener(this);
        this.miCursadaConsulta.addActionListener(this);
        
    }
    
    public void setControlador(Controlador c)
    {
        this.c = c;
    }
    
    private void close()
    {
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            this.c.guardarArchivo();
            System.exit(0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.miAlumnoAlta)
        {
            System.out.println("AlumnoAlta");
            AlumnoAlta aA = new AlumnoAlta(this.c, true);
        }
        if(e.getSource() == this.miAlumnoBaja)
        {
            AlumnoBaja aB = new AlumnoBaja();
        }
        if(e.getSource() == this.miAlumnoModificacion)
        {
            AlumnoModificar aM = new AlumnoModificar(this.c);
        }
        if(e.getSource() == this.miAlumnoConsulta)
        {
            new AlumnoConsulta();
        }
        if(e.getSource() == this.miAlumnoAltaCursada)
        {
            new AlumnoAltaACursada();
        }
        if(e.getSource() == this.miAlumnoBajaCursada)
        {
            new AlumnoBajaACursada();
        }
        if(e.getSource() == this.miModificarHistoria)
        {
            new ModificaHistoriaAlumno();
        }
        if(e.getSource() == this.miProfesorAlta)
        {
            ProfesorAlta pA = new ProfesorAlta();
        }
        if(e.getSource() == this.miProfesorBaja)
        {
            new ProfesorBaja();
        }
        if(e.getSource() == this.miProfesorConsulta)
        {
            new ProfesorConsulta();
        }
        if(e.getSource() == this.miProfesorModificacion)
        {
            new ProfesorModificacion(this.c);
        }
        if(e.getSource() == this.miProfesorAltaCursada)
        {
            new ProfesorAltaACursada();
        }
        if(e.getSource() == this.miProfesorBajaCursada)
        {
            new ProfesorBajaACursada();
        }
        if(e.getSource() == this.miModificarCompetencias)
        {
            new ProfesorModificaCompetencias();
        }
        if(e.getSource() == this.miAsignaturaAlta)
        {
            new AsignaturaAlta(this.c);
        }
        if(e.getSource() == this.miAsignaturaBaja)
        {
            new AsignaturaBaja();
        }
        if(e.getSource() == this.miAsignaturaConsulta)
        {
            new AsignaturaConsulta();
        }
        if(e.getSource() == this.miAsignaturaModificacion)
        {
            new AsignaturaModificacion(this.c);
        }
        if(e.getSource() == this.miModificarCorrelativas)
        {
            new AsignaturaModificarCorrelativas();
        }
        if(e.getSource() == this.miCursadaAlta)
        {
            new CursadaAlta();
        } 
        if(e.getSource() == this.miCursadaBaja)
        {
             new CursadaBaja2();
        } 
        if(e.getSource() == this.miCursadaConsulta)
        {
            new CursadaConsulta();
        }
        if(e.getSource() == this.miCursadaModificacion)
        {
             new CursadaModificacion();
        } 
    }
}
