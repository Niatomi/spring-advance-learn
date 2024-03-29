package ru.niatomi.restClientService.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import ru.niatomi.restClientService.model.validation.DateLessThan;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author niatomi
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_table")
@DateLessThan.List({
    @DateLessThan(
            time1 = "birthDate",
            time2 = "signUpDate",
            message = "Дата регистрации не может быть меньше даты рождения"
    ),
    @DateLessThan(
        time1 = "signUpDate",
        time2 = "deleteDate",
        message = "Дата удаления не может быть меньше даты регистрации"
    )
})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[а-яёА-ЯЁ-]+", message = "Должны быть только русские символы")
    private String firstName;

    @Pattern(regexp = "[а-яёА-ЯЁ-]+", message = "Должны быть только русские символы")
    private String secondName;

    @Pattern(regexp = "([а-яёА-ЯЁ-]+)?", message = "Должны быть только русские символы, либо отчества вовсе может не быть")
    private String thirdName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @PastOrPresent(message = "Дата рождения не может быть в будующем")
    private LocalDate birthDate;

    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
             message = "Номер телефона должен быть похож на +79999999999, 8(999)999-99-99 , +7 999 999 99 99")
    private String contactNumber;

    @Email(message = "Почта должна быть похожа на example@example.example")
    private String email;

    @CreatedDate
    private LocalDate signUpDate;

    private LocalDate deleteDate;

}
