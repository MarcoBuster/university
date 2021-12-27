package range_iterator;

public class TestRange {
    public static void main(String []args) {
        RangeIterator it = new RangeIterator(-3, -6, -1);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
