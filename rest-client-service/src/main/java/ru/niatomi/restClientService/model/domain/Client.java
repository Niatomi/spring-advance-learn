package ru.niatomi.restClientService.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author niatomi
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_table")
public class Client {

    @Id
    @Column(name = "id", length = 8)
    private Long id;

    @Column(name = "first_name", length = 32)
    private String firstName;
    @Column(name = "second_name", length = 32)
    private String secondName;
    @Column(name = "last_name", length = 32)
    private String thirdName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "sign_up_date")
    private LocalDate signUpDate;

    @Column(name = "delete_date")
    private LocalDate deleteDate;

}
