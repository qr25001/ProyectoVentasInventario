package org.esfe.dtos.usuario;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioSalida implements Serializable {

    private Integer idUsuario;
    private String nombre;
    private String email;
    private String contraseña;
    private String rol;
}
