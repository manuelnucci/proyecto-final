package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import pga.Controlador;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    private JMenuBar menuBar;
    private JMenu menuAlumno, menuProfesor, menuAsignatura, menuCursada;
    private JMenuItem miAlumnoAlta , miAlumnoBaja, miAlumnoModificacion, miAlumnoConsulta, miAlumnoAltaCursada, miAlumnoBajaCursada, miModificarHistoria;
    private JMenuItem miProfesorAlta , miProfesorBaja, miProfesorModificacion, miProfesorConsulta, miProfesorAltaCursada, miProfesorBajaCursada, miModificarCompetencias;
    private JMenuItem miAsignaturaAlta , miAsignaturaBaja, miAsignaturaModificacion, miAsignaturaConsulta, miModificarCorrelativas;
    private JMenuItem miCursadaAlta , miCursadaBaja, miCursadaModificacion, miCursadaConsulta;
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Controlador controlador;
    
    public VentanaPrincipal()
    {
        super();
        this.setTitle("PGA");
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(600,400));
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
        this.setResizable(false);
        this.initComponents();
        this.addListeners();
        this.setVisible(true);
    }

    public void initComponents()
    {
        // Crea menú y sus opciones
        this.menuBar = new JMenuBar();
        this.menuAlumno = new JMenu("Alumnos");
        this.menuProfesor = new JMenu("Profesores");
        this.menuAsignatura = new JMenu("Asignaturas");
        this.menuCursada = new JMenu("Cursadas");
        // Añade las opciones al menú
        this.menuBar.add(this.menuAlumno);
        this.menuBar.add(this.menuProfesor);
        this.menuBar.add(this.menuAsignatura);
        this.menuBar.add(this.menuCursada);
        // Crea las subopciones/ítems de cada entidad
        this.miAlumnoAlta = new JMenuItem("Alta");
        this.miAlumnoBaja = new JMenuItem("Baja");
        this.miAlumnoModificacion = new JMenuItem("Modificación");
        this.miAlumnoConsulta = new JMenuItem("Consulta");
        this.miAlumnoAltaCursada = new JMenuItem("Alta cursada");
        this.miAlumnoBajaCursada = new JMenuItem("Baja cursada");
        this.miModificarHistoria = new JMenuItem("Modificar Historia");
        this.miProfesorAlta = new JMenuItem("Alta");
        this.miProfesorBaja = new JMenuItem("Baja");
        this.miProfesorModificacion = new JMenuItem("Modificación");
        this.miProfesorConsulta = new JMenuItem("Consulta");
        this.miProfesorAltaCursada = new JMenuItem("Alta cursada");
        this.miProfesorBajaCursada = new JMenuItem("Baja cursada");
        this.miModificarCompetencias = new JMenuItem("Modificar Competencias");
        this.miAsignaturaAlta = new JMenuItem("Alta");
        this.miAsignaturaBaja = new JMenuItem("Baja");
        this.miAsignaturaModificacion = new JMenuItem("Modificación");
        this.miAsignaturaConsulta = new JMenuItem("Consulta");
        this.miModificarCorrelativas = new JMenuItem("Modificar Correlativas");
        this.miCursadaAlta = new JMenuItem("Alta");
        this.miCursadaBaja = new JMenuItem("Baja");
        this.miCursadaModificacion = new JMenuItem("Modificación");
        this.miCursadaConsulta = new JMenuItem("Consulta");
        // Añade las subopciones en cada menú
        this.menuAlumno.add(this.miAlumnoAlta);
        this.menuAlumno.add(this.miAlumnoBaja);
        this.menuAlumno.add(this.miAlumnoModificacion);
        this.menuAlumno.add(this.miAlumnoConsulta);
        this.menuAlumno.add(this.miAlumnoAltaCursada);
        this.menuAlumno.add(this.miAlumnoBajaCursada);
        this.menuAlumno.add(this.miModificarHistoria);
        this.menuProfesor.add(this.miProfesorAlta);
        this.menuProfesor.add(this.miProfesorBaja);
        this.menuProfesor.add(this.miProfesorModificacion);
        this.menuProfesor.add(this.miProfesorConsulta);
        this.menuProfesor.add(this.miProfesorAltaCursada);
        this.menuProfesor.add(this.miProfesorBajaCursada);
        this.menuProfesor.add(this.miModificarCompetencias);
        this.menuAsignatura.add(this.miAsignaturaAlta);
        this.menuAsignatura.add(this.miAsignaturaBaja);
        this.menuAsignatura.add(this.miAsignaturaModificacion);
        this.menuAsignatura.add(this.miAsignaturaConsulta);
        this.menuAsignatura.add(this.miModificarCorrelativas);
        this.menuCursada.add(this.miCursadaAlta);
        this.menuCursada.add(this.miCursadaBaja);
        this.menuCursada.add(this.miCursadaModificacion);
        this.menuCursada.add(this.miCursadaConsulta);
        //Setea el menú al JFrame VentanaPrincipal
        this.setJMenuBar(this.menuBar);
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
    
    public void setControlador(Controlador controlador)
    {
        this.controlador = controlador;
    }
    
    private void close()
    {
        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del sistema?",
                "Salir del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            this.controlador.guardarArchivo();
            System.exit(0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.miAlumnoAlta)
            new AlumnoAlta(this.controlador);
        else 
            if(e.getSource() == this.miAlumnoBaja)
                new AlumnoBaja(this.controlador);
            else 
                if(e.getSource() == this.miAlumnoModificacion)
                    new AlumnoModificar(this.controlador);
                else 
                    if(e.getSource() == this.miAlumnoConsulta)
                        new AlumnoConsulta(this.controlador, this, true);
                    else 
                        if(e.getSource() == this.miAlumnoAltaCursada)
                            new AlumnoAltaACursada(this.controlador);
                        else 
                            if(e.getSource() == this.miAlumnoBajaCursada)
                                new AlumnoBajaACursada(this.controlador);
                            else 
                                if(e.getSource() == this.miModificarHistoria)
                                    new ModificaHistoriaAlumno(this.controlador);
                                else
                                    if(e.getSource() == this.miProfesorAlta)
                                        new ProfesorAlta(this.controlador);
                                    else 
                                        if(e.getSource() == this.miProfesorBaja)
                                            new ProfesorBaja(this.controlador);
                                        else 
                                            if(e.getSource() == this.miProfesorConsulta)
                                                new ProfesorConsulta(this.controlador);
                                            else 
                                                if(e.getSource() == this.miProfesorModificacion)
                                                    new ProfesorModificacion(this.controlador);
                                                else 
                                                    if(e.getSource() == this.miProfesorAltaCursada)
                                                        new ProfesorAltaACursada(this.controlador);
                                                    else 
                                                        if(e.getSource() == this.miProfesorBajaCursada)
                                                            new ProfesorBajaACursada(this.controlador);
                                                        else 
                                                            if(e.getSource() == this.miModificarCompetencias)
                                                                new ProfesorModificaCompetencias(this.controlador);
                                                            else 
                                                                if(e.getSource() == this.miAsignaturaAlta)
                                                                    new AsignaturaAlta(this.controlador);
                                                                else 
                                                                    if(e.getSource() == this.miAsignaturaBaja)
                                                                        new AsignaturaBaja(this.controlador);
                                                                    else 
                                                                        if(e.getSource() == this.miAsignaturaConsulta)
                                                                            new AsignaturaConsulta(this.controlador);
                                                                        else 
                                                                            if(e.getSource() == this.miAsignaturaModificacion)
                                                                                new AsignaturaModificacion(this.controlador);
                                                                            else 
                                                                                if(e.getSource() == this.miModificarCorrelativas)
                                                                                    new AsignaturaModificarCorrelativas(this.controlador);
                                                                                else 
                                                                                    if(e.getSource() == this.miCursadaAlta)
                                                                                        new CursadaAlta(this.controlador);
                                                                                    else 
                                                                                        if(e.getSource() == this.miCursadaBaja)
                                                                                            new CursadaBaja(this.controlador);
                                                                                        else 
                                                                                            if(e.getSource() == this.miCursadaConsulta)
                                                                                                new CursadaConsulta(this.controlador);
                                                                                            else
                                                                                                 new CursadaModificacion(this.controlador);
    }
}
