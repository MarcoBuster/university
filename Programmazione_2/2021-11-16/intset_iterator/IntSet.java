/**
 * https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e05/01-intset_iterator/Testo.md
 */

package intset_iterator;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;

public class IntSet implements Iterable<Integer> {
    private ArrayList<Integer> elements;

    public IntSet() {
        this.elements = new ArrayList<Integer>();
    }

    public void add(int n) {
        if (!this.contains(n)) {
            this.elements.add(n);
        }
    }

    public void remove(int n) {
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i) == n) {
                this.elements.remove(i);
            }
        }
    }

    public int choose() throws EmptyException {
        int size = this.elements.size();
        if (size == 0) {
            throw new EmptyException();
        }

        Random rand = new Random();
        int randomIdx = rand.nextInt(this.elements.size());
        return this.elements.get(randomIdx);
    }

    public int size() {
        return this.elements.size();
    }

    public boolean contains(int n) {
        return this.elements.contains(n);
    }

    public int hashCode() {
        return 31 * Objects.hash(this.elements);
    }

    @Override
    public String toString() {
        String res = "";
        for (Integer el : this.elements) {
            res += el.toString() + " ";
        }
        return res;
    }

    public class IntSetIterator implements Iterator<Integer> {
        private IntSet set;
        private int setHashCode;
        private int i;

        IntSetIterator(IntSet is) {
            this.set = is;
            this.setHashCode = is.hashCode();
            this.i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < set.size();
        }

        @Override
        public Integer next() {
            if (this.set.hashCode() != this.setHashCode) {
                throw new ConcurrentModificationException();
            }
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            return set.elements.get(i++);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntSetIterator(this);
    }

    public static void main(String args[]) {
        IntSet set = new IntSet();
        set.add(10);
        set.add(20);
        set.add(30);

        for (Integer element : set) {
            System.out.println(element);
        }
    }
}