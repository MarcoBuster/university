/*
 * https://github.com/prog2-unimi/esercitazioni/blob/aa2122/testi/e05/02-filter_iterator/Testo.md
 */

package filter_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.NoSuchElementException;

public class FilterIterator<T> implements Iterator<T> {
    private final Iterator<T> source;
    private Predicate<T> filter;
    private LinkedList<T> elements;

    public FilterIterator(final Iterator<T> source, Predicate<T> filter) {
        this.source = source;
        this.filter = filter;
        elements = new LinkedList<>();
    }

    @Override
    public boolean hasNext() {
        T e;
        try {
            e = this.source.next();
            while (!this.filter.test(e)) {
                e = this.source.next();
            }
        } catch (NoSuchElementException err) {
            return this.elements.size() > 0;
        }
        this.elements.add(e);
        return true;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return this.elements.poll();
    }
}
