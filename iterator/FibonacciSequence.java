public class FibonacciSequence implements Sequence {
    private final int limit;

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    public FibonacciSequence() {
        this.limit = -1;
    }

    @Override
    public java.util.Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}
