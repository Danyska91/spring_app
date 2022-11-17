package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Product;


//consultas a la base de datos
@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	Product findProdroductByIdAndDeleted(Long id, Boolean deleted);
	
}