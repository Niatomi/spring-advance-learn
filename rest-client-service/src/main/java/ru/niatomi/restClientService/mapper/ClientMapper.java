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

    @Mapping(source = "client", target = "fio", qualifiedBy = ToFioConverter.class)
    ClientDto toDto(Client client);

    @Mapping(source = "fio", target = "client", qualifiedBy = ToNamesConverter.class)
    Client toClient(ClientDto clientDto);

    @ToFioConverter
    static String convertToFio(Client client) {
        String fio = client.getFirstName() + " " + client.getSecondName() + " " + client.getThirdName();
        return fio;
    }

    @ToNamesConverter
    static Client convertToNames(ClientDto clientDto) {
        String[] values = clientDto.getFio().split("\\s+");
        Client client = new Client();

        client.setFirstName(values[0]);
        client.setSecondName(values[1]);
        client.setThirdName(values[2]);

        return client;
    }
}
