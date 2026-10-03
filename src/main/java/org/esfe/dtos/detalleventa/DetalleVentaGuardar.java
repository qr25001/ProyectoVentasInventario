package org.esfe.dtos.detalleventa;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class DetalleVentaGuardar implements Serializable {

    private Integer ventaId;
    private Integer productoId;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;
}
