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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import pga.Alumno;
import pga.Controlador;
import pga.Cursada;

public class CursadaBaja extends JDialog implements ActionListener
{
    private static final String BUSCAR = "0";
    private static final String ELEGIR = "1";
    private static final String CANCELAR = "2";
    
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Controlador controlador;
    private JLabel jLabelNombre;
    private JTextField jTextFieldNombre;
    private JButton jButtonBuscar, jButtonElegir, jButtonCancelar;
    private JScrollPane scrollPanel;
    private JTextArea jTextArea;
    private JList jList;
    private DefaultListModel listModel;
    private JPanel panel, panelDer;
    
    public CursadaBaja(Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Baja Cursada");
        this.initComponents();
        //this.setLayout(new GridLayout(2,2));

        this.add(this.panel, BorderLayout.WEST);
        this.pack();
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
        this.setResizable(false);
        this.setVisible(true);

    }
    
    public void initComponents()
    {

        this.panel = new JPanel();
        
        GridBagConstraints c = new GridBagConstraints();
        
        this.panel.setLayout(new GridBagLayout());

        this.jLabelNombre = new JLabel("Nombre");
        this.jTextFieldNombre = new JTextField();
        this.jButtonBuscar = new JButton("Buscar");
        this.jButtonElegir = new JButton("Elegir cursada");
        this.jButtonCancelar = new JButton("Cancelar");
        this.listModel = new DefaultListModel();
        this.jList = new JList(this.listModel);
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
        c.gridx = 4;
        c.gridy = 2;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jButtonBuscar, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 1;
        this.panel.add(this.jButtonElegir, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridheight = 1; 
        c.gridwidth = 2;
        this.panel.add(this.jButtonCancelar, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        c.gridheight = 3; 
        c.gridwidth = 2;
        this.panel.add(this.scrollPanel, c);
        
        this.jButtonElegir.setActionCommand(ELEGIR);
        this.jButtonBuscar.setActionCommand(BUSCAR);
        this.jButtonCancelar.setActionCommand(CANCELAR);
        
        this.jButtonElegir.addActionListener(this);
        this.jButtonBuscar.addActionListener(this);
        this.jButtonCancelar.addActionListener(this);
    }

    public boolean camposVacios()
    {
        return (this.jTextFieldNombre.getText().length() == 0);
    }

    public void listar(HashMap<String, Cursada> hash)
    {
        Iterator <Cursada> iC = hash.values().iterator();
        
        this.listModel.clear();
        while(iC.hasNext())
            this.listModel.addElement(iC.next());
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
                                    this.listar(controlador.ubicarCursada(this.jTextFieldNombre.getText()));
                            }
                            catch (NoEstaEntidadException e)
                            {
                                JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de Búsqueda", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
            case ELEGIR:   try
                            {
                                if(this.camposVacios())
                                    JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Baja", JOptionPane.WARNING_MESSAGE);
                                else
                                    if (this.jList.getSelectedValue() != null)
                                    {
                                        if (JOptionPane.showConfirmDialog(rootPane, "¿Desea dar de baja la cursada?", "Baja Cursada", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                                        {
                                            this.controlador.bajaCursada((Cursada)this.jList.getSelectedValue());
                                            JOptionPane.showMessageDialog(rootPane, "Baja de Cursada Exitosa");
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
        
            case CANCELAR:  this.dispose();
                            break;
        
            default:        this.dispose(); // Cierra la ventana de baja
                            break;
        }
    }
}
