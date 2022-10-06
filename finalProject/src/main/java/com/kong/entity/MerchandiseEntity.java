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
@Table(name="merchandise_list")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchandiseEntity {
	@Id
	@Column(name="code")
	private int code; //레시피 아이디
	
	@Column(nullable = true)
	private int company_code;
	
	@Column(nullable = true, length = 255)
	private String item_name;
	
	@Column(nullable = true)
	private int cost;
	
	@Column(nullable = true)
	private int out_of_stock;
	
	@Column(nullable = true, length = 255)
	private String link;
	
	@Column(nullable = true, length = 255)
	private String img_link;
}
