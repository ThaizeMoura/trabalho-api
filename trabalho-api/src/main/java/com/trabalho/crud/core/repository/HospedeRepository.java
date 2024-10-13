package com.trabalho.crud.core.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trabalho.crud.core.entity.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    // Método para buscar hóspedes pelo nome
    List<Hospede> findByNome(String name);

    // Método para buscar por email
    Optional<Hospede> findByEmail(String email);
}
