public class PersonThread extends Thread {
    @Override
    public void run() {
        synchronized (PersonThread.class) {
            int start = 0;
            System.out.println("Person: Wow big Dog, run, run, run...");
            notifyAll();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (start < 5) {
                start++;
                System.out.println("Person: Run " + start * 10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
