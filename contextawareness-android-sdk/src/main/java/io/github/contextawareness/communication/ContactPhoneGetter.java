package io.github.contextawareness.communication;


import java.util.List;

import io.github.contextawareness.core.UQI;

/**
 * Get the phones from contact lists.
 */
class ContactPhoneGetter extends ContactPhoneProcessor<List<String>> {

    ContactPhoneGetter(String phonesField) {
        super(phonesField);
    }

    @Override
    protected List<String> processCall(UQI uqi, List<String> phones) {
        if (phones == null) return null;
        return phones;
    }
}