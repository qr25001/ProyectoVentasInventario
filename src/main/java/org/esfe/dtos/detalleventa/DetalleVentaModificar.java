package org.esfe.dtos.detalleventa;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class DetalleVentaModificar implements Serializable {

    private Integer idDetalle;
    private Integer ventaId;
    private Integer productoId;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal subtotal;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }
}
