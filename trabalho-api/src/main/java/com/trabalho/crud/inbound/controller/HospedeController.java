package com.trabalho.crud.inbound.controller;

import java.util.List;

import com.trabalho.crud.core.dto.HospedeDto;
import com.trabalho.crud.core.service.HospedeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

/**
 * Controlador REST para gerenciar hóspedes.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/hospedes")
public class HospedeController {

  private final HospedeService hospedeService;

  /**
   * Busca todos os hóspedes.
   *
   * @return Lista de todos os HospedeDto.
   */
  @Operation(summary = "Obter todos os hóspedes", description = "Retorna uma lista de todos os hóspedes cadastrados.")
  @GetMapping
  public ResponseEntity<List<HospedeDto>> getAllHospedes() {
    return ResponseEntity.ok(hospedeService.findAll());
  }

  /**
   * Busca um hóspede por ID.
   *
   * @param id ID do hóspede a ser buscado.
   * @return O HospedeDto correspondente ao ID fornecido.
   */
  @Operation(summary = "Buscar hóspede por ID", description = "Retorna os detalhes de um hóspede com base no ID fornecido.")
  @GetMapping("/{id}")
  public ResponseEntity<HospedeDto> getHospedeById(@PathVariable Long id) {
    return ResponseEntity.ok(hospedeService.findById(id));
  }

  /**
   * Cria um novo hóspede.
   *
   * @param hospedeDTO Objeto HospedeDto contendo os dados do novo hóspede.
   * @return O HospedeDto criado.
   */
  @Operation(summary = "Criar um novo hóspede", description = "Adiciona um novo hóspede ao sistema com base nas informações fornecidas.")
  @PostMapping
  public ResponseEntity<HospedeDto> createHospede(@RequestBody HospedeDto hospedeDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(hospedeService.save(hospedeDTO));
  }

  /**
   * Atualiza um hóspede existente.
   *
   * @param id ID do hóspede a ser atualizado.
   * @param hospedeDTO Objeto HospedeDto contendo os novos dados.
   * @return O HospedeDto atualizado.
   */
  @Operation(summary = "Atualizar hóspede", description = "Atualiza os detalhes de um hóspede existente com base no ID fornecido.")
  @PutMapping("/{id}")
  public ResponseEntity<HospedeDto> updateHospede(@PathVariable Long id, @RequestBody HospedeDto hospedeDTO) {
    return ResponseEntity.ok(hospedeService.update(id, hospedeDTO));
  }

  /**
   * Exclui um hóspede por ID.
   *
   * @param id ID do hóspede a ser excluído.
   * @return Resposta HTTP sem conteúdo.
   */
  @Operation(summary = "Excluir hóspede", description = "Remove um hóspede do sistema com base no ID fornecido.")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteHospede(@PathVariable Long id) {
    hospedeService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
