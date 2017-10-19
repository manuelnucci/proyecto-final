package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import pga.Controlador;

public class ModificaHistoriaAlumno extends JFrame implements ActionListener
{
    private static final String ANADIR = "6";
    private static final String REMOVER = "7";
    private static final String BUSCAR = "8";
    private static final String CANCELAR = "9";
    private static final String GUARDAR = "10";
    private JScrollPane scrollPanel, scrollPanelC1, scrollPanelC2;
    private JList jListA, jListC1, jListC2;
    private DefaultListModel listModel, listModelC1, listModelC2;
    private JPanel panelA, panelB;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldDomicilio, jTextFieldTelefono, jTextFieldMail, jTextFieldNombreAsignatura;
    private JLabel jLabelNombre, jLabelApellido, jLabelDomicilio, jLabelTelefono, jLabelMail, jLabelNombreAsignatura,
                        jLabelAsigTotales, jLabelAsigHistoria;
    private JButton jButtonGuardar, jButtonCancelar, jButtonModificarHistoria, jButtonAnadir, jButtonRemover, jButtonElegir, jButtonBuscar, jButtonBuscar2;
    
    private Controlador c;
    
    public ModificaHistoriaAlumno()
    {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.initComponentsA();
        this.initComponentsB();
        this.add(this.panelA, BorderLayout.NORTH);
        this.add(this.panelB, BorderLayout.SOUTH);
        this.pack();
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
        this.jLabelApellido = new JLabel("Apellido");
        this.jTextFieldNombre = new JTextField();
        this.jTextFieldApellido = new JTextField();
        this.jLabelNombreAsignatura = new JLabel("Nombre Asignatura");
        this.jTextFieldNombreAsignatura = new JTextField();
        this.jLabelAsigTotales = new JLabel("Asignaturas encontradas");
        this.jLabelAsigHistoria = new JLabel("Historia Academica");
        this.jButtonBuscar = new JButton("Buscar");
        this.jButtonElegir = new JButton("Elegir");
        this.jButtonBuscar2 = new JButton("Buscar");
        this.jButtonAnadir = new JButton("Anadir >>");
        this.jButtonRemover = new JButton("Remover <<");
        this.jButtonGuardar = new JButton("Guardar");
        this.jButtonCancelar = new JButton("Cancelar");
        
        this.jButtonBuscar2.setActionCommand(BUSCAR);
        this.jButtonAnadir.setActionCommand(ANADIR);
        this.jButtonRemover.setActionCommand(REMOVER);
        this.jButtonGuardar.setActionCommand(GUARDAR);
        this.jButtonCancelar.setActionCommand(CANCELAR);
        
        this.jButtonBuscar2.addActionListener(this);
        this.jButtonAnadir.addActionListener(this);
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
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jLabelApellido, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 2;
        this.panelA.add(this.jTextFieldNombre, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 2;
        this.panelA.add(this.jTextFieldApellido, c);
        
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
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jLabelNombreAsignatura, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelB.add(this.jTextFieldNombreAsignatura, c);
        
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


    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        // TODO Implement this method
    }
}
