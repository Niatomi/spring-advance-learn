package ru.niatomi.restClientService.event.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.niatomi.restClientService.event.model.ClientEvent;
import ru.niatomi.restClientService.event.model.ClientSpringEvent;

/**
 * @author niatomi
 */
@RequiredArgsConstructor
@Component
public class ClientPublisher {
    private final ApplicationEventPublisher publisher;

    public void publish(Long clientId, ClientEvent event) {
        ClientSpringEvent clientSpringEvent = new ClientSpringEvent(this, clientId, event);
        publisher.publishEvent(clientSpringEvent);
    }

}
