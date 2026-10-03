package org.esfe.servicios.interfaces;

import org.esfe.dtos.venta.VentaGuardar;
import org.esfe.dtos.venta.VentaModificar;
import org.esfe.dtos.venta.VentaSalida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVentaService {

    List<VentaSalida> obtenerTodos();

    Page<VentaSalida> obtenerTodosPaginados(Pageable pageable);

    VentaSalida obtenerPorId(Integer id);

    VentaSalida crear(VentaGuardar ventaGuardar);

    VentaSalida editar(VentaModificar ventaModificar);

    void eliminarPorId(Integer id);
}
