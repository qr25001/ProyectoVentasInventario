package org.esfe.dtos.venta;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class VentaGuardar implements Serializable {

    private LocalDateTime fecha;
    private Integer usuarioId;
    private BigDecimal total;
}
