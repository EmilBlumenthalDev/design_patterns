package observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private List<Observer> observers;
    private int temperature;
    private final int MIN_TEMP = -10;
    private final int MAX_TEMP = 40;
    private Random random;

    public WeatherStation() {
        observers = new ArrayList<>();
        random = new Random();
        temperature = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP; // random initial temp
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println("Observer removed.");
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((random.nextInt(5) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int change = random.nextBoolean() ? 1 : -1;
            temperature += change;
            if (temperature < MIN_TEMP) temperature = MIN_TEMP;
            if (temperature > MAX_TEMP) temperature = MAX_TEMP;

            notifyObservers();
        }
    }
}
