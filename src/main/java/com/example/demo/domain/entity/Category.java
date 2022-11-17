package com.example.demo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Le indicamos que va hacer una entidad
@Entity
//Le indicamos el nombre de la tabla 
@Table(name = "categories")
@AllArgsConstructor //generamos el constructor
@NoArgsConstructor 
@Getter //generamos los getter
@Setter //generamos los setter 
public class Category {

	@Id //le indicamos el id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE) // el dato va hacer secuencial
	private Short id;
	@Column(nullable = false, length = 50)// le indicamos que el campo no es nullo
	private String nombre;
}

