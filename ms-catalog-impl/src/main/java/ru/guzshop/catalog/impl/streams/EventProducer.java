package ru.guzshop.catalog.impl.streams;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * Example of implementation kafka producer (FOR DEMONSTRATION).
 */
@Service
@RequiredArgsConstructor
public class EventProducer {

    private static final String EMPTY_MESSAGE_KEY = StringUtils.EMPTY;

    private final StreamBridge streamBridge;

    /**
     * Send message without key.
     */
    public <T> void produce(String destinationName, T event) {
        produce(destinationName, buildMessage(event, EMPTY_MESSAGE_KEY));
    }

    /**
     * Send message with message messageKey.
     */
    public <T> void produce(String destinationName, String messageKey, T event) {
        produce(destinationName, buildMessage(event, messageKey));
    }

    /**
     * Send custom message.
     */
    public <T> void produce(String destinationName, Message<T> message) {
        streamBridge.send(destinationName, message);
    }

    private <T> Message<T> buildMessage(T payload, String messageKey) {
        var messageBuilder = MessageBuilder.withPayload(payload)
            .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);

        if (StringUtils.isNotBlank(messageKey)) {
            messageBuilder.setHeader(KafkaHeaders.KEY, messageKey);
        }
        return messageBuilder.build();
    }
}
