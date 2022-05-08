package ru.niatomi.restClientService.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.niatomi.restClientService.model.domain.Client;
import ru.niatomi.restClientService.model.dto.ClientDto;
import ru.niatomi.restClientService.service.ClientService;

/**
 * @author niatomi
 */
@Service
@RequiredArgsConstructor
@Validated
public class ClientServiceImpl implements ClientService {
    @Override
    public String signUpClient(ClientDto clientDto) {
        return null;
    }

    @Override
    public String deleteClient(Long id) {
        return null;
    }

    @Override
    public String updateClient(Long id, ClientDto clientDto) {
        return null;
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }

    @Override
    public Page<Client> getClients(Pageable page) {
        return null;
    }

    @Override
    public Page<Client> getClientsBySecondName(Pageable page) {
        return null;
    }

    @Override
    public Page<Client> getClientsByMail(Pageable page) {
        return null;
    }
}
