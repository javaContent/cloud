package com.test.system.entity;

public class Msg {
	
	public Msg(String title,String content,String remark) {
		this.title = title;
		this.content = content;
		this.remark = remark;
	}
	
	private String title;
	
	private String content;
	
	private String remark;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
