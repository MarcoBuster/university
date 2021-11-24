package intset;

public class Test {
    public static void main(String[] args) {
        System.out.println("hey!");
        IntSet set = new IntSet();
        set.add(2);
        set.add(40);
        set.add(120);
        try {
            System.out.println(((Integer) set.choose()).toString());
        } catch (EmptyException e) {
            System.out.println("Can't choose: the array is empty");
        }
        System.out.println(set.toString());
        set.remove(40);
        System.out.println(set.toString());
        System.out.println("Dimensione: " + ((Integer) set.size()).toString());
    }
}
