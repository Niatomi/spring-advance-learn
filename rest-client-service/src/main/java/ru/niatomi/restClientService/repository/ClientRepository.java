package ru.niatomi.restClientService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.niatomi.restClientService.model.domain.Client;

/**
 * @author niatomi
 */
public interface ClientRepository extends CrudRepository<Client, Long>, PagingAndSortingRepository<Client, Long> {
}
