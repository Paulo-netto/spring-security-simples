package br.com.estudo.security_simpes.controllers;

import br.com.estudo.security_simpes.domain.records.ProductRecord;
import br.com.estudo.security_simpes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductControllers {

    private final ProductService service;

    @GetMapping("/products/public/router")
    public ResponseEntity<List<?>> getAllProductsPublic(){
        var lista =  service.findAllProduct();
       return  lista.isEmpty() ?
               ResponseEntity.noContent().build() :
               ResponseEntity.ok(lista);
    }
    @GetMapping("/products/private/router")
    public ResponseEntity<List<?>> getAllProductsPrivate(){
        var lista =  service.findAllProduct();
        return  lista.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(lista);
    }

    @PostMapping("/products/save")
    public ResponseEntity<?> postProduct(@RequestBody ProductRecord record){
        return new ResponseEntity<>(service.saveProduct(record), HttpStatus.CREATED);
    }
}
