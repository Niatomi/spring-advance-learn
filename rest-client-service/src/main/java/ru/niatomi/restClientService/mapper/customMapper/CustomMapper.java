package ru.niatomi.restClientService.mapper.customMapper;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.niatomi.restClientService.model.domain.Gender;

/**
 * @author niatomi
 */
@Named("CustomMapper")
@Component
public class CustomMapper {

    @Named("genderToEnumGender")
    public  Gender genderToEnumGender(String gender) {
        return Enum.valueOf(Gender.class, gender.toUpperCase());
    }

    @Named("fioToThirdNameOrNull")
    public  String fioToThirdNameOrNull(String fio){
        String[] split = fio.split("\\s+");
        String thirdName = null;

        try {
            thirdName = split[3];
        } finally {
            return thirdName;
        }

    }
}
