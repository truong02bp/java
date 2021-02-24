package swing.thuchanh;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormHienThi extends JPanel {
    JTable subjects;

    public FormHienThi() {
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
        List<MonHoc> list = getSubjectsFromFile();
        String[] columns = {"Mã môn học","Tên môn học","Nhóm môn học","Số tín chỉ"};
        String[][] data = new String[list.size()][4];
        for (int i=0;i<list.size();i++){
            data[i][0] = String.valueOf(list.get(i).getMaMon());
            data[i][1] = list.get(i).getTenMon();
            data[i][2] = list.get(i).getNhomMon();
            data[i][3] = String.valueOf(list.get(i).getSoTinChi());
        }
        subjects = new JTable(data,columns);
        JScrollPane sp = new JScrollPane(subjects, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setSize(new Dimension(120,20));
        sp.setBounds(150, 150, 500, 200);
        this.add(sp);
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
            result.add(new MonHoc(code,name,group,soTin));
        }
        return result;
    }
}
