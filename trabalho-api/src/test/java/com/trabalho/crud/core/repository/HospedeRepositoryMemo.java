package com.trabalho.crud.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.trabalho.crud.core.entity.Hospede;

@Repository
public class HospedeRepositoryMemo implements HospedeRepository {

  private final List<Hospede> hospedes = new ArrayList<>();

  @Override
  public List<Hospede> findAll() {
    return new ArrayList<>(hospedes);
  }

  @Override
  public Optional<Hospede> findById(Long id) {
    return hospedes.stream()
            .filter(hospede -> hospede.getId().equals(id))
            .findFirst();
  }

  @Override
  public Hospede save(Hospede hospede) {
    hospede.setId((long) (hospedes.size() + 1)); // Simples auto-increment
    hospedes.add(hospede);
    return hospede;
  }

  @Override
  public void deleteById(Long id) {
    hospedes.removeIf(hospede -> hospede.getId().equals(id));
  }

  @Override
  public List<Hospede> findByNome(String name) {
    return hospedes.stream()
            .filter(hospede -> hospede.getName().equalsIgnoreCase(name))
            .toList();
  }

  @Override
  public Optional<Hospede> findByEmail(String email) {
    return hospedes.stream()
            .filter(hospede -> hospede.getEmail().equalsIgnoreCase(email))
            .findFirst();
  }

  @Override
  public long count() {
    return hospedes.size();
  }

  @Override
  public void deleteAllInBatch(Iterable<Hospede> entities) {
    for (Hospede hospede : entities) {
      hospedes.remove(hospede);
    }
  }

  @Override
  public void flush() {
    // Método não necessário para a implementação em memória
  }

  @Override
  public List<Hospede> saveAll(Iterable<Hospede> entities) {
    List<Hospede> saved = new ArrayList<>();
    for (Hospede hospede : entities) {
      saved.add(save(hospede));
    }
    return saved;
  }

  @Override
  public void deleteAllByIdInBatch(Iterable<Long> ids) {
    for (Long id : ids) {
      deleteById(id);
    }
  }

}
