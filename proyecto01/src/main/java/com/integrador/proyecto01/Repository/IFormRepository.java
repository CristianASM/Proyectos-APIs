package com.integrador.proyecto01.Repository;

import com.integrador.proyecto01.Model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormRepository extends JpaRepository<Form, Long> {
}
