package gui;

import exceptions.NoEstaEntidadException;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import pga.Alumno;
import pga.Asignatura;
import pga.Controlador;

public class ProfesorModificacion extends JFrame implements ActionListener
{
    private static final String ELEGIR = "0";
    private static final String ACEPTAR2 = "1";
    private static final String BUSCAR = "2";
    private static final String CANCELAR1 = "3";
    private static final String CANCELAR2 = "4";
    private static final String ANADIR = "6";
    private static final String REMOVER = "7";
    private static final String BUSCAR2 = "8";
    private static final String CANCELAR3 = "9";
    private static final String ACEPTAR3 = "10";
    private JLabel jLabelNombre1, jLabelApellido1, jLabelLegajo1;
    private JTextField jTextFieldNombre1, jTextFieldApellido1, jTextFieldLegajo1;
    private JButton jButtonBuscar1, jButtonElegir, jButtonCancelar1, jButtonAceptar3, jButtonCancelar3;
    private JScrollPane scrollPanel, scrollPanelC1, scrollPanelC2;
    private JList jListA, jListC1, jListC2;
    private DefaultListModel listModel, listModelC1, listModelC2;
    private JPanel panelA, panelB, panelB1, panelB2, panelC, panelC1, panelC2;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldDomicilio, jTextFieldTelefono, jTextFieldMail, jTextFieldNombreAsignatura;
    private JLabel jLabelNombre, jLabelApellido, jLabelDomicilio, jLabelTelefono, jLabelMail, jLabelNombreAsignatura,
                        jLabelAsigTotales, jLabelAsigHistoria;
    private JButton jButtonAceptar, jButtonCancelar, jButtonModificarHistoria, jButtonAnadir, jButtonRemover, jButtonBuscar2;
    
    private Controlador c;
    
