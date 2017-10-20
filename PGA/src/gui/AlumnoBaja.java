package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import pga.Controlador;

public class AlumnoBaja extends JFrame implements ActionListener
{
    private Controlador controlador;
    private JLabel jLabelNombre, jLabelApellido,jLabelLegajo;
    private JTextField jTextFieldNombre, jTextFieldApellido,jTextFieldLegajo;
    private JButton jButtonBuscar, jButtonAceptar, jButtonCancelar;
    private JScrollPane scrollPanel;
    private JTextArea jTextArea;
    private JList jList;
    private JPanel panel, panelDer;
    
    public AlumnoBaja(Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Baja Alumno");
        this.initComponents();
        //this.setLayout(new GridLayout(2,2));

        this.add(this.panel, BorderLayout.WEST);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);

    }
    
    public void initComponents()
    {

        this.panel = new JPanel();
        
        GridBagConstraints c = new GridBagConstraints();
        
        this.panel.setLayout(new GridBagLayout());

        this.jLabelNombre = new JLabel("Nombre");
        this.jLabelApellido = new JLabel("Apellido");
        this.jTextFieldNombre = new JTextField();
        this.jTextFieldApellido = new JTextField();
        this.jButtonBuscar = new JButton("Buscar");
        this.jLabelLegajo = new JLabel("Legajo");
        this.jTextFieldLegajo = new JTextField();
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        this.jList = new JList();
        this.jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.jList.setLayoutOrientation(JList.VERTICAL);
        this.scrollPanel = new JScrollPane(this.jList);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jLabelNombre, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panel.add(this.jTextFieldNombre, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jLabelApellido, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panel.add(this.jTextFieldApellido, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jButtonBuscar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jLabelLegajo, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panel.add(this.jTextFieldLegajo, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jButtonAceptar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jButtonCancelar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.gridheight = 3; 
        c.gridwidth = 2;
        this.panel.add(this.scrollPanel, c);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        // TODO Implement this method
    }
}
