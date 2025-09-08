package strategy;

public class StalinSort implements SortAlgo {
    @Override
    public void sort(int[] array) {
        if (array.length == 0) return;
        int last = array[0];
        int index = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= last) {
                array[index++] = array[i];
                last = array[i];
            }
        }
        while (index < array.length)
            array[index++] = 0;
    }
}
