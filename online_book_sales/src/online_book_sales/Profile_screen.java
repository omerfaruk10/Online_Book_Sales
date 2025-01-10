package online_book_sales;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * @author Imer Faru
 */
public class Profile_screen extends javax.swing.JFrame {
    JFrame Screen;
    int kullaniciID;
    public Profile_screen(JFrame Screen, int kullaniciID) {
        this.Screen = Screen;
        this.kullaniciID = kullaniciID;
        initComponents();
        
        List list = new List();
        
        ArrayList<User> kullaniciListesi = list.getKullaniciBilgilerini(this.kullaniciID);
        if (kullaniciListesi.isEmpty()) {
            System.out.println("Kullanıcı bulunamadı.");
        } else {
            for (User kullanici : kullaniciListesi) {
                lblBosAd.setText(kullanici.getName());
                lblBosSoyad.setText(kullanici.getSurname());
                lblBosDogum.setText(kullanici.getBirthdate());
                lblBosCinsiyet.setText(kullanici.getSex());
                lblBosTel.setText(kullanici.getTel_no());
                lblBosEmail.setText(kullanici.getEmail());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCikis = new javax.swing.JButton();
        lblHosgeldin = new javax.swing.JLabel();
        btnGeri = new javax.swing.JButton();
        lblAd = new javax.swing.JLabel();
        lblSoyad = new javax.swing.JLabel();
        lblDogum = new javax.swing.JLabel();
        lblCinsiyet = new javax.swing.JLabel();
        lblBosTel = new javax.swing.JLabel();
        lblBosEmail = new javax.swing.JLabel();
        lblBosAd = new javax.swing.JLabel();
        lblBosSoyad = new javax.swing.JLabel();
        lblBosDogum = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        lblBosCinsiyet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 450));

        btnCikis.setBackground(new java.awt.Color(255, 51, 51));
        btnCikis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCikis.setForeground(new java.awt.Color(255, 255, 255));
        btnCikis.setText("Çıkış");
        btnCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisActionPerformed(evt);
            }
        });

        lblHosgeldin.setBackground(new java.awt.Color(204, 255, 255));
        lblHosgeldin.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblHosgeldin.setText("Profilim");
        lblHosgeldin.setPreferredSize(new java.awt.Dimension(150, 25));

        btnGeri.setBackground(new java.awt.Color(255, 51, 51));
        btnGeri.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGeri.setForeground(new java.awt.Color(255, 255, 255));
        btnGeri.setText("Geri");
        btnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriActionPerformed(evt);
            }
        });

        lblAd.setBackground(new java.awt.Color(204, 255, 255));
        lblAd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAd.setText("Ad:");

        lblSoyad.setBackground(new java.awt.Color(204, 255, 255));
        lblSoyad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSoyad.setText("Soyad:");
        lblSoyad.setMaximumSize(new java.awt.Dimension(74, 20));
        lblSoyad.setMinimumSize(new java.awt.Dimension(74, 20));

        lblDogum.setBackground(new java.awt.Color(204, 255, 255));
        lblDogum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDogum.setText("Doğum Tarihi:");

        lblCinsiyet.setBackground(new java.awt.Color(204, 255, 255));
        lblCinsiyet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCinsiyet.setText("Cinsiyet:");
        lblCinsiyet.setMaximumSize(new java.awt.Dimension(74, 20));
        lblCinsiyet.setMinimumSize(new java.awt.Dimension(74, 20));

        lblBosTel.setBackground(new java.awt.Color(204, 255, 255));
        lblBosTel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBosTel.setMaximumSize(new java.awt.Dimension(74, 20));
        lblBosTel.setMinimumSize(new java.awt.Dimension(74, 20));

        lblBosEmail.setBackground(new java.awt.Color(204, 255, 255));
        lblBosEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblBosAd.setBackground(new java.awt.Color(204, 255, 255));
        lblBosAd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblBosSoyad.setBackground(new java.awt.Color(204, 255, 255));
        lblBosSoyad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBosSoyad.setMaximumSize(new java.awt.Dimension(74, 20));
        lblBosSoyad.setMinimumSize(new java.awt.Dimension(74, 20));

        lblBosDogum.setBackground(new java.awt.Color(204, 255, 255));
        lblBosDogum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblEmail.setBackground(new java.awt.Color(204, 255, 255));
        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setText("Email:");

        lblTel.setBackground(new java.awt.Color(204, 255, 255));
        lblTel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTel.setText("Telefon No:");
        lblTel.setMaximumSize(new java.awt.Dimension(74, 20));
        lblTel.setMinimumSize(new java.awt.Dimension(74, 20));

        lblBosCinsiyet.setBackground(new java.awt.Color(204, 255, 255));
        lblBosCinsiyet.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblBosCinsiyet.setMaximumSize(new java.awt.Dimension(74, 20));
        lblBosCinsiyet.setMinimumSize(new java.awt.Dimension(74, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblHosgeldin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addComponent(btnGeri)
                .addGap(18, 18, 18)
                .addComponent(btnCikis)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblDogum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBosDogum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBosAd, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBosSoyad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCinsiyet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBosCinsiyet, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(lblBosTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBosEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHosgeldin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCikis)
                    .addComponent(btnGeri))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBosAd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBosCinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBosSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBosTel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDogum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBosDogum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBosEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(270, 270, 270))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
        // TODO add your handling code here:
        
        Log_in_screen log_in_screen = new Log_in_screen();
        log_in_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCikisActionPerformed

    private void btnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriActionPerformed
        // TODO add your handling code here:
        Screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGeriActionPerformed

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
            java.util.logging.Logger.getLogger(Profile_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnGeri;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAd;
    private javax.swing.JLabel lblBosAd;
    private javax.swing.JLabel lblBosCinsiyet;
    private javax.swing.JLabel lblBosDogum;
    private javax.swing.JLabel lblBosEmail;
    private javax.swing.JLabel lblBosSoyad;
    private javax.swing.JLabel lblBosTel;
    private javax.swing.JLabel lblCinsiyet;
    private javax.swing.JLabel lblDogum;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHosgeldin;
    private javax.swing.JLabel lblSoyad;
    private javax.swing.JLabel lblTel;
    // End of variables declaration//GEN-END:variables
}
