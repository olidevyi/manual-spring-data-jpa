package com.olidev.pe.manualspringdatajpa.repository;

import com.olidev.pe.manualspringdatajpa.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByIdAndActive(Long id, Integer active);
    public List<Client> findAll();
}
