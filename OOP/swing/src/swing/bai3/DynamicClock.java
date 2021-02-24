package swing.bai3;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class DynamicClock extends JPanel {
    private int hour;
    private int minute;
    private int second;

    public DynamicClock() {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        currentTime();
        int radius = (int) Math.max(getWidth(),getHeight())/2;
        int xCenter = getWidth()/2;
        int yCenter = getHeight()/2-40;
        graphics.setColor(Color.ORANGE);
        graphics.drawArc(200,50,radius,radius,0,360);
        int length = (int) (radius*0.4);
        int xSecond = (int) (xCenter + length*Math.sin(second*(2*Math.PI/60)));
        int ySecond = (int) (yCenter - length*Math.cos(second*(2*Math.PI/60)));
        graphics.drawLine(xCenter,yCenter,xSecond,ySecond);
        int xMinute = (int) (xCenter + length*Math.sin(minute*(2*Math.PI/60)));
        int yMinute = (int) (yCenter - length*Math.cos(minute*(2*Math.PI/60)));
        graphics.drawLine(xCenter,yCenter,xMinute,yMinute);
        int xHour = (int) (xCenter + length*Math.sin(hour*(2*Math.PI/12)));
        int yHour = (int) (yCenter - length*Math.cos(hour*(2*Math.PI/12)));
        graphics.drawLine(xCenter,yCenter,xHour,yHour);
    }

    public Dimension getPreferedsize(){
        return new Dimension(300,300);
    }

    private void currentTime(){
        LocalDateTime time = LocalDateTime.now();
        this.hour = time.getHour();
        this.minute = time.getMinute();
        this.second = time.getSecond();
    }


}
