package ru.niatomi.restClientService.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 32, nullable = false)
    @Pattern(regexp = "[а-яёА-ЯЁ-]+", message = "Должны быть только русские символы")
    private String firstName;
    @Column(name = "second_name", length = 32, nullable = false)
    @Pattern(regexp = "[а-яёА-ЯЁ-]+", message = "Должны быть только русские символы")
    private String secondName;
    @Column(name = "last_name", length = 32, nullable = true)
    @Pattern(regexp = "[а-яёА-ЯЁ-]+", message = "Должны быть только русские символы")
    private String thirdName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birthdate")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate birthDate;

    @Column(name = "contact_number")
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
             message = "Номер телефона должен быть похож на +79999999999, 8(999)999-99-99 , +7 999 999 99 99")
    private String contactNumber;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "sign_up_date")
    @CreatedDate
    private LocalDate signUpDate;

    @Column(name = "delete_date")
    private LocalDate deleteDate;

}
