package org.esfe.servicios.implementaciones;

import org.esfe.dtos.usuario.UsuarioGuardar;
import org.esfe.dtos.usuario.UsuarioModificar;
import org.esfe.dtos.usuario.UsuarioSalida;
import org.esfe.modelos.Usuario;
import org.esfe.repositorios.IUsuarioRepository;
import org.esfe.servicios.interfaces.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UsuarioSalida> obtenerTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioSalida.class))
                .toList();
    }

    @Override
    public Page<UsuarioSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Usuario> usuarios = usuarioRepository.findAll(pageable);

        List<UsuarioSalida> usuariosDto = usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioSalida.class))
                .toList();

        return new PageImpl<>(
                usuariosDto,
                usuarios.getPageable(),
                usuarios.getTotalElements()
        );
    }

    @Override
    public UsuarioSalida obtenerPorId(Integer id) {
        return modelMapper.map(
                usuarioRepository.findById(id).get(),
                UsuarioSalida.class
        );
    }

    @Override
    public UsuarioSalida crear(UsuarioGuardar usuarioGuardar) {
        Usuario usuario = usuarioRepository.save(
                modelMapper.map(usuarioGuardar, Usuario.class)
        );

        return modelMapper.map(usuario, UsuarioSalida.class);
    }

    @Override
    public UsuarioSalida editar(UsuarioModificar usuarioModificar) {
        Usuario usuario = usuarioRepository.save(
                modelMapper.map(usuarioModificar, Usuario.class)
        );

        return modelMapper.map(usuario, UsuarioSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
