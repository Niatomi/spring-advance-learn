package ru.niatomi.restClientService.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.niatomi.restClientService.model.domain.Client;

/**
 * @author niatomi
 */
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    Page<Client> findBySecondName(String secondName, Pageable page);
    Client findByEmail(String email);
    Client findByContactNumber(String number);
}
