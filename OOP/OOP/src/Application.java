public class Application {
    public static void main(String[] args) throws InterruptedException {
        DogThread dog= new DogThread();
        ClockThread clock = new ClockThread();
        PersonThread person = new PersonThread();
        dog.start();
        clock.start();
        dog.join();
        person.start();
    }
}
