package com.trabalho.crud.core.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Adiciona um construtor sem argumentos
@AllArgsConstructor // Adiciona um construtor com todos os argumentos
public class HospedeDto {

  private Long id;
  private String name;
  private String email;
  private String quarto;
  private String dataEntrada;
  private String dataSaida;
}
