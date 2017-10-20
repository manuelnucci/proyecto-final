package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class AsignaturaAlta extends JFrame implements ActionListener
{
    private static final String ACEPTAR = "0";
    private static final String CANCELAR = "1";
    private JPanel panel1, panel2;
    private JTextField jTextFieldNombre;
    private JLabel jLabelNombre;
    private JButton jButtonAceptar, jButtonCancelar;
    //Cantidad de campos
    private int numPairs = 1;
    
    public AsignaturaAlta()
    {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Alta asignatura");
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
        panel2 = new JPanel();
       // panel2.setLayout(new BoxLayout());
        
        //Crea las etiquetas/labels y anade los label al panel1 y referencia cada textfield con su label
        this.jLabelNombre = new JLabel("Nombre", JLabel.TRAILING);
        panel1.add(this.jLabelNombre);
        this.jTextFieldNombre = new JTextField(20);
        this.jLabelNombre.setLabelFor(this.jTextFieldNombre);
        panel1.add(this.jTextFieldNombre);

        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panel1,
                                        numPairs, 2, //rows, cols
                                        10, 10,        //initX, initY
                                        10, 10);       //xPad, yPad

        //Crea los botones
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        
        //Anade los botones al panel
        this.panel2.add(this.jButtonAceptar);
        this.panel2.add(this.jButtonCancelar);   
        
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
        return !(this.jTextFieldNombre.getText().length() != 0);
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
