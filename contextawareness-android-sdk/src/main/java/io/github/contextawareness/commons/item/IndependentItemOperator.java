package io.github.contextawareness.commons.item;

import io.github.contextawareness.commons.ItemOperator;
import io.github.contextawareness.core.Function;
import io.github.contextawareness.core.Item;
import io.github.contextawareness.core.UQI;
import io.github.contextawareness.utils.Assertions;

/**
 * A function that is independent from current item.
 */

class IndependentItemOperator<Tout> extends ItemOperator<Tout> {
    private Function<Void, Tout> voidInFunction;

    IndependentItemOperator(Function<Void, Tout> voidInFunction) {
        this.voidInFunction = Assertions.notNull("voidInFunction", voidInFunction);
        this.addParameters(voidInFunction);
    }

    @Override
    public Tout apply(UQI uqi, Item input) {
        return this.voidInFunction.apply(uqi, null);
    }
}
