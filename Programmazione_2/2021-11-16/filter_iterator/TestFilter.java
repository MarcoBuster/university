package filter_iterator;

import java.util.Iterator;
import java.util.List;

public class TestFilter {
    public static void main(String []args) {
        Iterator<Integer> filtered = new FilterIterator<>(
            List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 6).iterator(),
            new IsGreaterThan(5)
        );
        while (filtered.hasNext()) 
            System.out.println(filtered.next());
    }
}
