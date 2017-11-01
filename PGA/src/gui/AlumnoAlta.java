package gui;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import pga.Controlador;

public class AlumnoAlta extends JDialog implements ActionListener
{
    private static final String ACEPTAR = "0";
    private static final String CANCELAR = "1";
    private JPanel panel1, panel2;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldDomicilio, jTextFieldTelefono, jTextFieldMail;
    private JLabel jLabelNombre, jLabelApellido, jLabelDomicilio, jLabelTelefono, jLabelMail;
    private JButton jButtonAceptar, jButtonCancelar;
    //Cantidad de campos
    private int numPairs = 5;
    
    public AlumnoAlta(Controlador c, boolean modal)
    {
        super();
        this.setModal(modal);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Alta alumno");
        this.initComponents();
        this.add(panel1, BorderLayout.WEST);
        panel1.setOpaque(true);
        this.add(panel2, BorderLayout.EAST);
        this.addListeners();
        this.pack();
        this.setVisible(true);
        this.setResizable(false);     
    }
    
    public void initComponents()
    {
        //Crea los paneles
        panel1 = new JPanel();
        panel1.setLayout(new SpringLayout());
        panel2 = new JPanel(new GridBagLayout());
       // panel2.setLayout(new BoxLayout());
        
        //Crea las etiquetas/labels y anade los label al panel1 y referencia cada textfield con su label
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
        
        //Anade los botones al panel
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
    public void actionPerformed(ActionEvent e)
    {
        switch(e.getActionCommand())
        {
            case ACEPTAR:   if(this.camposVacios())
                                System.out.println("Faltan completar campos");
                            else
                                System.out.println("AltaRealizada");
                            break;
            case CANCELAR:  System.out.println("AltaCancelada");
                            this.dispose();//Ponele que cierra la ventana
                            break;
        }
    }
}
