package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CursadaAlta1 extends JFrame implements ActionListener
{
    private JLabel jLabelNombre, jLabelDia, jLabelHoraInicio, jLabelHoraFin, jLabelAno;
    private JComboBox jComboBoxDia;
    private JRadioButton jRadioButton1Cuatrimestre, jRadioButton2Cuatrimestre;
    private JTextField jTextFieldNombre, jTextFieldAsignatura;
    
    public CursadaAlta1()
    {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        // TODO Implement this method
    }
}
