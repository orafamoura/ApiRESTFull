package com.apirestfull.ApiRESTfull.services;

import com.apirestfull.ApiRESTfull.model.Product;
import com.apirestfull.ApiRESTfull.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired // spring devolve uma instancia pronta.
    private ProductRepository productRepository;

    /** Metodo para retornar lista de produtos.
     * @return Lista de produtos.
     */
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    /** Metodo para retornar o produto com seu id.
     * @param id do produto que sera localizado.
     * @return produto caso seja encontrado.
     */
    public Optional<Product> findProductById(Long id){
        return productRepository.findProductById(id);
    }

    /** Metodo para adicionar produto na lista.
     * @param product que sera adicionado.
     * @return produto que foi adicionado na lista.
     */
    public Product addProduct(Product product){
       return productRepository.addProduct(product);
    }

    /** Metodo para deletar um produto na lista.
     * @param id que sera deletado.
     */
    public void deleteProduct(Long id){
        productRepository.deleteProduct(id);
    }

    /** Metodo para atualizar um produto na lista.
     * @param product que sera atualizado.
     * @param id do produto.
     * @return produto atualizado.
     */
    public Product updateProduct(Long id, Product product){ //ele diferente dos outros recebe o id tambem

        product.setId(id); // o id nao vai no corpo do product, ele vai separado, o controller vai passar pra dentro do service separado.
        return productRepository.updateProduct(product);
    }

}
