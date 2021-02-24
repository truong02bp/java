package swing.thuchanh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Bai1 extends JFrame implements ActionListener {
    JTextArea textArea,result;
    JButton button = new JButton("Submit");
    public Bai1() {
        createAndShow();
    }

    private void createAndShow(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setSize(800,600);
        this.setTitle("Text");
        textArea = new JTextArea(10,10);
        textArea.setSize(new Dimension(400,200));
        textArea.setBounds(200,50,400,100);
        button.setSize(new Dimension(50,50));
        button.addActionListener(this);
        button.setBounds(350,300,100,50);
        this.add(textArea);
        this.add(button);
    }


    public static void main(String[] args) {
        new Bai1();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String button = actionEvent.getActionCommand();
        if (button.equals("Submit")){
            String text = textArea.getText();
            System.out.println(text);
            if (result == null){
                result = new JTextArea();
                result.setSize(new Dimension(400,200));
                result.setBounds(200,350,400,200);
            }
            if (text.isEmpty())
                result.setText("Không được để rỗng");
            else
                result.setText(getValue(text));
            this.add(result);
            this.repaint();
        }
    }
    private String getValue(String text){
        Map<String,Integer> map = new HashMap<>();
        String[] data = text.split("\n");
        List<String> values = new ArrayList<>();
        for (String s : data)
            values.addAll(Arrays.asList(s.split(" ")));
        for (String value : values){
            value = value.trim();
            if (map.containsKey(value))
                map.replace(value,map.get(value)+1);
            else
                map.put(value,1);
        }
        String result = "Có "+map.size()+" từ khác nhau\n";
        StringBuilder sb = new StringBuilder(result);
        map.forEach((key,value) -> {
            sb.append(key).append(" : ").append(value).append(" lần\n");
        });
        return sb.toString();
    }
}
