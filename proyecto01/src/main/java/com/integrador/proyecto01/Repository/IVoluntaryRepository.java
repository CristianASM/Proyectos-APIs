package com.integrador.proyecto01.Repository;

import com.integrador.proyecto01.Model.Voluntary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVoluntaryRepository extends JpaRepository<Voluntary, Long> {
}
