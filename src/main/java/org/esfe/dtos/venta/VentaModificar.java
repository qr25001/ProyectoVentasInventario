package org.esfe.dtos.venta;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class VentaModificar implements Serializable {

    private Integer idVenta;
    private LocalDateTime fecha;
    private Integer usuarioId;
    private BigDecimal total;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
}
