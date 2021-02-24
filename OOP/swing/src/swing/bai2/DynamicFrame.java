package swing.bai2;

import contants.ColorContains;
import contants.FrameContains;

import javax.swing.*;
import java.awt.*;

public class DynamicFrame extends JPanel {

    private String frame;
    private String type = FrameContains.HOLLOW;
    private String color = ColorContains.WHITE;
    private int radius = 1;
    private int width = 1;
    private int length = 1;
    private int side = 1;

    public DynamicFrame() {

    }

    private Color getColorSelected() {
        Color value = Color.WHITE;
        if (color != null) {
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
        }
        return value;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(getColorSelected());
        if (frame != null)
            switch (frame) {
                case (FrameContains.CIRCLE):
                    int r = radius * 100 / 2;
                    if (type.equals(FrameContains.HOLLOW))
                        graphics.drawArc(400, 250, r, r, 0, 360);
                    else if (type.equals(FrameContains.SOLID))
                        graphics.fillArc(400, 250, r, r, 0, 360);
                    break;
                case (FrameContains.POLYGON):
//                    if (type.equals(FrameContains.HOLLOW))
//                        graphics.drawArc(400, 250, r, r, 0, 360);
//                    else if (type.equals(FrameContains.SOLID))
//                        graphics.fillArc(400, 250, r, r, 0, 360);
                    break;
                case (FrameContains.RECTANGLE):
                    int w = width * 100 / 2;
                    int l = length * 100 / 2;
                    if (type.equals(FrameContains.HOLLOW))
                        graphics.drawRect(400, 250, l, w);
                    else if (type.equals(FrameContains.SOLID))
                        graphics.fillRect(400, 250, l, w);
                    break;
                case (FrameContains.SQUARE):
                    int value = side * 100 / 2;
                    if (type.equals(FrameContains.HOLLOW))
                        graphics.drawRect(400, 250, value, value);
                    else if (type.equals(FrameContains.SOLID))
                        graphics.fillRect(400, 250, value, value);
                    break;

            }
    }

    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSide(int side) {
        this.side = side;
    }
}
