package com.test.system.api.entity;

import java.io.Serializable;

public class SysRole implements Serializable {
	
	/**
	 *  @Fields serialVersionUID :
	 */
	private static final long serialVersionUID = -8971529096677356965L;
	
	private Long id;
    private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    

}
