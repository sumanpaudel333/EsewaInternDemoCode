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
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        productMap.put(product.getId(), product);
        return new ResponseEntity<>("Product added Successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/product")
    public ResponseEntity<Object> showProduct() {
        return new ResponseEntity<>(productMap.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
        productMap.remove(id);
        if (productMap.get(id)==null) {
            return new ResponseEntity<>("Product Deleted Successfully "+ productMap, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Could not Delete Product",HttpStatus.OK);
        }
        }
}
