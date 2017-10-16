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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AlumnoBaja extends JFrame implements ActionListener
{
    private JLabel jLabelNombre, jLabelLegajo;
    private JTextField jTextFieldNombre, jTextFieldLegajo;
    private JButton jButtonBuscar, jButtonAceptar, jButtonCancelar;
    private JScrollPane scrollPanel;
    private JTextArea jTextArea;
    private JPanel panelIzq, panelDer;
    
    public AlumnoBaja()
    {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Baja Alumno");
        this.initComponents();
        //this.setLayout(new GridLayout(2,2));

        this.add(this.panelIzq, BorderLayout.WEST);
        this.add(this.panelDer, BorderLayout.EAST);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);

    }
    
    public void initComponents()
    {
        this.panelIzq = new JPanel();
        this.panelDer = new JPanel();
        
        /*this.panelIzq.setLayout(new GridLayout(4, 2));
        this.panelDer.setLayout(new BorderLayout());
        
        this.jLabelNombre = new JLabel("Nombre");
        this.jTextFieldNombre = new JTextField(20);
        this.jButtonBuscar = new JButton("Buscar");
        this.jLabelLegajo = new JLabel("Legajo");
        this.jTextFieldLegajo = new JTextField(20);
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        
        this.panelIzq.add(this.jLabelNombre);
        this.panelIzq.add(this.jTextFieldNombre);
        this.panelIzq.add(new JLabel(""));
        this.panelIzq.add(this.jButtonBuscar);
        this.panelIzq.add(this.jLabelLegajo);
        this.panelIzq.add(this.jTextFieldLegajo);
        this.panelIzq.add(this.jButtonAceptar);
        this.panelIzq.add(this.jButtonCancelar);
        
        this.jTextArea = new JTextArea(30, 20);
        this.scrollPanel = new JScrollPane(this.jTextArea);

        
        this.panelDer.add(this.scrollPanel, BorderLayout.NORTH);*/
        
        
        /*this.panelIzq.setLayout(new SpringLayout());
        this.panelDer.setLayout(new BorderLayout());
        
        this.jLabelNombre = new JLabel("Nombre");
        this.panelIzq.add(this.jLabelNombre);
        this.jTextFieldNombre = new JTextField(20);
        this.panelIzq.add(this.jTextFieldNombre);
        this.panelIzq.add(new JLabel(""));
        this.jButtonBuscar = new JButton("Buscar");
        this.panelIzq.add(this.jButtonBuscar);
        this.jLabelLegajo = new JLabel("Legajo");
        this.panelIzq.add(this.jLabelLegajo);
        this.jTextFieldLegajo = new JTextField(20);
        this.panelIzq.add(this.jTextFieldLegajo);
        this.jButtonAceptar = new JButton("Aceptar");
        this.panelIzq.add(this.jButtonAceptar);
        this.jButtonCancelar = new JButton("Cancelar");
        this.panelIzq.add(this.jButtonCancelar);        

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panelIzq,
                                        4, 4, //rows, cols
                                        10, 10,        //initX, initY
                                        100, 100);       //xPad, yPad
        
        this.jTextArea = new JTextArea(30, 20);
        this.scrollPanel = new JScrollPane(this.jTextArea);

        
        this.panelDer.add(this.scrollPanel, BorderLayout.NORTH);
*/
        GridBagConstraints c = new GridBagConstraints();
        
        this.panelIzq.setLayout(new GridBagLayout());

        this.jLabelNombre = new JLabel("Nombre");
        this.jTextFieldNombre = new JTextField();
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
        this.panelIzq.add(this.jLabelNombre, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panelIzq.add(this.jTextFieldNombre, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelIzq.add(this.jButtonBuscar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelIzq.add(this.jLabelLegajo, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 4;
        this.panelIzq.add(this.jTextFieldLegajo, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelIzq.add(this.jButtonAceptar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 3;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panelIzq.add(this.jButtonCancelar, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.gridheight = 3; 
        c.gridwidth = 2;
        this.panelIzq.add(this.scrollPanel, c);


        


        
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        // TODO Implement this method
    }
}
