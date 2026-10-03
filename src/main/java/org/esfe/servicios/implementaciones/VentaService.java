package org.esfe.servicios.implementaciones;

import org.esfe.dtos.venta.VentaGuardar;
import org.esfe.dtos.venta.VentaModificar;
import org.esfe.dtos.venta.VentaSalida;
import org.esfe.modelos.Venta;
import org.esfe.repositorios.IVentaRepository;
import org.esfe.servicios.interfaces.IVentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<VentaSalida> obtenerTodos() {
        List<Venta> ventas = ventaRepository.findAll();

        return ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaSalida.class))
                .toList();
    }

    @Override
    public Page<VentaSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Venta> ventas = ventaRepository.findAll(pageable);

        List<VentaSalida> ventasDto = ventas.stream()
                .map(venta -> modelMapper.map(venta, VentaSalida.class))
                .toList();

        return new PageImpl<>(
                ventasDto,
                ventas.getPageable(),
                ventas.getTotalElements()
        );
    }

    @Override
    public VentaSalida obtenerPorId(Integer id) {
        return modelMapper.map(
                ventaRepository.findById(id).get(),
                VentaSalida.class
        );
    }

    @Override
    public VentaSalida crear(VentaGuardar ventaGuardar) {
        Venta venta = ventaRepository.save(
                modelMapper.map(ventaGuardar, Venta.class)
        );

        return modelMapper.map(venta, VentaSalida.class);
    }

    @Override
    public VentaSalida editar(VentaModificar ventaModificar) {
        Venta venta = ventaRepository.save(
                modelMapper.map(ventaModificar, Venta.class)
        );

        return modelMapper.map(venta, VentaSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        ventaRepository.deleteById(id);
    }
}
