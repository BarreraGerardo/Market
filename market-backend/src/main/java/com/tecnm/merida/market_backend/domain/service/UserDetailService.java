package com.tecnm.merida.market_backend.domain.service;

import com.tecnm.merida.market_backend.persistence.crud.ClienteCrudRepository;
import com.tecnm.merida.market_backend.persistence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Asumiendo que usas el correo electrónico o ID como identificador/username
        Cliente cliente = clienteCrudRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new User(cliente.getCorreoElectronico(), cliente.getContrasena(), new ArrayList<>());
    }
}