    public ProfesorModificacion (Controlador c)
    {
        super();
        this.c = c;
        this.initComponentsA();
        this.initComponentsB();
        this.add(panelA, BorderLayout.NORTH);
        this.add(panelB, BorderLayout.CENTER);
        this.deshabilitarPanel(this.panelB1);
        this.deshabilitarPanel(this.panelB2);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public void initComponentsA()
    {
        this.panelA = new JPanel();

        GridBagConstraints c = new GridBagConstraints();
        
        this.panelA.setLayout(new GridBagLayout());

        this.jLabelNombre1 = new JLabel("Nombre");
        this.jLabelApellido1 = new JLabel("Apellido");
        this.jTextFieldNombre1 = new JTextField();
        this.jTextFieldApellido1 = new JTextField();
        this.jButtonBuscar1 = new JButton("Buscar");
        this.jLabelLegajo1 = new JLabel("Legajo");
        this.jTextFieldLegajo1 = new JTextField();
        this.jButtonElegir = new JButton("Elegir");
        this.jButtonCancelar1 = new JButton("Cancelar");
        this.listModel = new DefaultListModel();
        this.jListA = new JList(this.listModel);
        this.scrollPanel = new JScrollPane(this.jListA);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jLabelNombre1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panelA.add(this.jTextFieldNombre1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jLabelApellido1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panelA.add(this.jTextFieldApellido1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jButtonBuscar1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jButtonElegir, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.gridheight = 3; 
        c.gridwidth = 2;
        this.panelA.add(this.scrollPanel, c);
        
        this.jButtonElegir.setActionCommand(ELEGIR);
        this.jButtonBuscar1.setActionCommand(BUSCAR);
        this.jButtonCancelar1.setActionCommand(CANCELAR1);
        
        this.jButtonElegir.addActionListener(this);
        this.jButtonBuscar1.addActionListener(this);
        this.jButtonCancelar1.addActionListener(this);
    }
    
    public void initComponentsB()
    {
        //Crea los paneles
        panelB = new JPanel();
        panelB1 = new JPanel();
        panelB1.setLayout(new SpringLayout());
        panelB2 = new JPanel();
        panelB2.setLayout(new BorderLayout());
       // panel2.setLayout(new BoxLayout());
        
        //Crea las etiquetas/labels y anade los label al panel1 y referencia cada textfield con su label
        this.jLabelNombre = new JLabel("Nombre", JLabel.TRAILING);
        panelB1.add(this.jLabelNombre);
        this.jTextFieldNombre = new JTextField(20);
        this.jLabelNombre.setLabelFor(this.jTextFieldNombre);
        panelB1.add(this.jTextFieldNombre);
        
        this.jLabelApellido = new JLabel("Apellido", JLabel.TRAILING);
        panelB1.add(this.jLabelApellido);
        this.jTextFieldApellido = new JTextField(20);
        this.jLabelApellido.setLabelFor(this.jTextFieldApellido);
        panelB1.add(this.jTextFieldApellido);
        
        this.jLabelDomicilio = new JLabel("Domicilio", JLabel.TRAILING);
        panelB1.add(this.jLabelDomicilio);        
        this.jTextFieldDomicilio = new JTextField(20);
        this.jLabelDomicilio.setLabelFor(this.jTextFieldDomicilio);
        panelB1.add(this.jTextFieldDomicilio);
        
        this.jLabelTelefono = new JLabel("Telefono", JLabel.TRAILING);
        panelB1.add(this.jLabelTelefono);        
        this.jTextFieldTelefono = new JTextField(20);
        this.jLabelTelefono.setLabelFor(this.jTextFieldTelefono);
        panelB1.add(this.jTextFieldTelefono);
        
        this.jLabelMail = new JLabel("Mail", JLabel.TRAILING);
        panelB1.add(this.jLabelMail);
        this.jTextFieldMail = new JTextField(20);
        this.jLabelMail.setLabelFor(this.jTextFieldMail);
        panelB1.add(this.jTextFieldMail);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panelB1,
                                        5, 2, //rows, cols
                                        10, 10,        //initX, initY
                                        10, 10);       //xPad, yPad

        //Crea los botones
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        
        //Anade los botones al panel
        this.panelB2.add(this.jButtonAceptar, BorderLayout.NORTH);
        this.panelB2.add(new JLabel(" "), BorderLayout.CENTER);
        this.panelB2.add(this.jButtonCancelar, BorderLayout.SOUTH);   
        
        this.jButtonAceptar.setActionCommand(ACEPTAR2);
        this.jButtonCancelar.setActionCommand(CANCELAR2);
        
        this.jButtonAceptar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
        
        this.panelB.add(this.panelB1, BorderLayout.WEST);
        this.panelB.add(this.panelB2, BorderLayout.EAST);
           
    }
    
    private void listar(HashMap<String, Alumno> h)
    {
        Iterator i = h.values().iterator();
        
        this.listModel.clear();
        while(i.hasNext())
        {
            Alumno a = (Alumno) i.next();
            this.listModel.addElement(a);
        }
    }
    
    private void listarAsignaturas(HashMap<String, Asignatura> h)
    {
        Iterator i = h.values().iterator();
        
        this.listModel.clear();
        while(i.hasNext())
        {
            Alumno a = (Alumno) i.next();
            this.listModel.addElement(a);
        }
    }
    
    public void modificarDatos(Alumno a)
    {
        this.jTextFieldNombre.setText(a.getNombre());
        this.jTextFieldApellido.setText(a.getApellido());
        this.jTextFieldDomicilio.setText(a.getDomicilio());
        this.jTextFieldTelefono.setText(a.getTelefono());
        this.jTextFieldMail.setText(a.getMail());
    }
    
    private void anadirAsignatura()
    {
        int index = this.jListC1.getSelectedIndex();
        Asignatura as = (Asignatura) this.listModelC1.getElementAt(index);
        this.listModelC2.addElement(as);
    }
    
    private void removerAsignatura()
    {
        int index = this.jListC2.getSelectedIndex();
        this.listModelC2.removeElementAt(index);
    }
    
    public void modificarHistoria(Alumno a)
    {
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
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand())
        {
            case ELEGIR:  if(this.jTextFieldLegajo1.getText().length() != 0);
                                //2
                                //TODO ventana error
                            else
                            {
                                int index = this.jListA.getSelectedIndex();
                                Alumno a = (Alumno) this.listModel.getElementAt(index);
                                this.habilitarPanel(this.panelB1);
                                this.habilitarPanel(this.panelB2);
                                this.modificarDatos(a);
                            }
                            break;
        
            case BUSCAR:    if(this.jTextFieldNombre1.getText().length() != 0 && this.jTextFieldApellido1.getText().length() != 0)
                            {
                                try
                                {
                                    this.listar(c.ubicarAlumno(this.jTextFieldNombre1.getText(), this.jTextFieldApellido1.getText()));
                                }
                                catch(NoEstaEntidadException e)
                                {
                                    new VentanaAlerta(this, e.getMessage(), "Error");
                                }
                            }

                                //TODO ventana error
                            break;
        
            case CANCELAR1: 
            case ACEPTAR2:  
            case BUSCAR2:
                            try
                            {
                                this.listarAsignaturas(c.ubicarAsignatura(this.jTextFieldNombreAsignatura.getText()));
                            } catch (NoEstaEntidadException e)
                            {
                                new VentanaAlerta(this, e.getMessage(), "Error");
                            }
            
            case ANADIR:    this.anadirAsignatura();
                            break;               
            
            case REMOVER:   this.removerAsignatura();
                            break;
            
        }
    }       
}
