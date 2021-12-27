package filter_iterator;

import java.util.function.Predicate;

public class IsGreaterThan implements Predicate<Integer> {
    public final int threshold;
    public IsGreaterThan(final int threshold) {
      this.threshold = threshold;
    }

    @Override
    public boolean test(Integer t) {
      return t > threshold;
    }
}