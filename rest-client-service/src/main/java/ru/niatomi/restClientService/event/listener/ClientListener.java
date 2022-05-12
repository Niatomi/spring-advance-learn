package ru.niatomi.restClientService.event.listener;

import org.springframework.context.ApplicationListener;
import ru.niatomi.restClientService.event.model.ClientSpringEvent;

/**
 * @author niatomi
 */
public class ClientListener implements ApplicationListener<ClientSpringEvent> {
    @Override
    public void onApplicationEvent(ClientSpringEvent clientSpringEvent) {

    }
}
