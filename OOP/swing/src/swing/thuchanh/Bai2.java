package swing.thuchanh;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai2 extends JFrame implements ActionListener {
    JPanel formNhap,formHienThi,formSapXep;
    JButton nhap,hienThi,sapXep;
    public Bai2() {
        createAndShow();
    }

    private void createAndShow(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setSize(800,600);
        nhap = new JButton("Thêm môn học");
        nhap.setSize(new Dimension(120,20));
        nhap.setBounds(20, 20, 200, 50);
        nhap.addActionListener(this);
        hienThi = new JButton("Hiển thị danh sách");
        hienThi.setSize(new Dimension(120,20));
        hienThi.setBounds(300, 20, 200, 50);
        hienThi.addActionListener(this);
        sapXep = new JButton("Sắp xếp");
        sapXep.setSize(new Dimension(120,20));
        sapXep.setBounds(580, 20, 200, 50);
        sapXep.addActionListener(this);
        this.add(nhap);
        this.add(hienThi);
        this.add(sapXep);
    }

    public static void main(String[] args) {
        new Bai2();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command){
            case "Thêm môn học":{
                if (formHienThi != null){
                    this.remove(formHienThi);
                    formHienThi = null;
                }
                if (formSapXep != null){
                    this.remove(formSapXep);
                    formSapXep = null;
                }
                if (formNhap == null){
                    formNhap = new FormNhap();
                    this.add(formNhap);
                }
            }
            break;
            case "Hiển thị danh sách":{
                if (formNhap != null){
                    this.remove(formNhap);
                    formNhap = null;
                }
                if (formSapXep != null){
                    this.remove(formSapXep);
                    formSapXep = null;
                }
                if (formHienThi == null){
                    formHienThi = new FormHienThi();
                    this.add(formHienThi);
                }
            }
            break;
            case "Sắp xếp":{
                if (formNhap != null){
                    this.remove(formNhap);
                    formNhap = null;
                }
                if (formHienThi != null){
                    this.remove(formHienThi);
                    formHienThi = null;
                }
                if (formSapXep == null){
                    formSapXep = new FormSapXep();
                    this.add(formSapXep);
                }
            }
            break;
        }
        this.repaint();
    }
}
