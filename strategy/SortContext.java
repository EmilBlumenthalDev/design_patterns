package strategy;

public class SortContext {
    private SortAlgo strategy;

    public void setStrategy(SortAlgo strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        strategy.sort(array);
    }
}
