package ru.guzshop.catalog.impl.streams.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.guzshop.catalog.impl.streams.event.FirstEvent;
import ru.guzshop.catalog.impl.streams.event.SecondEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class MyEventListener {

    @EventListener
    public void handleFirstEvent(FirstEvent firstEvent) {
        log.info(firstEvent.toString());
    }

    @EventListener
    public void handleSecondEvent(SecondEvent secondEvent) {
        log.info(secondEvent.toString());
    }
}
