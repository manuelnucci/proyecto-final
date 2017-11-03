package gui;

import exceptions.EmailInvalidoException;
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
import javax.swing.SpringLayout;

import pga.Alumno;
import pga.Asignatura;
import pga.Controlador;
import pga.Profesor;

public class ProfesorModificacion extends JFrame implements ActionListener
{
    private static final String BUSCAR = "0";
    private static final String ELEGIR = "1";
    private static final String ACEPTAR = "2";
    private static final String CANCELAR = "3";
    
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Controlador controlador;
    private JLabel jLabelNombre1, jLabelApellido1, jLabelLegajo1;
    private JTextField jTextFieldNombre1, jTextFieldApellido1, jTextFieldLegajo1;
    private JButton jButtonBuscar1, jButtonElegir;
    private JScrollPane scrollPanel;
    private JList jList;
    private DefaultListModel listModel;
    private JPanel panelA, panelB, panelB1, panelB2;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldDomicilio, jTextFieldTelefono, jTextFieldMail;
    private JLabel jLabelNombre, jLabelApellido, jLabelDomicilio, jLabelTelefono, jLabelMail;
    private JButton jButtonAceptar, jButtonCancelar;
    
    public ProfesorModificacion (Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.initComponentsA();
        this.initComponentsB();
        this.add(panelA, BorderLayout.NORTH);
        this.add(panelB, BorderLayout.CENTER);
        this.deshabilitarPanel(this.panelB1);
        this.deshabilitarPanel(this.panelB2);
        this.setResizable(false);
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
        this.jLabelApellido1 = new JLabel("Apellido");
        this.jTextFieldNombre1 = new JTextField();
        this.jTextFieldApellido1 = new JTextField();
        this.jButtonBuscar1 = new JButton("Buscar");
        this.jLabelLegajo1 = new JLabel("Legajo");
        this.jTextFieldLegajo1 = new JTextField();
        this.jButtonElegir = new JButton("Elegir");
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
        
        this.jButtonElegir.addActionListener(this);
        this.jButtonBuscar1.addActionListener(this);
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
        
        this.jButtonAceptar.setActionCommand(ACEPTAR);
        this.jButtonCancelar.setActionCommand(CANCELAR);
        
        this.jButtonAceptar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
        
        this.panelB.add(this.panelB1, BorderLayout.WEST);
        this.panelB.add(this.panelB2, BorderLayout.EAST);
           
    }
    
    private void listar(HashMap<String, Profesor> h)
    {
        Iterator i = h.values().iterator();
        
        this.listModel.clear();
        while(i.hasNext())
        {
            this.listModel.addElement(i.next());
        }
    }
    
    public void modificarDatos(Profesor p)
    {
        this.jTextFieldNombre.setText(p.getNombre());
        this.jTextFieldApellido.setText(p.getApellido());
        this.jTextFieldDomicilio.setText(p.getDomicilio());
        this.jTextFieldTelefono.setText(p.getTelefono());
        this.jTextFieldMail.setText(p.getMail());
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
                                    this.listar(controlador.ubicarProfesor(this.jTextFieldNombre1.getText(), this.jTextFieldApellido1.getText()));
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
                                this.modificarDatos((Profesor)this.jList.getSelectedValue());
                                }
                                else
                                    JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista", "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                            break;
        
            case ACEPTAR:   try
                            {
                                if(this.camposVacios2())
                                    JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                                else
                                    if (JOptionPane.showConfirmDialog(rootPane, "¿Desea modificar al profesor?", "Modificación Profesor", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                    {
                                        this.controlador.modificaProfesor((Profesor) this.jList.getSelectedValue(),
                                        this.jTextFieldNombre.getText(),
                                        this.jTextFieldApellido.getText(),
                                        this.jTextFieldDomicilio.getText(),
                                        this.jTextFieldTelefono.getText(),
                                        this.jTextFieldMail.getText());
                                        JOptionPane.showMessageDialog(rootPane, "Modificación del Profesor Exitosa");
                                        this.dispose();
                                    }
                            }
                            catch(EmailInvalidoException e)
                            {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Alta", JOptionPane.WARNING_MESSAGE);
                            }
                            catch(NoEstaEntidadException e)
                            {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Modificación", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
        
            case CANCELAR:  this.dispose(); // Cierra la ventana de modificacion
                            break;
        
            default:        this.dispose(); // Cierra la ventana de modificacion
                            break;
        }
    }    
}
