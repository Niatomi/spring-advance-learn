package ru.niatomi.restClientService.exceptions;

/**
 * @author niatomi
 */
public class ClientAlreadyExistsException extends RuntimeException{
    public ClientAlreadyExistsException() {
        super("Client already exists");
    }
}
