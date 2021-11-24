/*
    https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e03/01-intset/Testo.md
*/

package intset;

import java.util.ArrayList;
import java.util.Random;

public class IntSet {
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

    @Override
    public String toString() {
        String res = "";
        for (Integer el : this.elements) {
            res += el.toString() + " ";
        }
        return res;
    }
}