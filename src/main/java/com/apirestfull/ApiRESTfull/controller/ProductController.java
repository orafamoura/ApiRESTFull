package com.apirestfull.ApiRESTfull.controller;


import com.apirestfull.ApiRESTfull.model.Product;
import com.apirestfull.ApiRESTfull.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping // quando alguem for fazer alguma consulta no /products aparece esse metodo
    public List<Product> FindAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findProductById(@PathVariable Long id){ //path variable, pega o id no getMapping, e tenta transforma-lo no long id
        return productService.findProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){ //request body ele tenta converter o que escrevemos em JSON em product
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Product was successfully deleted";
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){ //request body pra converter o JSON em product
        return productService.updateProduct(id, product);
    }


}
