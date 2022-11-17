package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.Category;
import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/categories") 
@RequiredArgsConstructor
public class CategoryController {
	
private final CategoryService categoryService;


@GetMapping(produces = "application/json")
public ResponseEntity<List<Category>> gtAllCategory(){
	return new ResponseEntity<>(categoryService.findAllCategory(), HttpStatus.OK);
}

@GetMapping(value = "{/id}", produces = "application/json")
public ResponseEntity<Category> getCategoryById(@PathVariable("id") Short id){
	return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.OK);
}

@PostMapping(consumes = "application/json", produces = "application/json")
public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
	return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
}
@PostMapping(consumes = "application/json", produces = "application/json")
public ResponseEntity<Category> updateCategory(@RequestBody CategoryDto categoryDto){
	return new ResponseEntity<>(categoryService.updateCategory(categoryDto), HttpStatus.OK);
}
@DeleteMapping("/{id}")
public ResponseEntity deleteCategoryById(@PathVariable("id") Short id) {
	categoryService.deleteCategoryById(id);
	return new ResponseEntity(HttpStatus.OK);
}

}
