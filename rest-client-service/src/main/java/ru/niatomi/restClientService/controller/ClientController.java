package ru.niatomi.restClientService.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.niatomi.restClientService.model.domain.Client;
import ru.niatomi.restClientService.model.dto.ClientDto;

/**
 * @author niatomi
 */
@RequestMapping("/clientController")
public interface ClientController {

    @PostMapping("/singUp")
    ResponseEntity<Client> signUp(@RequestBody ClientDto clientDto);

    @GetMapping("/get/{id}")
    ResponseEntity<Client> getClient(@PathVariable Long id);

    @PostMapping("/update/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id,
                                        @RequestBody ClientDto clientDto);

    @PostMapping("/delete/{id}")
    ResponseEntity<String> deleteClient(@PathVariable Long id);


    @GetMapping("/pages/allClients")
    ResponseEntity<Page<Client>> getClients(@RequestParam Integer page,
                                            @RequestParam(defaultValue = "10") Integer size,
                                            @RequestParam String mailDomain);

    @GetMapping("/pages/clientsBySecondName")
    ResponseEntity<Page<Client>> getClientsBySecondName(@RequestParam Integer page,
                                                        @RequestParam(defaultValue = "10") Integer size,
                                                        @RequestParam String secondName);

    @GetMapping("/pages/email/{emailDomain}")
    ResponseEntity<Page<Client>> getClientsByMail(@RequestParam Integer page,
                                                  @RequestParam(defaultValue = "10") Integer size,
                                                  @PathVariable String mailDomain);



}
