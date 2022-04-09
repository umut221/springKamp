package com.kalamarge.SpringKamp.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDto {
	
	private int id;
	private String productName;
	private String categoryName;
}
