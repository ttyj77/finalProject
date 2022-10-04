package com.kong.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CookDto {
	private String cook_id;
	private String name;
	private int company_code;
	private String how_to_make;
	private String link;
	

	
	
	

}
