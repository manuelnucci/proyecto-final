package gui;

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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.SpringLayout;

import pga.Alumno;
import pga.Controlador;
import pga.NoEstaEntidadException;

public class AlumnoModificar extends JFrame implements ActionListener
{
    private static final String ACEPTAR1 = "0";
    private static final String ACEPTAR2 = "1";
    private static final String BUSCAR = "2";
    private static final String CANCELAR1 = "3";
    private static final String CANCELAR2 = "4";
    private static final String MODIFICAR_HISTORIA = "5";
    private JLabel jLabelNombre1, jLabelApellido1, jLabelLegajo1;
    private JTextField jTextFieldNombre1, jTextFieldApellido1, jTextFieldLegajo1;
    private JButton jButtonBuscar1, jButtonAceptar1, jButtonCancelar1;
    private JScrollPane scrollPanel;
    private JList jList;
    private DefaultListModel listModel;
    private JPanel panelA, panelB, panelB1, panelB2, panelC;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldDomicilio, jTextFieldTelefono, jTextFieldMail;
    private JLabel jLabelNombre, jLabelApellido, jLabelDomicilio, jLabelTelefono, jLabelMail;
    private JButton jButtonAceptar, jButtonCancelar, jButtonModificarHistoria;
    
    private Controlador c;
    
    public AlumnoModificar(Controlador c)
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
        this.jButtonAceptar1 = new JButton("Aceptar");
        this.jButtonCancelar1 = new JButton("Cancelar");
        this.listModel = new DefaultListModel();
        this.jList = new JList(this.listModel);
        this.scrollPanel = new JScrollPane(this.jList);
        
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
        c.gridx = 4;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jButtonAceptar1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelA.add(this.jButtonCancelar1, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.gridheight = 3; 
        c.gridwidth = 2;
        this.panelA.add(this.scrollPanel, c);
        
        this.jButtonAceptar1.setActionCommand(ACEPTAR1);
        this.jButtonBuscar1.setActionCommand(BUSCAR);
        this.jButtonCancelar1.setActionCommand(CANCELAR1);
        
        this.jButtonAceptar1.addActionListener(this);
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
        this.jButtonModificarHistoria = new JButton("Modificar Historia");
        
        //Anade los botones al panel
        this.panelB2.add(this.jButtonAceptar, BorderLayout.WEST);
        this.panelB2.add(this.jButtonCancelar, BorderLayout.EAST);   
        this.panelB2.add(this.jButtonModificarHistoria, BorderLayout.SOUTH);
        
        this.jButtonAceptar.setActionCommand(ACEPTAR2);
        this.jButtonCancelar.setActionCommand(CANCELAR2);
        this.jButtonModificarHistoria.setActionCommand(MODIFICAR_HISTORIA);
        
        this.jButtonAceptar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
        this.jButtonModificarHistoria.addActionListener(this);
        
        this.panelB.add(this.panelB1, BorderLayout.WEST);
        this.panelB.add(this.panelB2, BorderLayout.EAST);
           
    }
    
    public void initComponentsC()
    {
        this.panelC = new JPanel();
        this.
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
    
    public void modificarDatos(Alumno a)
    {
        this.jTextFieldNombre.setText(a.getNombre());
        this.jTextFieldApellido.setText(a.getApellido());
        this.jTextFieldDomicilio.setText(a.getDomicilio());
        this.jTextFieldTelefono.setText(a.getTelefono());
        this.jTextFieldMail.setText(a.getMail());
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
            case ACEPTAR1:  if(this.jTextFieldLegajo1.getText().length() != 0);
                                //2
                                //TODO ventana error
                            else
                            {
                                int index = this.jList.getSelectedIndex();
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
                                    new VentanaAlerta(this, e.getMensaje(), "Error");
                                }
                            }

                                //TODO ventana error
            case CANCELAR1: 
            case ACEPTAR2:
            case MODIFICAR_HISTORIA:    
        }
    }
                                
}