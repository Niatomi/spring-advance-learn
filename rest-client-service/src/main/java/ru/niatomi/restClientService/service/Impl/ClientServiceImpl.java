package ru.niatomi.restClientService.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.niatomi.restClientService.exceptions.ClientNotFoundException;
import ru.niatomi.restClientService.mapper.ClientMapper;
import ru.niatomi.restClientService.model.domain.Client;
import ru.niatomi.restClientService.model.dto.ClientDto;
import ru.niatomi.restClientService.repository.ClientRepository;
import ru.niatomi.restClientService.service.ClientService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author niatomi
 */
@Service
@RequiredArgsConstructor
@Validated
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    private void checkIsClientAlreadyExists(Client client) {
        Client clientByEmail = clientRepository.findByEmail(client.getEmail());
        if (clientByEmail != null && client.getId() != (clientByEmail.getId()))
            throw new ClientAlreadyExistsException("email");

        Client clientByContactNumber = clientRepository.findByContactNumber(client.getContactNumber());
        if (clientByContactNumber != null && !client.getId().equals(clientByContactNumber.getId()))
            throw new ClientAlreadyExistsException("contact number");
    }

    @Override
    public String signUpClient(ClientDto clientDto) {
        Client client = clientMapper.toClient(clientDto);
        client.setId(clientRepository.count() + 1);
        checkIsClientAlreadyExists(client);
        client.setSignUpDate(LocalDate.now());
        clientRepository.save(client);
        return "Client created";
    }

    @Override
    public String deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (!client.isPresent())
            throw new ClientNotFoundException();

        return "Client with id=" + id + " deleted";
    }

    @Override
    public String updateClient(@Valid Client client) {
        checkIsClientAlreadyExists(client);
        clientRepository.save(client);
        return "Client updated";
    }

    @Override
    public Client getClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (!client.isPresent())
            throw new ClientNotFoundException();
        return client.get();
    }

    @Override
    public Page<Client> getClients(Pageable page) {
        return clientRepository.findAll(page);
    }

    @Override
    public Page<Client> getClientsBySecondName(Pageable page) {
        return clientRepository.findAll(page);
    }

    @Override
    public Page<Client> getClientsByMail(String emailDomain, Pageable page) {
        List<Client> collect =
                clientRepository
                        .findAll(page)
                        .stream()
                        .filter(client ->
                                client.getEmail().split("@")[1].equals(emailDomain))
                        .collect(Collectors.toList());
        Page<Client> clients = new PageImpl<>(collect, page, collect.size());
        return clients;
    }
}
