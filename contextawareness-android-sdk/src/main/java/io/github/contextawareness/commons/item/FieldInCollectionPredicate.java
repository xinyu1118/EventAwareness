package io.github.contextawareness.commons.item;

import io.github.contextawareness.commons.ItemOperator;
import io.github.contextawareness.core.Item;
import io.github.contextawareness.core.UQI;
import io.github.contextawareness.utils.Assertions;

import java.util.List;

/**
 * Check whether the value of a field is in a given collection.
 */
final class FieldInCollectionPredicate<TValue> extends ItemOperator<Boolean> {

    private final String field;
    private final List<TValue> collectionToCompare;

    FieldInCollectionPredicate(final String field, final List<TValue> collectionToCompare) {
        this.field = Assertions.notNull("field", field);
        this.collectionToCompare = Assertions.notNull("collectionToCompare", collectionToCompare);
        this.addParameters(field, collectionToCompare);
    }

    @Override
    public Boolean apply(UQI uqi, Item input) {
        TValue fieldValue = input.getValueByField(this.field);
        return this.collectionToCompare.contains(fieldValue);
    }

}
