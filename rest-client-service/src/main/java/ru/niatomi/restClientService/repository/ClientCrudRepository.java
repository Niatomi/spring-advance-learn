package ru.niatomi.restClientService.repository;

import org.springframework.data.repository.CrudRepository;
import ru.niatomi.restClientService.model.domain.Client;

/**
 * @author niatomi
 */
public interface ClientCrudRepository extends CrudRepository<Client, Long> {
}
