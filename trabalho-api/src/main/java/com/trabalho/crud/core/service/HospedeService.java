package com.trabalho.crud.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trabalho.crud.core.dto.HospedeDto;
import com.trabalho.crud.core.entity.Hospede; // Certifique-se de ter a entidade Hospede
import com.trabalho.crud.core.repository.HospedeRepository; // Certifique-se de ter um repositório para a entidade Hospede
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HospedeService {

  private final HospedeRepository hospedeRepository; // Repositório para a entidade Hospede

  public List<HospedeDto> findAll() {
    return hospedeRepository.findAll()
            .stream()
            .map(this::convertToDto)
            .toList();
  }

  public HospedeDto findById(Long id) {
    Optional<Hospede> hospede = hospedeRepository.findById(id);
    return hospede.map(this::convertToDto)
            .orElseThrow(() -> new RuntimeException("Hóspede não encontrado")); // Personalize a exceção se necessário
  }

  @Transactional
  public HospedeDto save(HospedeDto hospedeDTO) {
    Hospede hospede = convertToEntity(hospedeDTO);
    return convertToDto(hospedeRepository.save(hospede));
  }

  @Transactional
  public HospedeDto update(Long id, HospedeDto hospedeDTO) {
    Hospede hospede = hospedeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Hóspede não encontrado")); // Personalize a exceção se necessário
    updateHospedeFromDto(hospede, hospedeDTO); // Atualiza a entidade usando o DTO
    return convertToDto(hospedeRepository.save(hospede));
  }

  @Transactional
  public void deleteById(Long id) {
    hospedeRepository.deleteById(id);
  }

  private HospedeDto convertToDto(Hospede hospede) {
    return new HospedeDto(
            hospede.getId(),
            hospede.getName(),
            hospede.getEmail(),
            hospede.getQuarto(),
            hospede.getDataEntrada(),
            hospede.getDataSaida()
    );
  }

  private Hospede convertToEntity(HospedeDto hospedeDTO) {
    return new Hospede(
            hospedeDTO.getId(),
            hospedeDTO.getName(),
            hospedeDTO.getEmail(),
            hospedeDTO.getQuarto(),
            hospedeDTO.getDataEntrada(),
            hospedeDTO.getDataSaida()
    );
  }

  private void updateHospedeFromDto(Hospede hospede, HospedeDto hospedeDTO) {
    hospede.setName(hospedeDTO.getName());
    hospede.setEmail(hospedeDTO.getEmail());
    hospede.setQuarto(hospedeDTO.getQuarto());
    hospede.setDataEntrada(hospedeDTO.getDataEntrada());
    hospede.setDataSaida(hospedeDTO.getDataSaida());
  }
}
