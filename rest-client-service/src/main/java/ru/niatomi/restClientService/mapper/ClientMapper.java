package ru.niatomi.restClientService.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.niatomi.restClientService.mapper.customMapper.CustomMapper;
import ru.niatomi.restClientService.model.domain.*;
import ru.niatomi.restClientService.model.dto.ClientDto;

import javax.validation.Valid;

/**
 * @author niatomi
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = CustomMapper.class
)
public interface ClientMapper {

    @Mapping(target = "fio", expression = "java(client.getFirstName() + ' ' + client.getSecondName() + ' ' + client.getThirdName())")
    ClientDto toDto(Client client);

    String regexp = "\\s+";
    @Mappings({
        @Mapping(target = "firstName", expression = "java(clientDto.getFio().split(regexp)[0])"),
        @Mapping(target = "secondName", expression = "java(clientDto.getFio().split(regexp)[1])"),
        @Mapping(source = "fio", target = "thirdName", qualifiedByName = "fioToThirdNameOrNull"),
        @Mapping(source = "gender", target = "gender", qualifiedByName = "genderToEnumGender"),
        @Mapping(target = "deleteDate", ignore = true)
    })
    Client toClient(ClientDto clientDto);





}
