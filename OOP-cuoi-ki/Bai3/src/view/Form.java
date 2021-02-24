/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import exception.HandlerException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DuAn;
import model.NhanVien;
import model.PhanCong;

/**
 *
 * @author Huy Trường
 */
public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    private List<DuAn> listDa;
    private List<NhanVien> listNv;
    private List<PhanCong> listPc;
    DefaultTableModel daTbl,nvTbl,pcTbl;
    Controller controller;
    String pathDa = "src/file/DA.TXT",pathNv = "src/file/NV.TXT",pathPc = "src/file/PHANCONG.TXT";
    public Form() {
        initComponents();
        daTbl = (DefaultTableModel) duAnTBL.getModel();
        nvTbl = (DefaultTableModel) nhanVienTBL.getModel();
        pcTbl = (DefaultTableModel) phanCongTBL.getModel();
        controller = new Controller();
        listDa = controller.readFromFile(pathDa);
        if (!listDa.isEmpty())
            DuAn.id = listDa.get(listDa.size()-1).getMa()+1;
        listNv = controller.readFromFile(pathNv);
        if (!listNv.isEmpty())
            NhanVien.id = listNv.get(listNv.size()-1).getMa()+1;
        listPc = controller.readFromFile(pathPc);
        showData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        duAnTBL = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        nhanVienTBL = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        phanCongTBL = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        duAnTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Kiểu", "Kinh phí"
            }
        ));
        jScrollPane1.setViewportView(duAnTBL);
        if (duAnTBL.getColumnModel().getColumnCount() > 0) {
            duAnTBL.getColumnModel().getColumn(1).setHeaderValue("Tên dự án");
            duAnTBL.getColumnModel().getColumn(3).setHeaderValue("Tên nhân viên");
        }

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(0, 63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý dự án", jPanel1);

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nhanVienTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Địa chỉ", "Chuyên môn"
            }
        ));
        jScrollPane2.setViewportView(nhanVienTBL);
        if (nhanVienTBL.getColumnModel().getColumnCount() > 0) {
            nhanVienTBL.getColumnModel().getColumn(1).setHeaderValue("Tên dự án");
            nhanVienTBL.getColumnModel().getColumn(3).setHeaderValue("Tên nhân viên");
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(0, 63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý nhân viên", jPanel2);

        phanCongTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dự án", "Mã nhân viên", "Số ngày", "Vị trí"
            }
        ));
        jScrollPane3.setViewportView(phanCongTBL);

        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton3)
                .addGap(0, 63, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý phân công", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tìm kiếm", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FormDuAn(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new FormNhanVien(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new FormPhanCong(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void showData(){
        daTbl.setNumRows(0);
        nvTbl.setNumRows(0);
        pcTbl.setNumRows(0);
        for (DuAn item : listDa)
            daTbl.addRow(new Object[]{item.getMa(),item.getTen(),item.getKieu(),item.getTien()});
        for (NhanVien item : listNv)
            nvTbl.addRow(new Object[]{item.getMa(),item.getTen(),item.getDiaChi(),item.getChuyenMon()});
        for (PhanCong item : listPc)
            pcTbl.addRow(new Object[]{item.getDuAn().getMa(),item.getNhanVien().getMa(),item.getNgay(),item.getViTri()});
    }
    
    public void addDa(String ten , String kieu , String tien){
        String message = DuAn.checkFormat(ten, tien);
        
            try {
                if (!message.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, message);
                    throw new HandlerException(message);
                }
                listDa.add(new DuAn(ten, kieu, Integer.parseInt(tien)));
            try {
                controller.writeToFile(listDa, pathDa);
                showData();
            } catch (IOException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
            } catch (HandlerException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public void addNv(String ten , String diaChi , String chuyenMon ){
        String message = NhanVien.checkFormat(ten, diaChi,chuyenMon);
            try {
                if (!message.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, message);
                    throw new HandlerException(message);
                }
                listNv.add(new NhanVien(ten, diaChi, chuyenMon));
                controller.writeToFile(listNv, pathNv);
                showData();
            } catch (HandlerException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addPc(int codeDa , int codeNv , String ngay , String viTri ){
        String message = PhanCong.checkFormat(ngay);
            try {
                if (!message.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, message);
                    throw new HandlerException(message);
                }
                if (!controller.check(listPc,codeDa,codeNv,viTri))
                    listPc.add(new PhanCong(controller.getDa(listDa, codeDa), controller.getNv(listNv, codeNv), Integer.parseInt(ngay),viTri));
                else 
                    JOptionPane.showMessageDialog(rootPane, "1 người không thể tham gia 1 dự án cùng vị trí");
                controller.writeToFile(listPc, pathPc);
                showData();
            } catch (HandlerException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    public List<DuAn> getListDa() {
        return listDa;
    }

    public List<NhanVien> getListNv() {
        return listNv;
    }

    public List<PhanCong> getListPc() {
        return listPc;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable duAnTBL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable nhanVienTBL;
    private javax.swing.JTable phanCongTBL;
    // End of variables declaration//GEN-END:variables
}
