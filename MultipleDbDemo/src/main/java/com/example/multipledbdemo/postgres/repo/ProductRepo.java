package com.example.multipledbdemo.postgres.repo;

import com.example.multipledbdemo.postgres.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
