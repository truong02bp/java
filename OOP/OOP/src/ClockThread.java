import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class ClockThread extends Thread {
    @Override
    public void run() {
        int start = 0;
        while (start < 5) {
            LocalTime time = LocalTime.now();
            String hour = "" + time.getHour();
            String minute = "" + time.getMinute();
            String second = "" + time.getSecond();
            if (time.getHour() < 10)
                hour = "0" + hour;
            if (time.getMinute() < 10)
                minute = "0" + minute;
            if (time.getSecond() < 10)
                second = "0" + second;
            System.out.println("Time:" + hour + ":" + minute + ":" + second);
            try {
                Thread.sleep(1000);
                start++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
