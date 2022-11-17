package com.example.demo.implement;


import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Category;
import com.example.demo.dto.CategoryDto;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService{
	
	
	private final CategoryRepository categoryRepository;
	
	private void categoryExist(String name) {
		if(categoryRepository.existByName(name)) {
			throw new DuplicateKeyException("the name of category is already registered");
		}
	}
	@Override
	public List<Category> findAllCategory() {
		
		return (List<Category>)categoryRepository.findAll();
	}

	@Override
	public Category findCategoryById(Short id) {
		Category category = categoryRepository.findCategoryById(id);
		if (category == null) {
			throw new EntityNotFoundException("the category whit id "+ id + "not found");
		}
		return null;
	}

	@Override
	public Category createCategory(CategoryDto categoryDto) {
		Category category = new Category();
		this.categoryExist(categoryDto.getNombre());
		BeanUtils.copyProperties(categoryDto, category);//se copian las propiedades de category dto a category
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(CategoryDto categoryDto) {
		Category category= new Category();
		BeanUtils.copyProperties(categoryDto, category);
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(Short id) {
		this.findCategoryById(id);
		categoryRepository.deleteById(id);
	}

}

