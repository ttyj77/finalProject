package com.ssag.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component("userVo")
@AllArgsConstructor
public class UserVo {

	
	private Integer code;
	
	private String id;
	private String password;
	private String role;
	private String name;
	private String email;
	private String telephone;
	private String address;
	private Integer companycode;
	private String companyname;
	private Integer frigeidid;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth;
	
	private boolean userLogin;
	
	public UserVo() {
		this.userLogin = false;
	}
	
}
