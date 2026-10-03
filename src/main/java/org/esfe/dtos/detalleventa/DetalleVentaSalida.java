package org.esfe.dtos.detalleventa;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.producto.ProductoSalida;
import org.esfe.dtos.venta.VentaSalida;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class DetalleVentaSalida implements Serializable {

    private Integer idDetalle;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;
    private VentaSalida venta;
    private ProductoSalida producto;
}
