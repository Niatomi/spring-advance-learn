package ru.niatomi.restClientService.exceptions;

/**
 * @author niatomi
 */
public class ClientAlreadyExistsException extends RuntimeException{
    public ClientAlreadyExistsException(String message) {
        super("Client with same " + message + " already exists");
    }
}
