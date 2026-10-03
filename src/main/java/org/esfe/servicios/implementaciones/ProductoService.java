package org.esfe.servicios.implementaciones;

import org.esfe.dtos.producto.ProductoGuardar;
import org.esfe.dtos.producto.ProductoModificar;
import org.esfe.dtos.producto.ProductoSalida;
import org.esfe.modelos.Producto;
import org.esfe.repositorios.IProductoRepository;
import org.esfe.servicios.interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoSalida> obtenerTodos() {
        List<Producto> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .toList();
    }

    @Override
    public Page<ProductoSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<Producto> productos = productoRepository.findAll(pageable);

        List<ProductoSalida> productosDto = productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .toList();

        return new PageImpl<>(
                productosDto,
                productos.getPageable(),
                productos.getTotalElements()
        );
    }

    @Override
    public ProductoSalida obtenerPorId(Integer id) {
        return modelMapper.map(
                productoRepository.findById(id).get(),
                ProductoSalida.class
        );
    }

    @Override
    public ProductoSalida crear(ProductoGuardar productoGuardar) {
        Producto producto = productoRepository.save(
                modelMapper.map(productoGuardar, Producto.class)
        );

        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public ProductoSalida editar(ProductoModificar productoModificar) {
        Producto producto = productoRepository.save(
                modelMapper.map(productoModificar, Producto.class)
        );

        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }
}
