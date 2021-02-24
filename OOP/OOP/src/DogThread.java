public class DogThread extends Thread {
    @Override
    public void run() {
        synchronized (DogThread.class) {
            int start = 0;
            while (start < 5) {
                System.out.println("Dog: Watching, watching, watching");
                try {
                    Thread.sleep(1000);
                    start++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                wait();
                System.out.println("Dog: Go, go, go, go...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
