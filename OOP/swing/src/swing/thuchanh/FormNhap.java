package swing.thuchanh;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.*;

public class FormNhap extends JPanel implements ActionListener {
    JTextField name,soTin;
    JLabel nameLabel, tinLabel,groupLabel,nameError, tinError;
    JComboBox<String> group;
    JButton save;
    private String nhomMon = "Cơ bản";
    public FormNhap() {
        createAndShow();
    }
    private void createAndShow(){
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(new Dimension(800,600));
        nameLabel = new JLabel("Tên môn học :");
        nameLabel.setSize(new Dimension(120,20));
        nameLabel.setBounds(20, 105, 200, 20);
        nameError = new JLabel("Tên môn học không được để trống !");
        nameError.setSize(new Dimension(120,20));
        nameError.setBounds(250, 130, 200, 20);
        nameError.setForeground(Color.RED);
        name = new JTextField();
        name.setSize(new Dimension(120,20));
        name.setBounds(20, 130, 200, 20);
        this.add(nameLabel);
        this.add(name);
        tinLabel = new JLabel("Số tín chỉ :");
        tinLabel.setSize(new Dimension(120,20));
        tinLabel.setBounds(20, 230, 200, 20);
        tinError = new JLabel("Số tín chỉ phải > 0 và < 7");
        tinError.setSize(new Dimension(120,20));
        tinError.setBounds(250, 250, 200, 20);
        tinError.setForeground(Color.RED);
        soTin = new JTextField();
        soTin.setSize(new Dimension(120,20));
        soTin.setBounds(20, 250, 200, 20);
        this.add(tinLabel);
        this.add(soTin);
        createComboBox();
        save = new JButton("Lưu file");
        save.setSize(new Dimension(120,20));
        save.setBounds(20, 290, 100, 30);
        save.addActionListener(this);
        this.add(save);
    }
    private void createComboBox(){
        groupLabel = new JLabel("Nhóm môn học :");
        groupLabel.setSize(new Dimension(120,20));
        groupLabel.setBounds(20, 170, 200, 20);
        group = new JComboBox<>();
        group.addItem("Cơ bản");
        group.addItem("Cơ sở ngành");
        group.addItem("Chuyên ngành");
        group.addItemListener(itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED)
                nhomMon = (String) itemEvent.getItem();
        });
        group.setSize(new Dimension(120,20));
        group.setBounds(20, 190, 200, 20);
        this.add(group);
        this.add(groupLabel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        if (command.equals("Lưu file")){
            String nameValue = name.getText();
            int tinChiValue = 0;
            if (!soTin.getText().isEmpty())
                tinChiValue = Integer.parseInt(soTin.getText());
            if (nameValue.isEmpty())
                this.add(nameError);
            else
                this.remove(nameError);
            if (tinChiValue<=0 || tinChiValue>=7)
                this.add(tinError);
            else
                this.remove(tinError);
            if ((tinChiValue>0 && tinChiValue<7) && !nameValue.isEmpty()){
                MonHoc monHoc = new MonHoc(nameValue,nhomMon,tinChiValue);
                try {
                    save(monHoc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.repaint();
        }
    }
    private void save(MonHoc monHoc) throws IOException {
        File file = new File("src/swing/thuchanh/MH.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println(monHoc.getMaMon());
        pw.println(monHoc.getTenMon());
        pw.println(monHoc.getNhomMon());
        pw.println(monHoc.getSoTinChi());
        pw.close();
        fos.close();
    }
}
