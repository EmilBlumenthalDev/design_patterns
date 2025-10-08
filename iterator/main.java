public class main {
    public static void main(String[] args) {
        FibonacciSequence fibSeq = new FibonacciSequence(10);
        java.util.Iterator<Integer> iterator1 = fibSeq.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        FibonacciSequence infiniteFibSeq = new FibonacciSequence();
        java.util.Iterator<Integer> iterator = infiniteFibSeq.iterator();
        for (int i = 0; i < 1000; i++) {
            if (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
        }
    }
}
