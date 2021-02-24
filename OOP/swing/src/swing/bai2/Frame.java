package swing.bai2;

import contants.ColorContains;
import contants.FrameContains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class Frame extends JFrame implements ActionListener {

    JComboBox<String> frame, colors, type;
    DynamicFrame dynamicFrame = new DynamicFrame();
    JButton submit;
    JTextField radius, width, length , side;
    JLabel frameLabel, radiusLabel, widthLabel, lengthLabel , sideLabel;

    public Frame() throws HeadlessException {
        createAndShow();
    }

    private void createAndShow() {
        createFrame();
        createLabel();
        createType();
        createColors();
        this.add(dynamicFrame);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Frame");
        this.setVisible(true);
    }

    private void createFrame() {
        frame = new JComboBox<>();
        frame.addItem("Choose frame");
        frame.addItemListener(itemEvent -> {
            if (frame.getSelectedIndex() > 0 && itemEvent.getStateChange() == ItemEvent.SELECTED) {
                String value = (String) itemEvent.getItem();
                render(value);
                dynamicFrame.setFrame(value);
                dynamicFrame.repaint();
                this.add(dynamicFrame);
            }
        });
        for (String value : FrameContains.frames)
            frame.addItem(value);
        frame.setBounds(80, 20, 130, 20);
        this.add(frame);
    }

    private void createColors() {
        colors = new JComboBox<>();
        for (String color : ColorContains.colors)
            colors.addItem(color);
        colors.addItemListener(itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                dynamicFrame.setColor((String) itemEvent.getItem());
                dynamicFrame.repaint();
                this.add(dynamicFrame);
            }
        });
        colors.setBounds(240, 20, 100, 20);
        this.add(colors);
    }

    private void createType() {
        type = new JComboBox<>();
        type.setBounds(370, 20, 100, 20);
        type.addItem(FrameContains.HOLLOW);
        type.addItem(FrameContains.SOLID);
        type.addItemListener(itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                dynamicFrame.setType((String) itemEvent.getItem());
                dynamicFrame.repaint();
                this.add(dynamicFrame);
            }
        });
        this.add(type);
    }

    private void createLabel() {
        frameLabel = new JLabel("Frame: ");
        frameLabel.setBounds(20, 20, 100, 20);
        this.add(frameLabel);
    }

    private void createButtonCircle() {
        radiusLabel = new JLabel("Radius (cm)");
        radiusLabel.setBounds(20, 55, 120, 20);
        radius = new JTextField();
        radius.setBounds(20, 80, 120, 20);
        this.add(radius);
        this.add(radiusLabel);
    }

    private void createButtonRectangle() {
        widthLabel = new JLabel("Width :");
        widthLabel.setBounds(20, 55, 120, 20);
        width = new JTextField();
        width.setBounds(20, 80, 120, 20);
        lengthLabel = new JLabel("Length :");
        lengthLabel.setBounds(170, 55, 120, 20);
        length = new JTextField();
        length.setBounds(170, 80, 120, 20);
        this.add(width);
        this.add(length);
        this.add(widthLabel);
        this.add(lengthLabel);
    }

    private void createButtonSquare(){
        sideLabel = new JLabel("Side :");
        sideLabel.setBounds(20, 55, 120, 20);
        side = new JTextField();
        side.setBounds(20, 80, 120, 20);
        this.add(sideLabel);
        this.add(side);
    }

    private void removeCircleBtn(){
        if (radius != null) {
            this.remove(radius);
            this.remove(radiusLabel);
        }
    }

    private void removeRectangleBtn() {
        if (width != null) {
            this.remove(width);
            this.remove(length);
            this.remove(lengthLabel);
            this.remove(widthLabel);
        }
    }

    private void removeSquareBtn(){
        if (side != null)
        {
            this.remove(side);
            this.remove(sideLabel);
        }
    }

    private void render(String value) {
        switch (value) {
            case FrameContains.CIRCLE:
                removeRectangleBtn();
                removeSquareBtn();
                createButtonCircle();
                break;
            case FrameContains.RECTANGLE:
                removeCircleBtn();
                removeSquareBtn();
                createButtonRectangle();
                break;
            case FrameContains.SQUARE:
                removeCircleBtn();
                removeRectangleBtn();
                createButtonSquare();
                break;
        }
        if (submit == null) {
            submit = new JButton("Submit");
            submit.setBounds(20, 110, 90, 20);
            submit.addActionListener(this);
            this.add(submit);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String button = actionEvent.getActionCommand();
        if (button.equals("Submit")) {
            if (radius!= null && !radius.getText().isEmpty())
                dynamicFrame.setRadius(Integer.parseInt(radius.getText()));
            if (length!= null && !length.getText().isEmpty())
                dynamicFrame.setLength(Integer.parseInt(length.getText()));
            if (width != null && !width.getText().isEmpty())
                dynamicFrame.setWidth(Integer.parseInt(width.getText()));
            if (side != null && !side.getText().isEmpty())
                dynamicFrame.setSide(Integer.parseInt(side.getText()));
            dynamicFrame.repaint();
            this.add(dynamicFrame);
            this.repaint();
        }
    }

    public static void main(String[] args) {
        new Frame();
    }

}
