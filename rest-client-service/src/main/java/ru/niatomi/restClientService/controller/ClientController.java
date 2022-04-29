package ru.niatomi.restClientService.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
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
    @Operation(description = "Request for creating new client.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Something failed validation")
    })
    ResponseEntity<Client> signUp(@RequestBody ClientDto clientDto);

    @GetMapping("/get/{id}")
    @Operation(description = "Request for get one by id client.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Client not found")
    })
    ResponseEntity<Client> getClient(@PathVariable Long id);

    @PostMapping("/update/{id}")
    @Operation(description = "Request for update client by id .")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Something failed validation")
    })
    ResponseEntity<Client> updateClient(@PathVariable Long id,
                                        @RequestBody ClientDto clientDto);

    @PostMapping("/delete/{id}")
    @Operation(description = "Request for delete client by id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Client not found")
    })
    ResponseEntity<String> deleteClient(@PathVariable Long id);


    @GetMapping("/pages/allClients")
    @Operation(description = "Request for get in pages all of the clients.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Page not exists")
    })
    ResponseEntity<Page<Client>> getClients(@RequestParam Integer page,
                                            @RequestParam(defaultValue = "10") Integer size);

    @GetMapping("/pages/clientsBySecondName")
    @Operation(description = "Request for get clients in pages by their second name.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Page not exists")
    })
    ResponseEntity<Page<Client>> getClientsBySecondName(@RequestParam Integer page,
                                                        @RequestParam(defaultValue = "10") Integer size,
                                                        @RequestParam String secondName);

    @GetMapping("/pages/email/{emailDomain}")
    @Operation(description = "Request for get clients in pages by their email domain.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request is ok.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "400", description = "Page not exists")
    })
    ResponseEntity<Page<Client>> getClientsByMail(@RequestParam Integer page,
                                                  @RequestParam(defaultValue = "10") Integer size,
                                                  @PathVariable String mailDomain);



}
