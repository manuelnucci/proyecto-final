package gui;

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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import pga.Alumno;
import pga.Controlador;

public class AlumnoModificar extends JDialog implements ActionListener
{
    private static final String BUSCAR = "0";
    private static final String ELEGIR = "1";
    private static final String ACEPTAR = "2";
    private static final String CANCELAR = "3";
    
    private Controlador controlador;
    private JLabel jLabelNombre1, jLabelApellido1;
    private JTextField jTextFieldNombre1, jTextFieldApellido1;
    private JButton jButtonElegir, jButtonBuscar, jButtonAceptar, jButtonCancelar;
    private JScrollPane scrollPanel;
    private JList jList;
    private DefaultListModel listModel;
    private JPanel panelA, panelB, panelB1, panelB2;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldDomicilio, jTextFieldTelefono, jTextFieldMail;
    private JLabel jLabelNombre, jLabelApellido, jLabelDomicilio, jLabelTelefono, jLabelMail;
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    
    public AlumnoModificar(Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.setTitle("Modificación Alumno");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setResizable(false);
        this.initComponentsA();
        this.initComponentsB();
        this.add(panelA, BorderLayout.NORTH);
        this.add(panelB, BorderLayout.CENTER);
        this.deshabilitarPanel(this.panelB1);
        this.deshabilitarPanel(this.panelB2);
        this.pack();
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
        this.setVisible(true);
    }

    public void initComponentsA()
    {
        this.panelA = new JPanel();

        GridBagConstraints c = new GridBagConstraints();
        
        this.panelA.setLayout(new GridBagLayout());

        this.jLabelNombre1 = new JLabel("Nombre");
        this.jTextFieldNombre1 = new JTextField();
        this.jLabelApellido1 = new JLabel("Apellido");
        this.jTextFieldApellido1 = new JTextField();
        this.jButtonBuscar = new JButton("Buscar");
        this.jButtonElegir = new JButton("Elegir");
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        this.listModel = new DefaultListModel();
        this.jList = new JList();
        this.jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jList.setLayoutOrientation(JList.VERTICAL);
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
        this.panelA.add(this.jButtonBuscar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
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
        this.jButtonBuscar.setActionCommand(BUSCAR);
        
        this.jButtonElegir.addActionListener(this);
        this.jButtonBuscar.addActionListener(this);
    }
    
    public void initComponentsB()
    {
        //Crea los paneles
        panelB = new JPanel();
        panelB1 = new JPanel();
        panelB1.setLayout(new SpringLayout());
        panelB2 = new JPanel();
        panelB2.setLayout(new BorderLayout());
        
        // Crea las etiquetas/labels y añade los label al panel1 y referencia cada textfield con su label
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
        
        // Añade los botones al panel
        this.panelB2.add(this.jButtonAceptar, BorderLayout.NORTH);
        this.panelB2.add(new JLabel(" "), BorderLayout.CENTER);
        this.panelB2.add(this.jButtonCancelar, BorderLayout.SOUTH);   
        
        this.jButtonAceptar.setActionCommand(ACEPTAR);
        this.jButtonCancelar.setActionCommand(CANCELAR);
        
        this.jButtonAceptar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
        
        this.panelB.add(this.panelB1, BorderLayout.WEST);
        this.panelB.add(this.panelB2, BorderLayout.EAST);
    }
    
    public boolean camposVacios1()
    {
        return !(this.jTextFieldNombre1.getText().length() != 0 && this.jTextFieldApellido1.getText().length() != 0);
    }
        
    public boolean camposVacios2()
        {
        return !(this.jTextFieldNombre.getText().length() != 0 && this.jTextFieldApellido.getText().length() != 0 &&
                this.jTextFieldDomicilio.getText().length() != 0 && this.jTextFieldTelefono.getText().length() != 0 &&
                this.jTextFieldMail.getText().length() != 0);
        }
    
    public void listar(HashMap<String, Alumno> hash)
    {
        Iterator <Alumno> iA = hash.values().iterator();
        
        this.listModel.clear();
        while(iA.hasNext())
            this.listModel.addElement(iA.next());
        this.jList.setModel(this.listModel);
        }
    
    public void modificarDatos(Alumno alumno)
    {
        this.jTextFieldNombre.setText(alumno.getNombre());
        this.jTextFieldApellido.setText(alumno.getApellido());
        this.jTextFieldDomicilio.setText(alumno.getDomicilio());
        this.jTextFieldTelefono.setText(alumno.getTelefono());
        this.jTextFieldMail.setText(alumno.getMail());
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
    public void actionPerformed(ActionEvent actionEvent)
    {
        switch(actionEvent.getActionCommand())
        {
            case BUSCAR:    try
                            {
                                this.deshabilitarPanel(this.panelB1);
                                this.deshabilitarPanel(this.panelB2);
                                if (this.camposVacios1()) 
                                    JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                            else
                                    this.listar(controlador.ubicarAlumno(this.jTextFieldNombre1.getText(), this.jTextFieldApellido1.getText()));
                            }
                            catch (NoEstaEntidadException e)
                            {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
            case ELEGIR:    if (this.camposVacios1())
                                JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                            else
                                if (this.jList.getSelectedValue() != null)
                                {
                                this.habilitarPanel(this.panelB1);
                                this.habilitarPanel(this.panelB2);
                                    this.modificarDatos((Alumno)this.jList.getSelectedValue());
                            }
                                else
                                    JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista", "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                            break;
            case ACEPTAR:   try
                            {
                                if(this.camposVacios2())
                                    JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                                else
                                {
                                    if (JOptionPane.showConfirmDialog(rootPane, "¿Desea modificar al alumno?", "Modificación Alumno", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                    {
                                        //if (controlador.verificaMail(this.jTextFieldMail.getText()))
                                        {
                                            this.controlador.modificaAlumno((Alumno)this.jList.getSelectedValue(), this.jTextFieldNombre.getText(), this.jTextFieldApellido.getText(), this.jTextFieldDomicilio.getText(), this.jTextFieldTelefono.getText(), this.jTextFieldMail.getText());
                                            JOptionPane.showMessageDialog(rootPane, "Modificación del Alumno Exitosa");
                                            this.dispose();
                                        }
                                        //else
                                            JOptionPane.showMessageDialog(rootPane, "Formato del mail incorrecto.", "Error de Alta", JOptionPane.WARNING_MESSAGE);
                                    }
                                }
                            }
                                catch(NoEstaEntidadException e)
                                {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                                }
                            break;
            default:        this.dispose();
        }
    }
}
