package proxy;

public class IdCounter {
    private static int count = 0;

    public static synchronized int getNextId() {
        return ++count;
    }
}