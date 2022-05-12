package ru.niatomi.restClientService.event.model;

import org.springframework.context.ApplicationEvent;

import java.time.LocalDate;

/**
 * @author niatomi
 */
public class ClientSpringEvent extends ApplicationEvent {
    private Long clientId;
    private ClientEvent event;
    private LocalDate date;

    public ClientSpringEvent(Object source, Long clientId, ClientEvent event) {
        super(source);
        this.clientId = clientId;
        this.event = event;
        this.date = LocalDate.now();
    }
}
