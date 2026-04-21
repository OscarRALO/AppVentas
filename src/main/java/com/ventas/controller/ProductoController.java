    package com.ventas.controller;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.ventas.entities.Producto;
    import com.ventas.service.ProductoService;

    @RestController
    @RequestMapping("api/productos")
    public class ProductoController {
        @Autowired
        ProductoService productoService ;
        
        @GetMapping
        public Iterable<Producto> listar(){
            
            return productoService.findAll();
            
        }
        
        @PostMapping
        public Producto create(@RequestBody Producto producto) {
            
            return productoService.save(producto);
        }
        
        @GetMapping("{id}")
        public Producto get(@PathVariable Long id) {
        return productoService.findById(id).orElse(null);
        }
        
        // Editar o actualizar un producto
        @PutMapping("{id}")
        public Producto update(@PathVariable Long id, @RequestBody Producto producto) {
            Producto productoActual = productoService.findById(id).orElse(null);
            if (productoActual != null) {
                productoActual.setDescripcion(producto.getDescripcion());
                productoActual.setEstado(producto.getEstado());
                productoActual.setNombre(producto.getNombre());
                productoActual.setPreciocompra(producto.getPreciocompra());
                productoActual.setPrecioventa(producto.getPrecioventa());
                productoActual.setStock(producto.getStock());
                productoActual.setTalla(producto.getTalla());
                productoActual.setCategoria(producto.getCategoria());
                productoActual.setProveedor(producto.getProveedor());
                return productoService.save(productoActual);
            }
            return null;
        }

        // Eliminar un producto
        @DeleteMapping("{id}")
        public void delete(@PathVariable Long id) {
            Producto productoActual = productoService.findById(id).orElse(null);
            if (productoActual != null) {
                productoService.delete(productoActual);
            }
        }
    }
