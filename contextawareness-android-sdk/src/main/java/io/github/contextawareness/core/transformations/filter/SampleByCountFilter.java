package io.github.contextawareness.core.transformations.filter;

import io.github.contextawareness.core.Item;

/**
 * Sample the items in the stream.
 */
final class SampleByCountFilter extends StreamFilter {
    private final int step;

    SampleByCountFilter(int step) {
        this.step = step;
        this.addParameters(step);
    }

    private transient int lastIndex = Integer.MIN_VALUE;
    private transient int currentIndex = -1;

    @Override
    public boolean keep(Item item) {
        currentIndex++;

        if (lastIndex + step >= currentIndex) {
            return false;
        } else {
            lastIndex = currentIndex;
            return true;
        }
    }

}
