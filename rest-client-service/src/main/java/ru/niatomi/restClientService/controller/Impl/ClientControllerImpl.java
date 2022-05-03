package ru.niatomi.restClientService.controller.Impl;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.restClientService.controller.ClientController;
import ru.niatomi.restClientService.model.domain.Client;
import ru.niatomi.restClientService.model.dto.ClientDto;

/**
 * @author niatomi
 */
@RestController
public class ClientControllerImpl implements ClientController {
    @Override
    public ResponseEntity<Client> signUp(ClientDto clientDto) {
        return null;
    }

    @Override
    public ResponseEntity<Client> getClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Client> updateClient(Long id, ClientDto clientDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Client>> getClients(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Client>> getClientsBySecondName(Integer page, Integer size, String secondName) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Client>> getClientsByMail(Integer page, Integer size, String mailDomain) {
        return null;
    }
}
