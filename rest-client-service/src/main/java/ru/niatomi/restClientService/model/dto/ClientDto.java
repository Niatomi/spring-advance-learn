package ru.niatomi.restClientService.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * @author niatomi
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private String fio;
    private String gender;
    private LocalDate birthDate;
    private String contactNumber;
    private String email;
}
