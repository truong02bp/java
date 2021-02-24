package swing.bai1;

import contants.ColorContains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class ColorBox extends JFrame {

    private JComboBox<String> colors;
    private JLabel label;

    public ColorBox() {
        createAndShow();
    }

    private void createAndShow() {
        this.setTitle("Color Box");
        this.setSize(500, 400);
        createComboBox();
        createLabel();
        this.add(colors);
        this.add(label);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void createLabel() {
        label = new JLabel("Background: ");
        label.setBounds(30, 20, 100, 20);
    }

    private void createComboBox() {
        colors = new JComboBox<>();
        for (String color : ColorContains.colors)
            colors.addItem(color);
        colors.addItemListener(itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED)
                changeColor((String) itemEvent.getItem());
        });
        colors.setBounds(140, 20, 100, 20);
    }

    private void changeColor(String color) {
        Color value = null;
        switch (color) {
            case ColorContains.BLACK:
                value = Color.BLACK;
                break;
            case ColorContains.BLUE:
                value = Color.BLUE;
                break;
            case ColorContains.BROWN:
                value = new Color(165, 42, 42);
                break;
            case ColorContains.GRAY:
                value = Color.GRAY;
                break;
            case ColorContains.GREEN:
                value = Color.GREEN;
                break;
            case ColorContains.ORANGE:
                value = Color.ORANGE;
                break;
            case ColorContains.PINK:
                value = Color.PINK;
                break;
            case ColorContains.PURPLE:
                value = new Color(128, 0, 128);
                break;
            case ColorContains.RED:
                value = Color.RED;
                break;
            case ColorContains.WHITE:
                value = Color.WHITE;
                break;
            case ColorContains.YELLOW:
                value = Color.YELLOW;
                break;
        }
        this.getContentPane().setBackground(value);
    }

    public static void main(String[] args) {
        new ColorBox();
    }
}
