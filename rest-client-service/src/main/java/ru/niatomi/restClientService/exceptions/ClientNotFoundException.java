package ru.niatomi.restClientService.exceptions;

/**
 * @author niatomi
 */
public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Client not found");
    }
}
