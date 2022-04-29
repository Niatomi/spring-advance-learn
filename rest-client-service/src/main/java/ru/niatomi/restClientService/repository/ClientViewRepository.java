package ru.niatomi.restClientService.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.niatomi.restClientService.model.domain.Client;

/**
 * @author niatomi
 */
public interface ClientViewRepository extends PagingAndSortingRepository<Client, Long> {
}