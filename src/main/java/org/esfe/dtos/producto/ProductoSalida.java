package org.esfe.dtos.producto;

import lombok.Getter;
import lombok.Setter;
import org.esfe.dtos.categoria.CategoriaSalida;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductoSalida implements Serializable {

    private Integer idProducto;
    private String codigo;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private Integer stockMinimo;
    private CategoriaSalida categoria;
}
