package com.apirestfull.ApiRESTfull.repositories;

import com.apirestfull.ApiRESTfull.model.Product;
import com.apirestfull.ApiRESTfull.model.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    //simulando o banco de dados
    private final List<Product> products = new ArrayList<Product>();
    private Long lastId = 0L;

    /** Metodo para retornar lista de produtos.
     * @return Lista de produtos.
     */
    public List<Product> findAll(){
        return products;
    }

    /** Metodo para retornar o produto com seu id.
     * @param id do produto que sera localizado.
     * @return produto caso seja encontrado.
     */
    public Optional<Product> findProductById(Long id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst(); // find first devolve um optional, ele devolve o que encontrar ou null
    }

    /** Metodo para adicionar produto na lista.
     * @param product que sera adicionado.
     * @return produto que foi adicionado na lista.
     */
    public Product addProduct(Product product){
        lastId++;
        product.setId(lastId);
        products.add(product);
        return product;
    }

    /** Metodo para deletar um produto na lista.
     * @param id que sera deletado.
     */
    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    /** Metodo para atualizar um produto na lista.
     * @param product que sera atualizado.
     * @return produto atualizado.
     */
    public Product updateProduct(Product product){

       Optional<Product> foundProduct = findProductById(product.getId());
        if(foundProduct.isEmpty()){
            throw new ResourceNotFoundException("Product not found!");
        }
        deleteProduct(product.getId());

        products.add(product);
        return product;
    }
}
