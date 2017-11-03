package gui;

import exceptions.EntidadRepetidaException;
import exceptions.NoEstaEntidadException;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pga.Alumno;
import pga.Asignatura;
import pga.Controlador;

public class AsignaturaModificarCorrelativas extends JFrame implements ActionListener
{
    private static final String ELEGIR = "0";
    private static final String ANADIR = "1";
    private static final String REMOVER = "2";
    private static final String BUSCAR = "3";
    private static final String CANCELAR = "4";
    private static final String GUARDAR = "5";
    private static final String BUSCAR2 = "6";
    
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Controlador controlador;
    private JScrollPane scrollPanel, scrollPanelC1, scrollPanelC2;
    private JList jListA, jListC1, jListC2;
    private DefaultListModel listModel, listModelC1, listModelC2;
    private JPanel panelA, panelB;
    private JTextField jTextFieldNombreAsignatura1, jTextFieldNombreAsignatura2;
    private JLabel jLabelNombre, jLabelAsigTotales, jLabelAsigHistoria;
    private JButton jButtonGuardar, jButtonCancelar, jButtonAnadir, jButtonRemover, jButtonElegir, jButtonBuscar, jButtonBuscar2;
    private Asignatura asignatura;
    
    public AsignaturaModificarCorrelativas(Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.initComponentsA();
        this.initComponentsB();
        this.add(this.panelA, BorderLayout.NORTH);
        this.add(this.panelB, BorderLayout.SOUTH);
        this.deshabilitarPanel(this.panelB);
        this.pack();
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
        this.setVisible(true);
    }
    
