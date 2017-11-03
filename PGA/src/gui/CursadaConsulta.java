
package gui;

import exceptions.NoEstaEntidadException;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

import pga.Controlador;
import pga.Cursada;

/**
 *
 * @author DELL
 */
public class CursadaConsulta extends javax.swing.JFrame
{
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private Controlador controlador;
    private DefaultListModel listModel;
    private Cursada cursada;
    private HashMap<String, Cursada> hash;

    /** Creates new form CursadaConsulta */
    public CursadaConsulta(Controlador controlador)
    {
        this.controlador = controlador;
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocation(d.width / 2 - this.getWidth() / 2, d.height / 2 - this.getHeight() / 2);
        this.setResizable(false);
        this.setVisible(true);
    }

    public boolean camposVaciosCursada()
    {
        return this.jTextFieldNombre.getText().length() == 0;
    }

    public void listarC(HashMap<String, Cursada> hash)
    {
        Iterator <Cursada> iA = hash.values().iterator();
        
        this.listModel.clear();
        while(iA.hasNext())
            this.listModel.addElement(iA.next());
    }
    
    public void consultaDatos()
    {
        this.jLabelNombreC2.setText(this.cursada.getNombre());
        this.jLabelAsignaturaC2.setText(this.cursada.getAsignatura().getNombre());
        this.jLabelDiaC2.setText(this.cursada.getDia());
        this.jLabelHorarioC2.setText(this.cursada.getHoraInicio() + " - " + this.cursada.getHoraFin());
        this.jLabelPeriodoC2.setText(this.cursada.getPeriodo());
        this.jLabelIDC2.setText(this.cursada.getId());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()//GEN-BEGIN:initComponents
    {

        jPanel1 = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listModel = new DefaultListModel();
        jList1 = new javax.swing.JList<>(listModel);
        jButtonElegir = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jLabelNombreC1 = new javax.swing.JLabel();
        jLabelPeriodoC1 = new javax.swing.JLabel();
        jLabelAsignaturaC1 = new javax.swing.JLabel();
        jLabelDiaC1 = new javax.swing.JLabel();
        jLabelHorarioC1 = new javax.swing.JLabel();
        jLabelIDC1 = new javax.swing.JLabel();
        jLabelNombreC2 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jLabelPeriodoC2 = new javax.swing.JLabel();
        jLabelAsignaturaC2 = new javax.swing.JLabel();
        jLabelHorarioC2 = new javax.swing.JLabel();
        jLabelIDC2 = new javax.swing.JLabel();
        jLabelDiaC2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelNombre.setText("Nombre");

        jScrollPane1.setViewportView(jList1);

        jButtonElegir.setText("Elegir");
        jButtonElegir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonElegirActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabelNombre)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonElegir)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonElegir)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelNombre)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jButtonBuscar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelNombreC1.setText("Nombre");

        jLabelPeriodoC1.setText("Periodo");

        jLabelAsignaturaC1.setText("Aisgnatura");

        jLabelDiaC1.setText("Dia");

        jLabelHorarioC1.setText("Horario");

        jLabelIDC1.setText("ID");

        jLabelNombreC2.setText("..............");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabelPeriodoC2.setText("..............");

        jLabelAsignaturaC2.setText("..............");

        jLabelHorarioC2.setText("..............");

        jLabelIDC2.setText("..............");

        jLabelDiaC2.setText("..............");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreC1)
                            .addComponent(jLabelPeriodoC1)
                            .addComponent(jLabelHorarioC1)
                            .addComponent(jLabelDiaC1)
                            .addComponent(jLabelAsignaturaC1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHorarioC2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDiaC2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAsignaturaC2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPeriodoC2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreC2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelIDC1)
                        .addGap(48, 48, 48)
                        .addComponent(jLabelIDC2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabelNombreC2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNombreC1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPeriodoC1)
                    .addComponent(jLabelPeriodoC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAsignaturaC1)
                    .addComponent(jLabelAsignaturaC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDiaC1)
                    .addComponent(jLabelDiaC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHorarioC1)
                    .addComponent(jLabelHorarioC2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDC1)
                    .addComponent(jLabelIDC2)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonAceptar))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonBuscarActionPerformed
    {//GEN-HEADEREND:event_jButtonBuscarActionPerformed
        try
        {
            if (this.camposVaciosCursada()) 
                JOptionPane.showMessageDialog(rootPane, "Ingrese el nombre de la cursada", "Error de Busqueda", JOptionPane.WARNING_MESSAGE);
            else
            {
                this.hash = controlador.ubicarCursada(this.jTextFieldNombre.getText());
                this.listarC(this.hash);
            }
        }
        catch (NoEstaEntidadException e)
        {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Error de B�squeda", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonElegirActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonElegirActionPerformed
    {//GEN-HEADEREND:event_jButtonElegirActionPerformed
        int index;

        if (this.camposVaciosCursada())
            JOptionPane.showMessageDialog(rootPane, "Faltan completar campos", "Error de Alta de Cursada", JOptionPane.WARNING_MESSAGE);
        else
            if (this.jList1.getSelectedValue() != null)
            {
                index = this.jList1.getSelectedIndex();
                this.cursada = (Cursada) this.listModel.getElementAt(index);
                JOptionPane.showMessageDialog(rootPane, "Se ha seleccionado la asignatura");
                this.consultaDatos();
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Seleccione un elemento de la lista", "Error de Alta de Cursada", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButtonElegirActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAceptarActionPerformed
    {//GEN-HEADEREND:event_jButtonAceptarActionPerformed
        if (this.hash != null)
        {
            JOptionPane.showMessageDialog(rootPane, "Consulta de Cursada Exitosa");
            this.dispose();   
        }
        else
        JOptionPane.showMessageDialog(rootPane, "Realice una consulta o presione \"Cancelar\" para salir", "Error de Consulta", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCancelarActionPerformed
    {//GEN-HEADEREND:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(CursadaConsulta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(CursadaConsulta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(CursadaConsulta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(CursadaConsulta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable()
            {
                public void run()
                {
                    new CursadaConsulta(null).setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonElegir;
    private javax.swing.JLabel jLabelAsignaturaC1;
    private javax.swing.JLabel jLabelAsignaturaC2;
    private javax.swing.JLabel jLabelDiaC1;
    private javax.swing.JLabel jLabelDiaC2;
    private javax.swing.JLabel jLabelHorarioC1;
    private javax.swing.JLabel jLabelHorarioC2;
    private javax.swing.JLabel jLabelIDC1;
    private javax.swing.JLabel jLabelIDC2;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombreC1;
    private javax.swing.JLabel jLabelNombreC2;
    private javax.swing.JLabel jLabelPeriodoC1;
    private javax.swing.JLabel jLabelPeriodoC2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

}
