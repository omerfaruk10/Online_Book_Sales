package online_book_sales;

import javax.swing.JFrame;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Card_screen extends javax.swing.JFrame {
    private final JFrame screen;
    private final int kullaniciID;
    private int siparisID;
    private DefaultTableModel defaultTableModel;

    public Card_screen(JFrame screen, int kullaniciID) throws SQLException {
        
        initComponents();
        this.screen = screen;
        this.kullaniciID = kullaniciID;
        this.siparisID = getIncompleteSiparisID();
        this.defaultTableModel = (DefaultTableModel) tblKitaplar.getModel();

        List list = new List();
        ArrayList<Siparis_SiparisDetay_Kitap_Yazar> detaylar = list.getUrunlar(this.siparisID);
        if (detaylar.isEmpty()) {
            System.out.println("Kullanıcı bulunamadı.");
        } else {
            kitaplariListele(detaylar);
        }
    }

    private int getIncompleteSiparisID() throws SQLException {
        DbHelper dbHelper = new DbHelper();
        try (Connection connection = dbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT siparisID FROM siparisler WHERE kullanıcıID = ? AND completed = 0")) {
            preparedStatement.setInt(1, this.kullaniciID);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next() ? resultSet.getInt("siparisID") : -1;
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
            throw exception;
        }
    }

    public void kitaplariListele(ArrayList<Siparis_SiparisDetay_Kitap_Yazar> detaylar) {
        List kitapListesi = new List();
        int sayac = 1;
        for (Siparis_SiparisDetay_Kitap_Yazar detay : detaylar) {
            Object[] row = {sayac,
                detay.getDetayID(),
                detay.getKitapAdi(),
                detay.getYazarAdi() + " " + detay.getYazarSoyadi(),
                detay.getTur(),
                detay.getFiyat(),
                detay.getSayfaSayisi(),
                detay.getStaiciID()};
            defaultTableModel.addRow(row);
            sayac++;
        }
    }

    public int getKitapID(String kitapAdi, int saticiID) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int kitapID = -1;

        try {
            connection = dbHelper.getConnection();

            String sql = "SELECT KitapID FROM kitap.kitaplar "
                       + "WHERE KitapAdı = ? AND SaticiID = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, kitapAdi);
            preparedStatement.setInt(2, saticiID);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                kitapID = resultSet.getInt("KitapID");
            }
        } catch (SQLException exception) {
            dbHelper.showErrorMessage(exception);
        } finally {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }

        return kitapID;
    }
    
        private void tabloyuGuncelle() {
    }

    public void updateNumbers() {
        for (int i = 0; i < tblKitaplar.getRowCount(); i++) {
            tblKitaplar.setValueAt(i + 1, i, 0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKitaplar = new javax.swing.JTable();
        btnAyiıntilar = new javax.swing.JButton();
        btnCikis = new javax.swing.JButton();
        lblHosgeldin = new javax.swing.JLabel();
        btnProfil = new javax.swing.JButton();
        btnUrunuSil = new javax.swing.JButton();
        btnSepeteGit = new javax.swing.JButton();
        btnGeri = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 450));

        tblKitaplar.setBackground(new java.awt.Color(204, 255, 255));
        tblKitaplar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblKitaplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "DetayID", "Kitap Adı", "Yazar Adı", "Tür", "Fiyat", "Sayfa Sayısı", "SatıcıID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKitaplar.setRowHeight(30);
        jScrollPane1.setViewportView(tblKitaplar);

        btnAyiıntilar.setBackground(new java.awt.Color(0, 153, 0));
        btnAyiıntilar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAyiıntilar.setForeground(new java.awt.Color(255, 255, 255));
        btnAyiıntilar.setText("Ayrıntılar");
        btnAyiıntilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyiıntilarActionPerformed(evt);
            }
        });

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
        lblHosgeldin.setText("Sepetim");
        lblHosgeldin.setPreferredSize(new java.awt.Dimension(150, 25));

        btnProfil.setBackground(new java.awt.Color(0, 153, 0));
        btnProfil.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProfil.setForeground(new java.awt.Color(255, 255, 255));
        btnProfil.setText("Profil");
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });

        btnUrunuSil.setBackground(new java.awt.Color(0, 153, 0));
        btnUrunuSil.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUrunuSil.setForeground(new java.awt.Color(255, 255, 255));
        btnUrunuSil.setText("Ürünü Sil");
        btnUrunuSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunuSilActionPerformed(evt);
            }
        });

        btnSepeteGit.setBackground(new java.awt.Color(0, 153, 0));
        btnSepeteGit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSepeteGit.setForeground(new java.awt.Color(255, 255, 255));
        btnSepeteGit.setText("Siparisi Tamamla");
        btnSepeteGit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSepeteGitActionPerformed(evt);
            }
        });

        btnGeri.setBackground(new java.awt.Color(255, 51, 51));
        btnGeri.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGeri.setForeground(new java.awt.Color(255, 255, 255));
        btnGeri.setText("Geri");
        btnGeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProfil)
                        .addGap(300, 300, 300)
                        .addComponent(lblHosgeldin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGeri)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCikis)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUrunuSil)
                                .addGap(18, 18, 18)
                                .addComponent(btnAyiıntilar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSepeteGit)))
                        .addGap(30, 30, 30))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCikis)
                        .addComponent(btnGeri))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHosgeldin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfil))))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUrunuSil)
                    .addComponent(btnAyiıntilar)
                    .addComponent(btnSepeteGit))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 999, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAyiıntilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyiıntilarActionPerformed
        // TODO add your handling code here:
        try {                                    
            int kitapID = -1;
            int selectedRow = tblKitaplar.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Lütfen bir ürün seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String kitapAdi = (String) tblKitaplar.getValueAt(selectedRow, 2);
            int saticiID = (int) tblKitaplar.getValueAt(selectedRow, 7);
            
            try {
                kitapID = getKitapID(kitapAdi, saticiID);
                
                if (kitapID == -1) {
                    JOptionPane.showMessageDialog(this, "Eşleşen bir KitapID bulunamadı!", "Bilgi", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(this, "Bir hata oluştu: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            }
            
            Card_screen card_screen;
            card_screen = new Card_screen(screen, kullaniciID);
            Details_screen details_screen = new Details_screen(card_screen, kitapID);
            details_screen.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(User_main_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAyiıntilarActionPerformed

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
        // TODO add your handling code here:
        
        Log_in_screen log_in_screen = new Log_in_screen();
        log_in_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCikisActionPerformed

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        // TODO add your handling code here:
        Card_screen card_screen = null;
        try {
            card_screen = new Card_screen(screen, kullaniciID);
        } catch (SQLException ex) {
            Logger.getLogger(User_main_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        Profile_screen profile_screen = new Profile_screen(card_screen, this.kullaniciID);
        profile_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProfilActionPerformed

    private void btnUrunuSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunuSilActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblKitaplar.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen silmek için bir ürün seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int detayID = (int) defaultTableModel.getValueAt(selectedRow, 1); // İlk sütundaki değer (örneğin, DetayID)

        try {
            DbHelper dbHelper = new DbHelper();
            try (Connection connection = dbHelper.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM kitap.siparisdetay WHERE DetayID = ?")) {

                preparedStatement.setInt(1, detayID);
                int result = preparedStatement.executeUpdate();
                
                if (result > 0) {
                    defaultTableModel.removeRow(selectedRow);
                    updateNumbers();
                    JOptionPane.showMessageDialog(this, "Ürün başarıyla silindi!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Ürün silinemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            
            }
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(this, "Bir hata oluştu: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
        }
    }//GEN-LAST:event_btnUrunuSilActionPerformed

    private void btnSepeteGitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSepeteGitActionPerformed
        // TODO add your handling code here:
        String sql = "UPDATE kitap.siparisler SET Completed = 1 WHERE SiparisID = ?";
        
        DbHelper dbHelper = new DbHelper();
        
        try {
            dbHelper.executeUpdate(sql, siparisID);
        } catch (SQLException ex) {
            Logger.getLogger(Card_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Sipariş başarıyla tamamlandı!");
    
    }//GEN-LAST:event_btnSepeteGitActionPerformed

    private void btnGeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeriActionPerformed
        // TODO add your handling code here:
        screen.setVisible(true);
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
            java.util.logging.Logger.getLogger(Card_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Card_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Card_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Card_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyiıntilar;
    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnGeri;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton btnSepeteGit;
    private javax.swing.JButton btnUrunuSil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHosgeldin;
    private javax.swing.JTable tblKitaplar;
    // End of variables declaration//GEN-END:variables
}
