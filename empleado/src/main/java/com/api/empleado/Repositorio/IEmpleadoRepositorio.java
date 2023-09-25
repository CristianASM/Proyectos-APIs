package com.api.empleado.Repositorio;

import com.api.empleado.Modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
