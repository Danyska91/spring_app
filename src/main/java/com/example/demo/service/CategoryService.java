package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.entity.Category;
import com.example.demo.dto.CategoryDto;



public interface CategoryService {

	List<Category> findAllCategory(); //lista de categoria
	Category findCategoryById(Short id); //opbtener una categoria por id
	Category createCategory( CategoryDto categoryDto); //crear una categoria
	Category updateCategory(CategoryDto categoryDto);// actualizar una categoria por entidad
	void deleteCategoryById(Short id);
}
