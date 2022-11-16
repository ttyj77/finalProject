package com.ssag.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("cookVo")
public class CookVo {

	private Integer code;
	private String name;
	private Integer companycode;
	private Integer serve;
	private String howtomake;
	private String link;
	private String imglink;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCompanycode() {
		return companycode;
	}
	public void setCompanycode(Integer companycode) {
		this.companycode = companycode;
	}
	public Integer getServe() {
		return serve;
	}
	public void setServe(Integer serve) {
		this.serve = serve;
	}
	public String getHowtomake() {
		return howtomake;
	}
	public void setHowtomake(String howtomake) {
		this.howtomake = howtomake;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImglink() {
		return imglink;
	}
	public void setImglink(String imglink) {
		this.imglink = imglink;
	}

	
}
