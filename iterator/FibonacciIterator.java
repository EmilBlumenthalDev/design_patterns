import java.math.BigInteger;
import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer>  {
    private BigInteger count;
    private final int limit;
    private int a = 0, b = 1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
        this.count = BigInteger.ZERO;
    }

    @Override
    public boolean hasNext() {
        return limit < 0 || count.compareTo(BigInteger.valueOf(limit)) < 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        int nextValue = a;
        int nextB = a + b;
        a = b;
        b = nextB;
        count = count.add(BigInteger.ONE);
        return nextValue;
    }
}