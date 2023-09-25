package com.api.empleado.Servicio;

import com.api.empleado.Modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {

    Empleado crearEmpleado(Empleado empleado);

    List<Empleado> listarEmpleados();

    Empleado buscarPorId(Long id);

    Empleado actualizarEmpleado(Long id, Empleado empleado);

    void eliminarEmpleado(Long id);
}
