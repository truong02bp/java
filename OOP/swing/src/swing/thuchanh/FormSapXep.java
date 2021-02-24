package swing.thuchanh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormSapXep extends JPanel {
    JTable subjects;
    JLabel groupLabel;
    JComboBox<String> group;
    private String nhomMon = "Cơ bản";
    JScrollPane sp;
    public FormSapXep() {
        try {
            createAndShow();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createAndShow() throws FileNotFoundException {
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(new Dimension(800,600));
        groupLabel = new JLabel("Nhóm môn học :");
        groupLabel.setSize(new Dimension(120,20));
        groupLabel.setBounds(20, 70, 200, 20);
        group = new JComboBox<>();
        group.addItem("Cơ bản");
        group.addItem("Cơ sở ngành");
        group.addItem("Chuyên ngành");
        group.addItemListener(itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED){
                nhomMon = (String) itemEvent.getItem();
                try {
                    showList();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        group.setSize(new Dimension(120,20));
        group.setBounds(20, 100, 200, 20);
        this.add(group);
        this.add(groupLabel);
        showList();
    }

    private void showList() throws FileNotFoundException {
        List<MonHoc> list = getSubjectsFromFile();
        list.sort((m1, m2) -> m2.getSoTinChi()-m1.getSoTinChi());
        String[] columns = {"Mã môn học","Tên môn học","Nhóm môn học","Số tín chỉ"};
        String[][] data = new String[list.size()][4];
        for (int i=0;i<list.size();i++){
            data[i][0] = String.valueOf(list.get(i).getMaMon());
            data[i][1] = list.get(i).getTenMon();
            data[i][2] = list.get(i).getNhomMon();
            data[i][3] = String.valueOf(list.get(i).getSoTinChi());
        }
        subjects = new JTable(data,columns);
        if (sp != null)
            this.remove(sp);
        sp = new JScrollPane(subjects, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setSize(new Dimension(120,20));
        sp.setBounds(150, 150, 500, 200);
        this.add(sp);
        this.repaint();
    }

    private List<MonHoc> getSubjectsFromFile() throws FileNotFoundException {
        List<MonHoc> result = new ArrayList<>();
        File file = new File("src/swing/thuchanh/MH.txt");
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()){
            int code = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String group = scanner.nextLine();
            int soTin = Integer.parseInt(scanner.nextLine());
            if (group.equals(nhomMon))
                result.add(new MonHoc(code,name,group,soTin));
        }
        return result;
    }
}
