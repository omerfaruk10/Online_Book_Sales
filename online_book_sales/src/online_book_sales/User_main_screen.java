package online_book_sales;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableRowSorter;

/**
 * Kullanıcı Ana Ekranı
 */
public class User_main_screen extends javax.swing.JFrame {
    private String user_name;
    private int kullaniciID;
    private DefaultTableModel defaultTableModel;

    public User_main_screen(String user_name) throws SQLException {
        initComponents();
        this.user_name = user_name;
        defaultTableModel = (DefaultTableModel) tblKitaplar.getModel();
        kitaplariListele();
        kullaniciID = kullaniciIDGetir(user_name);
    }

    public void kitaplariListele() {
        List kitapListesi = new List();
        try {
            ArrayList<Kitap> kitaplar = kitapListesi.getKitaplar();
            int sayac = 1;
            for (Kitap kitap : kitaplar) {
                Object[] row = {sayac, kitap.getKitapAdi(), kitap.getYazarAdi() + " " + kitap.getYazarSoyadi(),
                        kitap.getTur(), kitap.getFiyat(), kitap.getSayfaSayisi(), kitap.getSaticiID()};
                defaultTableModel.addRow(row);
                sayac++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void kitapEkle() {
    try {

        int selectedRow = tblKitaplar.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Lütfen bir kitap seçin.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String kitapAdi = (String) tblKitaplar.getValueAt(selectedRow, 1);
        float fiyat = Float.parseFloat(tblKitaplar.getValueAt(selectedRow, 4).toString());
        int kitapID = kitapIDGetir(kitapAdi);

        int siparisID = aktifSiparisIDGetir(kullaniciID);
        if (siparisID == -1) {
            siparisID = yeniSiparisOlustur(kullaniciID);
        }

        siparisDetayEkle(siparisID, kitapID, fiyat);
        siparisGuncelle(siparisID, fiyat);

        JOptionPane.showMessageDialog(this, 
            "Kitap başarıyla sepete eklendi: \nKitap Adı: " + kitapAdi + "\nFiyat: " + fiyat + " TL", 
            "Başarılı", 
            JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Bir hata oluştu: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}


    public int kullaniciIDGetir(String kullaniciAdı) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        String sql = "SELECT KullanıcıID FROM kitap.kullanıcılar WHERE KullanıcıAdı = ?";
        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, kullaniciAdı);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("KullanıcıID");
            }
        } finally {
            if (connection != null) connection.close();
        }
        return -1; 
    }

    public int kitapIDGetir(String kitapAdi) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        String sql = "SELECT KitapID FROM kitap.kitaplar WHERE KitapAdı = ?";
        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, kitapAdi);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("KitapID");
            }
        } finally {
            if (connection != null) connection.close();
        }
        return -1;
    }

    public int aktifSiparisIDGetir(int kullaniciID) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        String sql = "SELECT SiparisID FROM siparisler WHERE KullanıcıID = ? AND Completed = 0";
        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, kullaniciID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("SiparisID");
            }
        } finally {
            if (connection != null) connection.close();
        }
        return -1;
    }

    public int yeniSiparisOlustur(int kullaniciID) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        String sql = "INSERT INTO kitap.siparisler (KullanıcıID, ToplamUrunAdedi, ToplamTutar, SiparisTarihi, Completed) VALUES (?, ?, ?, ?, 0)";
        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, kullaniciID);
            statement.setInt(2, 0);
            statement.setFloat(3, 0);
            statement.setDate(4, new java.sql.Date(new Date().getTime()));
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } finally {
            if (connection != null) connection.close();
        }
        return -1;
    }

    public void siparisDetayEkle(int siparisID, int kitapID, float fiyat) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        String sql = "INSERT INTO siparisdetay (SiparisID, KitapID, Adet, Fiyat, ToplamFiyat) VALUES (?, ?, ?, ?, ?)";
        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, siparisID);
            statement.setInt(2, kitapID);
            statement.setInt(3, 1);
            statement.setFloat(4, fiyat);
            statement.setFloat(5, fiyat);
            statement.executeUpdate();
        } finally {
            if (connection != null) connection.close();
        }
    }

    public void siparisGuncelle(int siparisID, float fiyat) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        String sql = "UPDATE siparisler SET ToplamUrunAdedi = ToplamUrunAdedi + 1, ToplamTutar = ToplamTutar + ? WHERE SiparisID = ?";
        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1, fiyat);
            statement.setInt(2, siparisID);
            statement.executeUpdate();
        } finally {
            if (connection != null) connection.close();
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
    
    public void updateNumbers() {
        for (int i = 0; i < tblKitaplar.getRowCount(); i++) {
            tblKitaplar.setValueAt(i + 1, i, 0);
        }
    }       
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKitaplar = new javax.swing.JTable();
        btnAyiıntilar = new javax.swing.JButton();
        btnCikis = new javax.swing.JButton();
        btnProfil = new javax.swing.JButton();
        btnSepeteEkle = new javax.swing.JButton();
        btnSepeteGit = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblWord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 450));

        tblKitaplar.setBackground(new java.awt.Color(204, 255, 255));
        tblKitaplar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblKitaplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Kitap Adı", "Yazar Adı", "Tür", "Fiyat", "Sayfa Sayısı", "SatıcıID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        btnProfil.setBackground(new java.awt.Color(0, 153, 0));
        btnProfil.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnProfil.setForeground(new java.awt.Color(255, 255, 255));
        btnProfil.setText("Profil");
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });

        btnSepeteEkle.setBackground(new java.awt.Color(0, 153, 0));
        btnSepeteEkle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSepeteEkle.setForeground(new java.awt.Color(255, 255, 255));
        btnSepeteEkle.setText("Sepete Ekle");
        btnSepeteEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSepeteEkleActionPerformed(evt);
            }
        });

        btnSepeteGit.setBackground(new java.awt.Color(0, 153, 0));
        btnSepeteGit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSepeteGit.setForeground(new java.awt.Color(255, 255, 255));
        btnSepeteGit.setText("Sepete Git");
        btnSepeteGit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSepeteGitActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblWord.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblWord.setText("Kitap Adı:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProfil)
                        .addGap(88, 88, 88)
                        .addComponent(lblWord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCikis))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAyiıntilar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSepeteEkle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSepeteGit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCikis)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblWord, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProfil))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAyiıntilar)
                    .addComponent(btnSepeteEkle)
                    .addComponent(btnSepeteGit))
                .addGap(30, 30, 30))
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

    private void btnSepeteGitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSepeteGitActionPerformed
        // TODO add your handling code here:
        try {
            User_main_screen user_main_screen = null;
            try {
                user_main_screen = new User_main_screen(this.user_name);
            } catch (SQLException ex) {
                Logger.getLogger(User_main_screen.class.getName()).log(Level.SEVERE, null, ex);
            }
            Card_screen card_screen = new Card_screen(user_main_screen, this.kullaniciID);
            card_screen.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(User_main_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSepeteGitActionPerformed

    private void btnSepeteEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSepeteEkleActionPerformed
        kitapEkle();
    }//GEN-LAST:event_btnSepeteEkleActionPerformed

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
        // TODO add your handling code here:
        User_main_screen user_main_screen = null;
        try {
            user_main_screen = new User_main_screen(user_name);
        } catch (SQLException ex) {
            Logger.getLogger(User_main_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        Profile_screen profile_screen = new Profile_screen(user_main_screen, this.kullaniciID);
        profile_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProfilActionPerformed

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
        // TODO add your handling code here:  
        Log_in_screen log_in_screen = new Log_in_screen();
        log_in_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCikisActionPerformed

    private void btnAyiıntilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyiıntilarActionPerformed
        // TODO add your handling code here:
        try {
            int kitapID = -1;
            int selectedRow = tblKitaplar.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Lütfen bir ürün seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String kitapAdi = (String) tblKitaplar.getValueAt(selectedRow, 1);
            int saticiID = (int) tblKitaplar.getValueAt(selectedRow, 6);   
            
            try {
                kitapID = getKitapID(kitapAdi, saticiID);
                
                if (kitapID == -1) {
                    JOptionPane.showMessageDialog(this, "Eşleşen bir KitapID bulunamadı!", "Bilgi", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(this, "Bir hata oluştu: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            }
            
            User_main_screen user_main_screen;
            user_main_screen = new User_main_screen(user_name);
            Details_screen details_screen = new Details_screen(user_main_screen, kitapID);
            details_screen.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(User_main_screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAyiıntilarActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(defaultTableModel);
        tblKitaplar.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + searchKey, 1));
        updateNumbers();
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(User_main_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_main_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_main_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_main_screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton btnSepeteEkle;
    private javax.swing.JButton btnSepeteGit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWord;
    private javax.swing.JTable tblKitaplar;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
