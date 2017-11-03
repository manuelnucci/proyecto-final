package gui;

import exceptions.NoEstaEntidadException;

import java.awt.BorderLayout;
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

import pga.Controlador;
import pga.Profesor;

public class ProfesorBaja extends JDialog implements ActionListener
{
    private static final String BUSCAR = "0";
    private static final String ACEPTAR = "1";
    private static final String CANCELAR = "2";
    
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Controlador controlador;
    private JLabel jLabelNombre, jLabelApellido;
    private JTextField jTextFieldNombre, jTextFieldApellido;
    private JButton jButtonBuscar, jButtonAceptar, jButtonCancelar;
    private JScrollPane scrollPanel;
    private JList jList;
    private DefaultListModel listModel;
    private JPanel panel;
    
    public ProfesorBaja(Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.setTitle("Baja Profesor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setResizable(false);
        this.initComponents();
        this.add(this.panel, BorderLayout.WEST);
        this.addListeners();
        this.pack();
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
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
        this.jButtonAceptar = new JButton("Aceptar");
        this.jButtonCancelar = new JButton("Cancelar");
        this.listModel = new DefaultListModel();
        this.jList = new JList(listModel);
        this.jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        
        this.jButtonAceptar.setActionCommand(ACEPTAR);
        this.jButtonBuscar.setActionCommand(BUSCAR);
        this.jButtonCancelar.setActionCommand(CANCELAR);
    }
    
    public void addListeners()
    {
        this.jButtonAceptar.addActionListener(this);
        this.jButtonBuscar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
    }
    
    public boolean camposVacios()
    {
        return !(this.jTextFieldNombre.getText().length() != 0 && this.jTextFieldApellido.getText().length() != 0);
    }
    
    public void listar(HashMap<String, Profesor> hash)
    {
        Iterator <Profesor> iA = hash.values().iterator();
        
        this.listModel.clear();
        while(iA.hasNext())
            this.listModel.addElement(iA.next());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        switch(actionEvent.getActionCommand())
        {
            case BUSCAR:    try
                            {
                                if (this.camposVacios()) 
                                    JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Baja", JOptionPane.WARNING_MESSAGE);
                                else
                                    this.listar(controlador.ubicarProfesor(this.jTextFieldNombre.getText(), this.jTextFieldApellido.getText()));
                            }
                            catch (NoEstaEntidadException e)
                            {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
        
            case ACEPTAR:   try
                            {
                                if(this.camposVacios())
                                    JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Baja", JOptionPane.WARNING_MESSAGE);
                                else
                                    if (this.jList.getSelectedValue() != null)
                                    {
                                        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea dar de baja al profesor?", "Baja Profesor", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                        {
                                            controlador.bajaProfesor((Profesor)this.jList.getSelectedValue());
                                            JOptionPane.showMessageDialog(rootPane, "Baja del Profesor Exitosa");
                                            this.dispose();
                                        }
                                    }
                                    else
                                        JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista", "Error de Baja", JOptionPane.WARNING_MESSAGE);
                            }
                            catch (NoEstaEntidadException e)
                            {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Baja", JOptionPane.WARNING_MESSAGE);
                            }                            
                            break;
        
            default:        this.dispose(); // Cierra la ventana de baja
                            break;
        }
    }
}