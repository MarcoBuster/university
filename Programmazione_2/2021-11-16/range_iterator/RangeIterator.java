/*
 * https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e05/03-range_iterator/Testo.md
 */

package range_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterator implements Iterator<Integer> {
    private Integer start;
    private Integer end;
    private Integer delta;
    private Integer curr;

    public RangeIterator(int a, int b, int delta) {
        this.start = a;
        this.end = b;
        this.delta = delta;
        this.curr = this.start;
    }

    @Override
    public boolean hasNext() {
        return this.delta > 0 ? 
            this.curr < this.end :
            this.curr > this.end;
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        Integer prev = this.curr;
        this.curr += this.delta;
        return prev;
    }
}