    public void initComponentsA()
    {
        GridBagConstraints c = new GridBagConstraints();
        
        this.panelA = new JPanel(new GridBagLayout());
        
        this.listModel = new DefaultListModel();
        this.listModelC1 = new DefaultListModel();
        this.listModelC2 = new DefaultListModel();
        this.jListA = new JList(this.listModel);
        this.jListC1 = new JList(this.listModelC1);
        this.jListC2 = new JList(this.listModelC2);
        this.scrollPanel = new JScrollPane(this.jListA);
        this.scrollPanelC1 = new JScrollPane(this.jListC1);
        this.scrollPanelC2 = new JScrollPane(this.jListC2);
        this.jLabelNombre = new JLabel("Nombre");
        this.jTextFieldNombreAsignatura1 = new JTextField();
        this.jTextFieldNombreAsignatura2 = new JTextField();
        this.jLabelAsigTotales = new JLabel("Asignaturas encontradas");
        this.jLabelAsigHistoria = new JLabel("Correlativas");
        this.jButtonBuscar = new JButton("Buscar");
        this.jButtonElegir = new JButton("Elegir");
        this.jButtonBuscar2 = new JButton("Buscar");
        this.jButtonAnadir = new JButton("Anadir >>");
        this.jButtonRemover = new JButton("Remover <<");
        this.jButtonGuardar = new JButton("Guardar");
        this.jButtonCancelar = new JButton("Cancelar");
        
        this.jButtonBuscar.setActionCommand(BUSCAR);
        this.jButtonBuscar2.setActionCommand(BUSCAR2);
        this.jButtonElegir.setActionCommand(ELEGIR);
        this.jButtonAnadir.setActionCommand(ANADIR);
        this.jButtonRemover.setActionCommand(REMOVER);
        this.jButtonGuardar.setActionCommand(GUARDAR);
        this.jButtonCancelar.setActionCommand(CANCELAR);
        
        this.jButtonBuscar.addActionListener(this);
        this.jButtonBuscar2.addActionListener(this);
        this.jButtonAnadir.addActionListener(this);
        this.jButtonElegir.addActionListener(this);
        this.jButtonRemover.addActionListener(this);
        this.jButtonGuardar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jLabelNombre, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 2;
        this.panelA.add(this.jTextFieldNombreAsignatura1, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 2;
        this.panelA.add(this.jButtonBuscar, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        c.gridheight = 3; 
        c.gridwidth = 3;
        this.panelA.add(this.scrollPanel, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jButtonElegir, c);
        
        for(int i = 6; i < 9; i++)
        {
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i;
            c.gridheight = 1; 
            c.gridwidth = 1;
            this.panelA.add(new JLabel(" "), c);
        }
    }
    
    public void initComponentsB()
    {
        GridBagConstraints c = new GridBagConstraints();
        
        this.panelB = new JPanel(new GridBagLayout());
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jTextFieldNombreAsignatura2, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jButtonBuscar2, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jLabelAsigTotales, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jLabelAsigHistoria, c);
                
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 2; 
        c.gridwidth = 2;
        this.panelB.add(this.scrollPanelC1, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jButtonAnadir, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jButtonRemover, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 2; 
        c.gridwidth = 2;
        this.panelB.add(this.scrollPanelC2, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jButtonGuardar, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jButtonCancelar, c);
    }

    public void deshabilitarPanel(JPanel panel)
    {
        Component[] componentes = panel.getComponents();
        
        for(int i = 0; i < componentes.length; i++)
            componentes[i].setEnabled(false);
    }
    
    public void habilitarPanel(JPanel panel)
    {
        Component[] componentes = panel.getComponents();
        
        for(int i = 0; i < componentes.length; i++)
            componentes[i].setEnabled(true);
    }

    public boolean camposVacios()
    {
        return !(this.jTextFieldNombreAsignatura1.getText().length() != 0 || this.jTextFieldNombreAsignatura2.getText().length() != 0);
    }
    
    public void listarA(HashMap<String, Asignatura> hash)
    {
        Iterator <Asignatura> iA = hash.values().iterator();
        
        this.listModel.clear();
        while(iA.hasNext())
            this.listModel.addElement(iA.next());
    }
    
    public void listarC1(HashMap<String, Asignatura> hash)
    {
        Iterator <Asignatura> iA = hash.values().iterator();
        
        this.listModelC1.clear();
        while(iA.hasNext())
            this.listModelC1.addElement(iA.next());
    }
    
    public void listarC2(HashMap<String, Asignatura> hash)
    {
        Iterator <Asignatura> iA = hash.values().iterator();
        
        this.listModelC2.clear();
        while(iA.hasNext())
            this.listModelC2.addElement(iA.next());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand())
        {
            case BUSCAR:    if (this.camposVacios()) 
                                JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                            else
                                try
                                {
                                    this.deshabilitarPanel(this.panelB);
                                    this.listarA(controlador.ubicarAsignatura(this.jTextFieldNombreAsignatura1.getText()));
                                } catch (NoEstaEntidadException e)
                                {
                                    JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                                }
                            break;
        
            case ELEGIR:    if (this.camposVacios())
                                JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                            else
                                if (this.jListA.getSelectedValue() != null)
                                {
                                    this.habilitarPanel(panelB);
                                    int index = this.jListA.getSelectedIndex();
                                    this.asignatura = (Asignatura) this.listModel.getElementAt(index);
                                    this.listarC2(this.asignatura.getCorrelatividades());
                                }
                                else
                                    JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista", "Error de Consulta", JOptionPane.WARNING_MESSAGE);
                            break;
        
            case BUSCAR2:   if (this.camposVacios()) 
                                JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                            else
                                try
                                {
                                    this.listarC1(controlador.ubicarAsignatura(this.jTextFieldNombreAsignatura2.getText()));
                                } catch (NoEstaEntidadException e)
                                {
                                    JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                                }
                            break;
            
            case ANADIR:    if (this.jListC1.getSelectedValue() != null)
                            {
                                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea anadir la asignatura a la historia?", "Modificar Historia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                {
                                    int index = this.jListC1.getSelectedIndex();
                                    Asignatura asignatura2 = (Asignatura) this.listModelC1.getElementAt(index);
                                    try
                                    {
                                        this.controlador.agregarCorrelativa(this.asignatura, asignatura2);
                                        this.listarA(this.asignatura.getCorrelatividades());
                                        JOptionPane.showMessageDialog(rootPane, "Asignatura anadida a las correlativas exitosamente");
                                    } catch (EntidadRepetidaException e)
                                    {
                                        JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Modificacion de Correlativas", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                            else
                                JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista", "Error de Modificacion de Historia", JOptionPane.WARNING_MESSAGE);     
                            break;
        
            case REMOVER:   if (this.jListC2.getSelectedValue() != null)
                            {
                                if (JOptionPane.showConfirmDialog(rootPane, "¿Desea remover la asignatura de la historia?", "Modificar Historia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                {
                                    int index = this.jListC2.getSelectedIndex();
                                    Asignatura asignatura2 = (Asignatura) this.listModelC2.getElementAt(index);
                                    try
                                    {
                                        this.controlador.bajaCorrelativa(this.asignatura, asignatura2);
                                        this.listarA(this.asignatura.getCorrelatividades());
                                        JOptionPane.showMessageDialog(rootPane, "Asignatura removida de las correlativas exitosamente");
                                    } catch (NoEstaEntidadException e)
                                    {
                                        JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Modificacion de Correlativas", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                            else
                                JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista", "Error de Modificacion de Historia", JOptionPane.WARNING_MESSAGE);     
                            break;
        
            case GUARDAR:   this.dispose(); // Cierra la ventana de modificacion
                            break;
            
            case CANCELAR:  this.dispose(); // Cierra la ventana de modificacion
                            break;
            
            default:        this.dispose(); // Cierra la ventana de modificacion
                            break;
        }
    }
}

