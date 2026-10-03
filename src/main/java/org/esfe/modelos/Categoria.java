package org.esfe.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
}
