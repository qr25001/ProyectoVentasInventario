package org.esfe.servicios.interfaces;

import org.esfe.dtos.detalleventa.DetalleVentaGuardar;
import org.esfe.dtos.detalleventa.DetalleVentaModificar;
import org.esfe.dtos.detalleventa.DetalleVentaSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDetalleVentaService {

    List<DetalleVentaSalida> obtenerTodos();

    Page<DetalleVentaSalida> obtenerTodosPaginados(Pageable pageable);

    DetalleVentaSalida obtenerPorId(Integer id);

    DetalleVentaSalida crear(DetalleVentaGuardar detalleVentaGuardar);

    DetalleVentaSalida editar(DetalleVentaModificar detalleVentaModificar);

    void eliminarPorId(Integer id);
}
