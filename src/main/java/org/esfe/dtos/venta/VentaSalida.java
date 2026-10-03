package org.esfe.dtos.venta;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.usuario.UsuarioSalida;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class VentaSalida implements Serializable {

    private Integer idVenta;
    private LocalDateTime fecha;
    private UsuarioSalida usuario;
    private BigDecimal total;
}
