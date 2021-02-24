package swing.bai3;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Clock extends JFrame implements Runnable{

    JButton clock;
    Thread t = null;
    JLabel hour3,hour6,hour9,hour12;
    DynamicClock dynamicClock = new DynamicClock();
    public Clock() throws HeadlessException {
        createAndShow();
    }

    private void createAndShow(){
        this.setVisible(true);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Clock");
        createLabel();
        clock = new JButton();
        clock.setBounds(300,500,200,50);
        t = new Thread(this);
        t.start();
        this.add(clock);
        this.add(dynamicClock);
    }


    private void createLabel(){
        hour3 = new JLabel("3");
        hour3.setBounds(610,235,20,20);
        hour6 = new JLabel("6");
        hour6.setBounds(395,450,20,20);
        hour9 = new JLabel("9");
        hour9.setBounds(180,235,20,20);
        hour12 = new JLabel("12");
        hour12.setBounds(395,25,20,20);
        this.add(hour3);
        this.add(hour6);
        this.add(hour9);
        this.add(hour12);
    }

    public static void main(String[] args) {
        new Clock();
    }

    @Override
    public void run() {
        while (true){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh : mm : ss");
            clock.setText(LocalDateTime.now().format(dateTimeFormatter));
            this.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
