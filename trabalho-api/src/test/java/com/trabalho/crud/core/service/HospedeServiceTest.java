package com.trabalho.crud.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.trabalho.crud.core.entity.Hospede; // Importando a classe Hospede
import com.trabalho.crud.core.repository.HospedeRepository; // Importando a interface HospedeRepository

@ActiveProfiles("test")
@SpringBootTest
class HospedeServiceTest {

  @Autowired
  private HospedeRepository repository; // Alterado para HospedeRepository

  @Autowired
  private HospedeService service; // Alterado para HospedeService

  @BeforeEach
  void populateRepository() {
    MockitoAnnotations.openMocks(this);
    repository.save(Hospede.builder().name("Hospede 1").email("hospede1@email.com").build());
    repository.save(Hospede.builder().name("Hospede 2").email("hospede2@email.com").build());
    repository.save(Hospede.builder().name("Hospede 3").email("hospede3@email.com").build());
  }

  @Test
  @DisplayName("Busca todos os hóspedes")
  void testBuscarTodosOsHospedes() {
    var allHospedes = service.findAll(); // Alterado para buscar hóspedes

    assertEquals(3, allHospedes.size());
  }
}
