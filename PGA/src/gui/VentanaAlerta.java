package gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaAlerta extends JDialog
{
    public VentanaAlerta(JFrame jFrame, String mensaje, String title)
    {
        super();
        this.setModal(true);
        this.setTitle(title);
        this.add(new JLabel(mensaje), BorderLayout.CENTER);
        this.add(new JButton("Aceptar"), BorderLayout.SOUTH);
        this.setSize(250, 125);
        this.setLocation(jFrame.getLocation().x + jFrame.getWidth() / 2 - this.getWidth() / 2, jFrame.getLocation().y + jFrame.getHeight() / 2 - this.getHeight() / 2);
        this.setVisible(true);
    }
}
