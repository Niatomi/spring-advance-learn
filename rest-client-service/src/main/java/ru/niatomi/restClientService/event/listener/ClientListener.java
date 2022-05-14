package ru.niatomi.restClientService.event.listener;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import ru.niatomi.restClientService.event.model.ClientSpringEvent;
import ru.niatomi.restClientService.event.repository.EventRepository;

/**
 * @author niatomi
 */
@Component
@AllArgsConstructor
public class ClientListener implements ApplicationListener<ClientSpringEvent> {

    private final EventRepository eventRepository;

    @Override
    public void onApplicationEvent(ClientSpringEvent clientSpringEvent) {
        eventRepository.save(clientSpringEvent);
    }

}
