package com.api.empleado.Servicio;

import com.api.empleado.Modelo.Empleado;
import com.api.empleado.Repositorio.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicioImpl implements IEmpleadoServicio{
    @Autowired
    private IEmpleadoRepositorio empleadoRepositorio;

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarPorId(Long id) {
        return empleadoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Empleado actualizarEmpleado(Long id, Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepositorio.deleteById(id);
    }
}
