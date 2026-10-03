package org.esfe.controladores;

import org.esfe.dtos.detalleventa.DetalleVentaGuardar;
import org.esfe.dtos.detalleventa.DetalleVentaModificar;
import org.esfe.dtos.detalleventa.DetalleVentaSalida;
import org.esfe.servicios.interfaces.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
public class DetalleVentaController {

    @Autowired
    private IDetalleVentaService detalleVentaService;

    @GetMapping
    public ResponseEntity<Page<DetalleVentaSalida>> mostrarTodosPaginados(
            Pageable pageable) {

        Page<DetalleVentaSalida> detalles =
                detalleVentaService.obtenerTodosPaginados(pageable);

        if (detalles.hasContent()) {
            return ResponseEntity.ok(detalles);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<DetalleVentaSalida>> mostrarTodos() {

        List<DetalleVentaSalida> detalles =
                detalleVentaService.obtenerTodos();

        if (!detalles.isEmpty()) {
            return ResponseEntity.ok(detalles);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVentaSalida> buscarPorId(
            @PathVariable Integer id) {

        DetalleVentaSalida detalle =
                detalleVentaService.obtenerPorId(id);

        if (detalle != null) {
            return ResponseEntity.ok(detalle);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DetalleVentaSalida> crear(
            @RequestBody DetalleVentaGuardar detalleVentaGuardar) {

        DetalleVentaSalida detalle =
                detalleVentaService.crear(detalleVentaGuardar);

        return ResponseEntity.ok(detalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentaSalida> editar(
            @PathVariable Integer id,
            @RequestBody DetalleVentaModificar detalleVentaModificar) {

        detalleVentaModificar.setIdDetalle(id);

        DetalleVentaSalida detalle =
                detalleVentaService.editar(detalleVentaModificar);

        if (detalle != null) {
            return ResponseEntity.ok(detalle);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable Integer id) {

        detalleVentaService.eliminarPorId(id);

        return ResponseEntity.ok("Detalle de venta eliminado correctamente");
    }
}
