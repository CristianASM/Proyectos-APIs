package com.integrador.proyecto01.Repository;

import com.integrador.proyecto01.Model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscriptionRepository extends JpaRepository<Inscription, Long> {
}
