package org.esfe.controladores;

import org.esfe.dtos.venta.VentaGuardar;
import org.esfe.dtos.venta.VentaModificar;
import org.esfe.dtos.venta.VentaSalida;
import org.esfe.servicios.interfaces.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<Page<VentaSalida>> mostrarTodosPaginados(Pageable pageable) {

        Page<VentaSalida> ventas =
                ventaService.obtenerTodosPaginados(pageable);

        if (ventas.hasContent()) {
            return ResponseEntity.ok(ventas);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<VentaSalida>> mostrarTodos() {

        List<VentaSalida> ventas =
                ventaService.obtenerTodos();

        if (!ventas.isEmpty()) {
            return ResponseEntity.ok(ventas);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaSalida> buscarPorId(
            @PathVariable Integer id) {

        VentaSalida venta =
                ventaService.obtenerPorId(id);

        if (venta != null) {
            return ResponseEntity.ok(venta);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<VentaSalida> crear(
            @RequestBody VentaGuardar ventaGuardar) {

        VentaSalida venta =
                ventaService.crear(ventaGuardar);

        return ResponseEntity.ok(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaSalida> editar(
            @PathVariable Integer id,
            @RequestBody VentaModificar ventaModificar) {

        ventaModificar.setIdVenta(id);

        VentaSalida venta =
                ventaService.editar(ventaModificar);

        if (venta != null) {
            return ResponseEntity.ok(venta);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(
            @PathVariable Integer id) {

        ventaService.eliminarPorId(id);

        return ResponseEntity.ok("Venta eliminada correctamente");
    }
}

