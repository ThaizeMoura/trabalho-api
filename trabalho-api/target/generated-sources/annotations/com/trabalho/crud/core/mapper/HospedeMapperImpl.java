package com.trabalho.crud.core.mapper;

import com.trabalho.crud.core.dto.HospedeDto;
import com.trabalho.crud.core.entity.Hospede;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-13T17:38:46-0300",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class HospedeMapperImpl implements HospedeMapper {

    @Override
    public Hospede toEntity(HospedeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Hospede hospede = new Hospede();

        return hospede;
    }

    @Override
    public HospedeDto toDto(Hospede entity) {
        if ( entity == null ) {
            return null;
        }

        HospedeDto hospedeDto = new HospedeDto();

        return hospedeDto;
    }
}
