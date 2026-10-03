package org.esfe.servicios.implementaciones;

import org.esfe.dtos.detalleventa.DetalleVentaGuardar;
import org.esfe.dtos.detalleventa.DetalleVentaModificar;
import org.esfe.dtos.detalleventa.DetalleVentaSalida;
import org.esfe.modelos.DetalleVenta;
import org.esfe.repositorios.IDetalleVentaRepository;
import org.esfe.servicios.interfaces.IDetalleVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService implements IDetalleVentaService {

    @Autowired
    private IDetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DetalleVentaSalida> obtenerTodos() {
        List<DetalleVenta> detallesVenta = detalleVentaRepository.findAll();

        return detallesVenta.stream()
                .map(detalleVenta -> modelMapper.map(detalleVenta, DetalleVentaSalida.class))
                .toList();
    }

    @Override
    public Page<DetalleVentaSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<DetalleVenta> detallesVenta = detalleVentaRepository.findAll(pageable);

        List<DetalleVentaSalida> detallesVentaDto = detallesVenta.stream()
                .map(detalleVenta -> modelMapper.map(detalleVenta, DetalleVentaSalida.class))
                .toList();

        return new PageImpl<>(
                detallesVentaDto,
                detallesVenta.getPageable(),
                detallesVenta.getTotalElements()
        );
    }

    @Override
    public DetalleVentaSalida obtenerPorId(Integer id) {
        return modelMapper.map(
                detalleVentaRepository.findById(id).get(),
                DetalleVentaSalida.class
        );
    }

    @Override
    public DetalleVentaSalida crear(DetalleVentaGuardar detalleVentaGuardar) {
        DetalleVenta detalleVenta = detalleVentaRepository.save(
                modelMapper.map(detalleVentaGuardar, DetalleVenta.class)
        );

        return modelMapper.map(detalleVenta, DetalleVentaSalida.class);
    }

    @Override
    public DetalleVentaSalida editar(DetalleVentaModificar detalleVentaModificar) {
        DetalleVenta detalleVenta = detalleVentaRepository.save(
                modelMapper.map(detalleVentaModificar, DetalleVenta.class)
        );

        return modelMapper.map(detalleVenta, DetalleVentaSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}
