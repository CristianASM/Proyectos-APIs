package com.api.empleado.Controlador;

import com.api.empleado.Modelo.Empleado;
import com.api.empleado.Servicio.EmpleadoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicioImpl empleadoServicio;

    @PostMapping("/guardar")
    public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado){
        Empleado nuevoEmpleado = empleadoServicio.crearEmpleado(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }
    @GetMapping("/empleados")
    public ResponseEntity<List<Empleado>> mostrarEmpleados(){
        List<Empleado> listaEmpleados = empleadoServicio.listarEmpleados();
        return new ResponseEntity<>(listaEmpleados, HttpStatus.OK);
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Empleado> mostrarEmpleado(@PathVariable Long id){
        Empleado empleadoPorId = empleadoServicio.buscarPorId(id);
        return new ResponseEntity<>(empleadoPorId, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> mostrarEmpleado(@PathVariable Long id,@RequestBody Empleado empleado){
        Empleado empleadoActualizado = empleadoServicio.actualizarEmpleado(id, empleado);
        return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEmpleado(@PathVariable Long id){
        empleadoServicio.eliminarEmpleado(id);
    }
}
