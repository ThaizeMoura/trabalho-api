package com.trabalho.crud.outbound.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.crud.core.entity.Hospede;
import com.trabalho.crud.core.repository.HospedeRepository;

@Profile("!test")
public interface JpaHospedeRepository extends HospedeRepository, JpaRepository<Hospede, Long> {
}
