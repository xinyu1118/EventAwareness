package io.github.contextawareness.communication;


import io.github.contextawareness.core.Function;
import io.github.contextawareness.core.Item;
import io.github.contextawareness.utils.annotations.PSOperatorWrapper;

/**
 * A helper class to access message-related operators.
 */
@PSOperatorWrapper
public class MessageOperators {

    /**
     * Get the phone number from incoming messages.
     *
     * @return the function
     */
    public static Function<Item, String> getMessagePhones() {
        String contactField = Message.CONTACT;
        return new MessagePhoneGetter(contactField);
    }

    /**
     * Get incoming message content.
     *
     * @return the function
     */
    public static Function<Item, String> getMessageContent() {
        String contentField = Message.CONTENT;
        return new MessageContentGetter(contentField);
    }

}
