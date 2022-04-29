package ru.niatomi.restClientService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author niatomi
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreateClientDto {
    private String firstName;
    private String secondName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private String contactNumber;
    private String email;
}
