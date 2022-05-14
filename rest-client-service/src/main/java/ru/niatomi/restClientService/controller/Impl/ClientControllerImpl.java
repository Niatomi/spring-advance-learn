package ru.niatomi.restClientService.controller.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.niatomi.restClientService.controller.ClientController;
import ru.niatomi.restClientService.model.domain.Client;
import ru.niatomi.restClientService.model.dto.ClientDto;
import ru.niatomi.restClientService.service.ClientService;

/**
 * @author niatomi
 */
@RestController
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;

    @Override
    public ResponseEntity<String> signUp(ClientDto clientDto) {
        String out = clientService.signUpClient(clientDto);
        return ResponseEntity.ok(out);
    }

    @Override
    public ResponseEntity<Client> getClient(Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }

    @Override
    public ResponseEntity<String> updateClient(Client client) {
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @Override
    public ResponseEntity<String> deleteClient(Long id) {
        return ResponseEntity.ok(clientService.deleteClient(id));
    }

    @Override
    public ResponseEntity<Page<Client>> getClients(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Client> clients = clientService.getClients(pageRequest);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<Page<Client>> getClientsBySecondName(Integer page, Integer size, String secondName) {
        Sort sort = Sort.by(Sort.Order.asc("secondName"));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Client> clients = clientService.getClientsBySecondName(secondName, pageRequest);
        return ResponseEntity.ok(clients);
    }

    @Override
    public ResponseEntity<Page<Client>> getClientsByMail(Integer page, Integer size, String mailDomain) {
        Sort sort = Sort.by(Sort.Order.asc("id"));
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Client> clients = clientService.getClientsByMail(mailDomain, pageRequest);
        return ResponseEntity.ok(clients);
    }
}
