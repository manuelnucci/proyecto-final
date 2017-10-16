package gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
    private JLabel jLabelNombre, jLabelApellido, jLabelLegajo;
    private JTextField jTextFieldNombre, jTextFieldApellido, jTextFieldLegajo;
    private JButton jButtonBuscar, jButtonAceptar, jButtonCancelar;
    private JScrollPane scrollPanel;
    private JTextArea jTextArea;
    private JPanel panel1, panel2;
    private Controlador c;
    
    public AlumnoModificar(Controlador c)
    {
        super();
        this.c = c;
        this.initComponents1();
        this.add(panel1);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public void initComponents1()
    {
        this.panel1 = new JPanel();

        
        GridBagConstraints c = new GridBagConstraints();
        
        this.panel1.setLayout(new GridBagLayout());

        this.jLabelNombre = new JLabel("Nombre");
        this.jLabelApellido = new JLabel("Apellido");
        this.jTextFieldNombre = new JTextField();
        this.jTextFieldApellido = new JTextField();
        this.jButtonBuscar = new JButton("Buscar");
        this.jLabelLegajo = new JLabel("Legajo");
        this.jTextFieldLegajo = new JTextField();
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        this.jTextArea = new JTextArea(12, 20);
        this.scrollPanel = new JScrollPane(this.jTextArea);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel1.add(this.jLabelNombre, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panel1.add(this.jTextFieldNombre, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel1.add(this.jLabelApellido, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panel1.add(this.jTextFieldApellido, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel1.add(this.jButtonBuscar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel1.add(this.jLabelLegajo, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panel1.add(this.jTextFieldLegajo, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel1.add(this.jButtonAceptar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel1.add(this.jButtonCancelar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.gridheight = 3; 
        c.gridwidth = 2;
        this.panel1.add(this.scrollPanel, c);
        
        this.jButtonAceptar.setActionCommand(ACEPTAR1);
        this.jButtonBuscar.setActionCommand(BUSCAR);
        this.jButtonCancelar.setActionCommand(CANCELAR1);
        
        this.jButtonAceptar.addActionListener(this);
        this.jButtonBuscar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
    }
    
    private void listar(HashMap<String, Alumno> h)
    {
        Iterator i = h.values().iterator();
        
        this.jTextArea.setText("");
        while(i.hasNext())
        {
            Alumno a = (Alumno) i.next();
            this.jTextArea.append(a.getNombre() + " " + a.getApellido() + " " + a.getLegajo() + " " + a.getDomicilio() + 
                        " " + a.getTelefono() + " " + a.getMail() + "\n\n");
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        switch(ae.getActionCommand())
        {
            case ACEPTAR1:  if(this.jTextFieldLegajo.getText().length() != 0)
                                this.initComponents1();//2
                                //TODO ventana error
            case BUSCAR:    if(this.jTextFieldNombre.getText().length() != 0 && this.jTextFieldApellido.getText().length() != 0)
                            {
                                try
                                {
                                    this.listar(c.ubicarAlumno(this.jTextFieldNombre.getText(), this.jTextFieldApellido.getText()));
                                }
                                catch(NoEstaEntidadException e)
                                {
                                    new VentanaAlerta(this, e.getMensaje(), "Error");
                                }
                            }

                                //TODO ventana error
            case CANCELAR1: 
        }
    }
                                
}
