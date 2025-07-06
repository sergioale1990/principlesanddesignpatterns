package org.example.domain.service;

import org.example.domain.entity.Product;
import org.example.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Clase encargada de realizar operaciones con los productos
@Service
public class ProductService {
    private final ProductRepository productRepository;

    //Constructor de la clase
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Metodo encargado de guardar un producto nuevo en la base de datos
    public Product save(Product product) {
        return productRepository.save(product);
    }

    //Metodo encargado de buscar todos los productos en la base de datos
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //Metodo encargado de buscar un producto por ID
    public Optional<Product> finById(Long id) {
        return productRepository.findById(id);
    }
}
