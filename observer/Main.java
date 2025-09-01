package observer;
public class Main extends Thread {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer observer1 = new Observer();
        Observer observer2 = new Observer();
        
        Thread stationThread = new Thread(station);
        stationThread.start();

        station.registerObserver(observer1);
        station.registerObserver(observer2);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        station.removeObserver(observer1);
    }
}
