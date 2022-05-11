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

    @Override
    public String signUpClient(ClientDto clientDto) {
        Client client = clientMapper.toClient(clientDto);
        client.setSignUpDate(LocalDate.now());
        clientRepository.save(client);
        return "{created: true}";
    }

    @Override
    public String deleteClient(Long id) {
        clientRepository.deleteById(id);
        return "{deleted: true, id:" + id + "}";
    }

    @Override
    public String updateClient(Long id, ClientDto clientDto) {
        Client client = clientMapper.toClient(clientDto);
        client.setId(id);
        clientRepository.save(client);
        return "{updated: true}";
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Page<Client> getClients(Pageable page) {
//        page.
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
