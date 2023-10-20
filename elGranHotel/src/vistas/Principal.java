/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import data.Conexion;
import data.Habitacion_data;
import data.Reserva_data;
import entidades.ReservaHuesped;
import entidades.Habitacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

//import java.util.Calendar;
//import java.util.GregorianCalendar;
/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private Conexion con = new Conexion("jdbc:mariadb://localhost:3306/elgranhotel", "root", "");
    private Habitacion_data hd = new Habitacion_data(con);
    private Reserva_data rd = new Reserva_data(con);

    public Principal() {
        initComponents();
        actualizarReservas();
        this.setLocationRelativeTo(this);
        this.setExtendedState(Principal.MAXIMIZED_BOTH);
        /*
        new Thread() { // RELOJ TIEMPO REAL (Consume mucho)

            public void run() {                

                while (true) {
                    Calendar cal = new GregorianCalendar();
                    int anio = cal.get(Calendar.YEAR);
                    int mes = cal.get(Calendar.MONTH);
                    int dia = cal.get(Calendar.DAY_OF_MONTH);
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);

                    int AM_PM = cal.get(Calendar.AM_PM);
                    String Am_Pm = "";
                    if (AM_PM == 1) {

                        Am_Pm = "PM";
                    } else {
                        Am_Pm = "AM";
                    }
                    setTitle("El Gran Hotel " + anio + "-" + mes + "-" + dia + "-" + hour + ":" + min + ":" + sec + " " + Am_Pm);
                }
            }
        }.start();
         */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/texturaHormigon.jpg")); Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmGestionHab = new javax.swing.JMenuItem();
        jReservas = new javax.swing.JMenu();
        jmReservas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("El gran hotel" + LocalDate.now().toString()
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 902, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jMenu1.setText("Huespedes");
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItem1.setText("Gestión Huespedes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Habitaciones");
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmGestionHab.setText("Gestión Habitaciones");
        jmGestionHab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionHabActionPerformed(evt);
            }
        });
        jMenu2.add(jmGestionHab);

        jMenuBar1.add(jMenu2);

        jReservas.setText("Reservas");
        jReservas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jmReservas.setText("Gestión Reservas");
        jmReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReservasActionPerformed(evt);
            }
        });
        jReservas.add(jmReservas);

        jMenuBar1.add(jReservas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmGestionHabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionHabActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        Habitacion_vista hab = new Habitacion_vista();
        hab.setVisible(true);
        escritorio.add(hab);
        escritorio.moveToFront(hab);
        hab.setLocation((escritorio.getWidth() - hab.getWidth()) / 2, (escritorio.getHeight() - hab.getHeight()) / 2);
    }//GEN-LAST:event_jmGestionHabActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        Huesped_vista h = new Huesped_vista();
        h.setVisible(true);
        escritorio.add(h);
        escritorio.moveToFront(h);
        h.setLocation((escritorio.getWidth() - h.getWidth()) / 2, (escritorio.getHeight() - h.getHeight()) / 2);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReservasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        Reserva_Vista rv = new Reserva_Vista();
        rv.setVisible(true);
        escritorio.add(rv);
        escritorio.moveToFront(rv);
        rv.setLocation((escritorio.getWidth() - rv.getWidth()) / 2, (escritorio.getHeight() - rv.getHeight()) / 2);
    }//GEN-LAST:event_jmReservasActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jReservas;
    private javax.swing.JMenuItem jmGestionHab;
    private javax.swing.JMenuItem jmReservas;
    // End of variables declaration//GEN-END:variables

    private void actualizarReservas() { //Cambia a "ocupadas" las habitaciones con reserva del dia
        List<ReservaHuesped> listareserva = new ArrayList<>();
        List<Habitacion> listahab = new ArrayList<>();

        listahab = hd.listarHabitaciones();
        listareserva = rd.buscarReservasXfecha(LocalDate.now(), LocalDate.now());

        rd.finReserva();

        for (Habitacion hab : listahab) {
            hd.modificarDisponibilidad(hab.getNroHabitacion(), hab.getPiso(), false);
        }

        for (ReservaHuesped reserva : listareserva) {
            hd.modificarDisponibilidad(reserva.getIdHabitacion().getNroHabitacion(), reserva.getIdHabitacion().getPiso(), true);
        }

    }

}
