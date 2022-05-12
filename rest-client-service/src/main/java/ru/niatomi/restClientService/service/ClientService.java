package ru.niatomi.restClientService.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.niatomi.restClientService.model.domain.Client;
import ru.niatomi.restClientService.model.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

/**
 * @author niatomi
 */
@Validated
public interface ClientService {

    String signUpClient(ClientDto clientDto);
    String deleteClient(Long id);
    String updateClient(@Valid Client client);

    Client getClient(Long id);
    Page<Client> getClients(Pageable page);
    Page<Client> getClientsBySecondName(Pageable page);
    Page<Client> getClientsByMail(String emailDomain, Pageable page);

}
