package com.tecnm.merida.market_backend.persistence.mapper;

import com.tecnm.merida.market_backend.domain.Client;
import com.tecnm.merida.market_backend.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "id", target = "clientId"),
            @Mapping(source = "nombre", target = "firstName"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "celular", target = "phone"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correoElectronico", target = "email")
    })
    Client toClient(Cliente cliente);

    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente(Client client);
}