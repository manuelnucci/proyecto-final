package gui;

import exceptions.EmailInvalidoException;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import pga.Controlador;

public class AlumnoAlta extends JDialog implements ActionListener
{
    private static final String ACEPTAR = "0";
    private static final String CANCELAR = "1";
    
    private Controlador controlador;
    private JPanel panel1, panel2;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldDomicilio, jTextFieldTelefono, jTextFieldMail;
    private JLabel jLabelNombre, jLabelApellido, jLabelDomicilio, jLabelTelefono, jLabelMail;
    private JButton jButtonAceptar, jButtonCancelar;
    //Cantidad de campos
    private int numPairs = 5;
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    
    public AlumnoAlta(Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.controlador = controlador;
        this.setModal(true);
        this.setResizable(false);
        this.initComponents();
        this.add(panel1, BorderLayout.WEST);
        this.add(panel2, BorderLayout.EAST);
        this.addListeners();
        this.pack();
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
        this.setVisible(true);
    }
    
    public void initComponents()
    {
        //Crea los paneles
        panel1 = new JPanel();
        panel1.setLayout(new SpringLayout());
        panel2 = new JPanel(new GridBagLayout());
        panel2.setLayout(new GridBagLayout());
        
        // Crea las etiquetas/labels y añade los label al panel1 y referencia cada textfield con su label
        this.jLabelNombre = new JLabel("Nombre", JLabel.TRAILING);
        panel1.add(this.jLabelNombre);
        this.jTextFieldNombre = new JTextField(20);
        this.jLabelNombre.setLabelFor(this.jTextFieldNombre);
        panel1.add(this.jTextFieldNombre);
        
        this.jLabelApellido = new JLabel("Apellido", JLabel.TRAILING);
        panel1.add(this.jLabelApellido);
        this.jTextFieldApellido = new JTextField(20);
        this.jLabelApellido.setLabelFor(this.jTextFieldApellido);
        panel1.add(this.jTextFieldApellido);
        
        this.jLabelDomicilio = new JLabel("Domicilio", JLabel.TRAILING);
        panel1.add(this.jLabelDomicilio);        
        this.jTextFieldDomicilio = new JTextField(20);
        this.jLabelDomicilio.setLabelFor(this.jTextFieldDomicilio);
        panel1.add(this.jTextFieldDomicilio);
        
        this.jLabelTelefono = new JLabel("Telefono", JLabel.TRAILING);
        panel1.add(this.jLabelTelefono);        
        this.jTextFieldTelefono = new JTextField(20);
        this.jLabelTelefono.setLabelFor(this.jTextFieldTelefono);
        panel1.add(this.jTextFieldTelefono);
        
        this.jLabelMail = new JLabel("Mail", JLabel.TRAILING);
        panel1.add(this.jLabelMail);
        this.jTextFieldMail = new JTextField(20);
        this.jLabelMail.setLabelFor(this.jTextFieldMail);
        panel1.add(this.jTextFieldMail);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panel1,
                                        numPairs, 2, //rows, cols
                                        10, 10,        //initX, initY
                                        10, 10);       //xPad, yPad

        //Crea los botones
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        
        // Añade los botones al panel
        GridBagConstraints c = new GridBagConstraints();
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel2.add(this.jButtonAceptar, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel2.add(new JLabel(" "), c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel2.add(this.jButtonCancelar, c); 
        
        this.jButtonAceptar.setActionCommand(ACEPTAR);
        this.jButtonCancelar.setActionCommand(CANCELAR);
    }

    public void addListeners()
    {
        this.jButtonAceptar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
    }
    
    public boolean camposVacios()
    {
        return !(this.jTextFieldNombre.getText().length() != 0 && this.jTextFieldApellido.getText().length() != 0 &&
                this.jTextFieldDomicilio.getText().length() != 0 && this.jTextFieldTelefono.getText().length() != 0 &&
                this.jTextFieldMail.getText().length() != 0);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand())
        {
            case ACEPTAR:   try
                            {
                                if(this.camposVacios())
                                    JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Alta", JOptionPane.WARNING_MESSAGE);
                                else
                                {
                                    if (JOptionPane.showConfirmDialog(rootPane, "¿Desea dar de alta al alumno?", "Alta Alumno", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                    {
                                        controlador.altaAlumno(this.jTextFieldNombre.getText(), this.jTextFieldApellido.getText(), this.jTextFieldDomicilio.getText(), this.jTextFieldTelefono.getText(), this.jTextFieldMail.getText());
                                        JOptionPane.showMessageDialog(rootPane, "Alta del Alumno Exitosa");
                                        this.dispose();
                                    }
                                }
                                break;
                            }
                            catch (EmailInvalidoException e)
                            {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Alta", JOptionPane.WARNING_MESSAGE);
                            }
            default:        this.dispose(); // Cierra la ventana de alta
        }
    }
}
