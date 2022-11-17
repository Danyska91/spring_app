package com.example.demo.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false, length = 100)
	private String producto;
	@Column(nullable = false)
	private BigDecimal price;
	@ManyToOne(optional = false)//muchos a Uno
	@JoinColumn(name= "category_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Category category;
	@Column(nullable = false)
	private Boolean deleted;
}

