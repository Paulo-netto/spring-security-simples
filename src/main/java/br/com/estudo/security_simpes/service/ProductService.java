package br.com.estudo.security_simpes.service;

import br.com.estudo.security_simpes.domain.Product;
import br.com.estudo.security_simpes.domain.records.ProductRecord;
import br.com.estudo.security_simpes.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product saveProduct(ProductRecord record){
        var product = new Product();
        BeanUtils.copyProperties(record, product);
        return productRepository.save(product);
    }

    public Product findProductById(Long id) throws Exception {
        return productRepository.findById(id).orElseThrow(() -> new Exception("Produto nao encontrato"));
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
}
