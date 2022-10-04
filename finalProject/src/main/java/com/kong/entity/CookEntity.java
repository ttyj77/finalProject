package com.kong.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="cook")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CookEntity {
	@Id
	@Column(name="cook_id")
	private String cook_id; //레시피 아이디
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column
	private int company_code;
	@Column(nullable = false)
	private String how_to_make;
	@Column
	private String link;	
	
	
	
}
