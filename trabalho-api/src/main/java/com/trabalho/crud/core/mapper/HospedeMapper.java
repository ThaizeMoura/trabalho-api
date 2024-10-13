package com.trabalho.crud.core.mapper;

import com.trabalho.crud.core.entity.Hospede;
import org.mapstruct.Mapper;

import com.trabalho.crud.core.dto.HospedeDto;
import com.trabalho.crud.core.entity.Hospede;

@Mapper(componentModel = "spring")
public interface HospedeMapper {

  Hospede toEntity(HospedeDto dto);

  HospedeDto toDto(Hospede entity);
  
}
