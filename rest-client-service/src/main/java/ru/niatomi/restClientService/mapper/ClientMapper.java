package ru.niatomi.restClientService.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ru.niatomi.restClientService.model.domain.Client;
import ru.niatomi.restClientService.model.dto.ClientDto;

/**
 * @author niatomi
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "fio", expression = "java(client.getFirstName() + ' ' + client.getSecondName() + ' ' + client.getThirdName())")
    ClientDto toDto(Client client);

    String regexp = "\\s+";
    @Mappings({
        @Mapping(target = "firstName", expression = "java(clientDto.getFio().split(regexp)[0])"),
        @Mapping(target = "secondName", expression = "java(clientDto.getFio().split(regexp)[1])"),
        @Mapping(target = "thirdName", expression = "java(clientDto.getFio().split(regexp)[2])")
    })
    Client toClient(ClientDto clientDto);

}
