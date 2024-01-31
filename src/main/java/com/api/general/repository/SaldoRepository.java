package com.api.general.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.general.model.Saldo;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Long> {

}
