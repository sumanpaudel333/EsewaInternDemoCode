package com.esewa.springbootdemo.controller;

import com.esewa.springbootdemo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {
    private static final Map<String, Product> productMap = new HashMap<>();

    static {
        Product sendMoney = new Product();
        sendMoney.setId("1");
        sendMoney.setProductName("send Money");
        productMap.put("Send Money", sendMoney);

        Product loadWallet = new Product();
        loadWallet.setId("2");
        loadWallet.setProductName("Load Wallet");
        productMap.put("Load Wallet", loadWallet);
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        productMap.put(product.getId(), product);
        return new ResponseEntity<>("Product added Successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/product")
    public ResponseEntity<Object> showProduct() {
        return new ResponseEntity<>(productMap.values(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/product/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        productMap.remove(id);
            return new ResponseEntity<>("Product Deleted Successfully " , HttpStatus.OK);
    }
    @PutMapping(value ="/product/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        productMap.remove(id);
        product.setId(id);
        productMap.put(id,product);
        return new ResponseEntity<>("Product Updated Successfully",HttpStatus.OK);
    }
}
