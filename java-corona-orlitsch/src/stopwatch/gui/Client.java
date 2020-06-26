/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch.gui;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import javax.swing.JOptionPane;
import stopwatch.Server.Response;

/**
 *
 * @author USER
 */
public class Client extends javax.swing.JFrame {

    private boolean tryToStart;
    private boolean tryToStop;
    private boolean tryToClear;
    private boolean tryToEnd;

    /**
     * Creates new form Client
     */
    public Client() {

        initComponents();
        jBClear.setVisible(false);
        jBDisconnect.setVisible(false);
        jBEnd.setVisible(false);
        jBStart.setVisible(false);
        jBStop.setVisible(false);
        jBConnect.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jBConnect = new javax.swing.JButton();
        jBDisconnect = new javax.swing.JButton();
        jBStart = new javax.swing.JButton();
        jBStop = new javax.swing.JButton();
        jBClear = new javax.swing.JButton();
        jBEnd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jBConnect.setText("Connect");
        jBConnect.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBConnect.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jBConnect, gridBagConstraints);

        jBDisconnect.setText("Disconnect");
        jBDisconnect.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDisconnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jBDisconnect, gridBagConstraints);

        jBStart.setText("Start");
        jBStart.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jBStart, gridBagConstraints);

        jBStop.setText("Stop");
        jBStop.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStopActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jBStop, gridBagConstraints);

        jBClear.setText("Clear");
        jBClear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jBClear, gridBagConstraints);

        jBEnd.setText("End");
        jBEnd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEndActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 2, 5, 2);
        jPanel1.add(jBEnd, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.EAST);

        jLabel1.setText("Refreshrate: 1s");
        jPanel2.add(jLabel1);

        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.setName(""); // NOI18N
        jSlider1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jSlider1MouseWheelMoved(evt);
            }
        });
        jPanel2.add(jSlider1);

        jLabel2.setText("1ms");
        jPanel2.add(jLabel2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Source Sans Pro Black", 0, 100)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("0.000");
        jPanel3.add(jLabel3, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConnectActionPerformed
        try {
            System.out.println("Button pressed" + Thread.currentThread().getId());
            ConnectionWorker worker = new MyConnectionWorker(8080, "127.0.0.1");
            worker.execute();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Verbindung Fehlgeschlagen!");
        }
    }//GEN-LAST:event_jBConnectActionPerformed

    private void jSlider1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jSlider1MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jSlider1MouseWheelMoved

    private void jBDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDisconnectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBDisconnectActionPerformed

    private void jBStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStartActionPerformed
        tryToStart = true;
    }//GEN-LAST:event_jBStartActionPerformed

    private void jBStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStopActionPerformed
        tryToStop = true;
    }//GEN-LAST:event_jBStopActionPerformed

    private void jBClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClearActionPerformed
        tryToClear = true;
    }//GEN-LAST:event_jBClearActionPerformed

    private void jBEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEndActionPerformed
        tryToEnd = true;
    }//GEN-LAST:event_jBEndActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    private class MyConnectionWorker extends ConnectionWorker {

        private Socket socket;

        public MyConnectionWorker(int port, String host) throws IOException {
            socket = new Socket(host, port);
        }

        @Override
        protected void done() {

            try {
                String ergebnis = get();
                System.out.println(ergebnis + " " + Thread.currentThread().getId());
                jLabel3.setText(ergebnis);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Client.this, "Fehler beim Beenden", "Fahler", JOptionPane.ERROR_MESSAGE);
            }

        }

        @Override
        protected void process(List<Response> list) {
            Response resp = list.get(0);

            for (Response r : list) {
                if (r.isMaster()) {
                    jBClear.setVisible(true);
                    jBDisconnect.setVisible(true);
                    jBEnd.setVisible(true);
                    jBStart.setVisible(true);
                    jBStop.setVisible(true);
                    jBConnect.setVisible(false);
                } else {
                    jBClear.setVisible(false);
                    jBDisconnect.setVisible(true);
                    jBEnd.setVisible(false);
                    jBStart.setVisible(false);
                    jBStop.setVisible(false);
                    jBConnect.setVisible(false);
                }

                if (r.isRunning()) {
                    jBClear.setVisible(true);
                    jBStart.setVisible(false);
                    jBStop.setVisible(true);
                } else {
                    jBClear.setVisible(false);
                    jBStart.setVisible(true);
                    jBStop.setVisible(false);
                }

//            for(int x : chunks){
//                System.out.println("Process " + x + " Thread " + Thread.currentThread().getId());
            }

            if (resp.isRunning()) {
                jLabel3.setText(String.format("%.3f", resp.getTime()));
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBClear;
    private javax.swing.JButton jBConnect;
    private javax.swing.JButton jBDisconnect;
    private javax.swing.JButton jBEnd;
    private javax.swing.JButton jBStart;
    private javax.swing.JButton jBStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
