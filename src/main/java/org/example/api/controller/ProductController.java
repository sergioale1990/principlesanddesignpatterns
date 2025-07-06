package org.example.api.controller;

import org.example.domain.entity.Product;
import org.example.domain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


//Controlador REST para la entidad Producto
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    //Contructor de la clase
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Metodo encargado de crear un producto nuevo
    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        URI location = URI.create("/api/products/" + savedProduct.getId());
        return ResponseEntity.created(location).body(savedProduct);
    }

    //Metodo encargado de obtener la lista de productos
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    //Metodo encargado de obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.finById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
