package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class CursadaBaja extends JFrame implements ActionListener
{
    private JLabel jLabelNombre;
    private JTextField jTextFieldNombre;
    private JButton jButtonBuscar, jButtonElegir, jButtonCancelar;
    private JScrollPane scrollPanel;
    private JTextArea jTextArea;
    private JList jList;
    private DefaultListModel listModel;
    private JPanel panel, panelDer;
    
    public CursadaBaja()
    {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Baja Cursada");
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
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        // TODO Implement this method
    }
}
