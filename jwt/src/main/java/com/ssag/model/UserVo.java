package com.ssag.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component("userVo")
@AllArgsConstructor
public class UserVo {

	
	private Integer code;
	
	private String username;
	private String password;
	private String role;//USER,ADMIN
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
	
	public List<String> getRoleList(){
		if(this.role.length() > 0) {
			return Arrays.asList(this.role.split(","));
		}
		return new ArrayList<>();
	}
	
}
