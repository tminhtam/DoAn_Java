
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TranMinhTam
 */
public class JavaMain extends javax.swing.JFrame {

    /**
     * Creates new form JavaMain
     */
    public JavaMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        taiDanhSach();
    }
    
    void taiDanhSach()
    {
         String[] columnNames = {"Mã nhân viên", "Tên nhân viên", "Năm sinh", "Tên chức vụ", "Hệ số lương", "Hệ số phụ cấp"};
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///db_java","root", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM nv";
            ResultSet rs = stmt.executeQuery(sql);
            
            int rowCount=0,i=0;
            
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
            }

            Object[][]data=new Object[rowCount][];

            while (rs.next()) {

                    data[i]=new Object[6];

                    data[i][0]=rs.getString("manv");
                    data[i][1]=rs.getString("tennv");
                    data[i][2]=rs.getString("ngaysinh");
                    data[i][3]=rs.getString("ten_chucvu");
                    data[i][4]=rs.getString("hesoluong");
                    data[i][5]=rs.getString("hesophucap");

                    i++;
            }

            DefaultTableModel model=new DefaultTableModel(data,columnNames);
                jTable1.setModel(model);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    void TimKiem()
    {
         String[] columnNames = {"Mã nhân viên", "Tên nhân viên", "Năm sinh", "Tên chức vụ", "Hệ số lương", "Hệ số phụ cấp"};
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///db_java","root", "");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM nv where manv = '" + txbTimKiem.getText()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            int rowCount=0,i=0;
            
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
            }

            Object[][]data=new Object[rowCount][];

            while (rs.next()) {

                    data[i]=new Object[6];

                    data[i][0]=rs.getString("manv");
                    data[i][1]=rs.getString("tennv");
                    data[i][2]=rs.getString("ngaysinh");
                    data[i][3]=rs.getString("ten_chucvu");
                    data[i][4]=rs.getString("hesoluong");
                    data[i][5]=rs.getString("hesophucap");

                    i++;
            }

            DefaultTableModel model=new DefaultTableModel(data,columnNames);
                jTable1.setModel(model);
            } catch (SQLException e) {
                e.printStackTrace();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txbMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txbTenNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txbNamSinh = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txbChucVu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txbHeSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txbHeSoPhuCap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txbTimKiem = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lập trình java [chủ đề 5] - nhóm 1");
        setBackground(new java.awt.Color(44, 62, 80));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã nhân viên");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên nhân viên");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Năm sinh");

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xem danh sách lương");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa1.setText("Xóa");
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Chức vụ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hệ số lương");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hệ số phụ cấp");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tìm kiếm");

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txbNamSinh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txbTenNV)
                            .addComponent(txbMaNV)
                            .addComponent(txbChucVu)
                            .addComponent(txbHeSoLuong)
                            .addComponent(txbHeSoPhuCap)
                            .addComponent(txbTimKiem)))
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txbTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txbNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txbHeSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txbHeSoPhuCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Năm sinh", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private java.util.Date parseDate(String date, String format) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(date);
    }
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
         Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql:///db_java","root", "");
           
            PreparedStatement insertNV = null;
            
            con.setAutoCommit(false);
            
            String insertString ="INSERT INTO nv VALUES (?, ?, ?, ?, ?, ?, ?)";
            insertNV = con.prepareStatement(insertString);

           
            insertNV.setString(1, txbMaNV.getText());            
            insertNV.setString(2, txbTenNV.getText());
            
            try {
                insertNV.setDate(3, new Date(parseDate(txbNamSinh.getText(), "dd/MM/yyyy").getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(JavaMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            float he_so_luong = Float.parseFloat(txbHeSoLuong.getText());
            float he_so_phu_cap = Float.parseFloat(txbHeSoPhuCap.getText());
            
            insertNV.setString(4, txbChucVu.getText());
            insertNV.setFloat(5, he_so_luong);
            insertNV.setFloat(6, he_so_phu_cap);
            
            float tongtien = (1050000 * (he_so_luong + he_so_phu_cap));
            
            insertNV.setFloat(7, tongtien);

            if(insertNV.executeUpdate()>0)
            {
                System.out.println("Thêm nhân viên thành công\n");
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
            }            
            else
                System.out.println("Không thêm được nhân viên\n");

            con.commit();
            con.close();
            taiDanhSach();
                                        
        } catch (SQLException ex) 
        {
            Logger.getLogger(JavaMain.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (ParseException ex) 
//        {
//            Logger.getLogger(JavaMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///db_java","root", "");
            Statement stmt = con.createStatement();
            stmt.executeQuery("SET NAMES 'UTF8'");
            stmt.executeQuery("SET CHARACTER SET 'UTF8'");
					
            PreparedStatement deleteSV = null;
            String deleteString ="DELETE FROM nv WHERE manv=?";
            //String updateString ="update sinhvien set hoten=?, ngaysinh=?,diachi=?,dienthoai=? where mssv=?";
            deleteSV = con.prepareStatement(deleteString);
            //updateSV = con.prepareStatement(updateString);
            deleteSV.setString(1,txbMaNV.getText() );
            if(deleteSV.executeUpdate()>0)
            {
                System.out.println("Xóa nhân viên thành công\n");
                JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công");
            }
            else
                System.out.println("Không tìm thấy sinh viên sinh viên\n");
		
            taiDanhSach();
	} 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
	} 
        catch (SQLException e) 
        {
            e.printStackTrace();
	} 
//        catch (IOException e) 
//        {
//            e.printStackTrace();
//	}
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///db_java","root", "");
            Statement stmt = con.createStatement();
            stmt.executeQuery("SET NAMES 'UTF8'");
            stmt.executeQuery("SET CHARACTER SET 'UTF8'");
				    
            PreparedStatement updateSV = null;
            con.setAutoCommit(false);
            String updateString ="update nv set tennv=?, ngaysinh=?, ten_chucvu=?, hesoluong=?, hesophucap=? where manv=?";
            updateSV = con.prepareStatement(updateString);
            
            updateSV.setString(1,txbTenNV.getText());
            try {
                updateSV.setDate(2, new Date(parseDate(txbNamSinh.getText(), "dd/MM/yyyy").getTime()));
            } catch (ParseException ex) {
                Logger.getLogger(JavaMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            updateSV.setString(3,txbMaNV.getText());
            updateSV.setString(4, txbChucVu.getText());
            float he_so_luong = Float.parseFloat(txbHeSoLuong.getText());
            float he_so_phu_cap = Float.parseFloat(txbHeSoPhuCap.getText());
            updateSV.setFloat(5, he_so_luong);
            updateSV.setFloat(6, he_so_phu_cap);
            
            float tongtien = (1050000 * (he_so_luong + he_so_phu_cap));
            updateSV.setFloat(7, tongtien);
            //sua
            
            if(updateSV.executeUpdate()>0)
            {
                System.out.println("Sửa nhân viên thành công");
                JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
            }
            else
            {
                System.out.println("Sửa nhân viên thất bại");
                JOptionPane.showMessageDialog(this, "Sửa nhân viên thất bại");
            }
					
            con.commit();
            con.close();
            taiDanhSach();
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
//        catch (ParseException e) {
//            e.printStackTrace();
//        } 
//        catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } 
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
       frm_DanhSachLuong rgf = new frm_DanhSachLuong();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        TimKiem();
    }//GEN-LAST:event_btnTimActionPerformed

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
            java.util.logging.Logger.getLogger(JavaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txbChucVu;
    private javax.swing.JTextField txbHeSoLuong;
    private javax.swing.JTextField txbHeSoPhuCap;
    private javax.swing.JTextField txbMaNV;
    private javax.swing.JTextField txbNamSinh;
    private javax.swing.JTextField txbTenNV;
    private javax.swing.JTextField txbTimKiem;
    // End of variables declaration//GEN-END:variables
}