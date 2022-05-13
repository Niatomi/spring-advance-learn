package ru.niatomi.restClientService.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.niatomi.restClientService.event.model.ClientSpringEvent;

/**
 * @author niatomi
 */
public interface EventRepository extends JpaRepository<ClientSpringEvent, Long> {
}
