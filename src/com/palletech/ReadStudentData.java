package com.palletech;

public class ReadStudentData {

	private int no;
	private String name;
	private String subs;
	private String semail;
	
	public ReadStudentData(int no, String name, String subs, String semail) {
		super();
		this.no = no;
		this.name = name;
		this.subs = subs;
		this.semail = semail;
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubs() {
		return subs;
	}
	public void setSubs(String subs) {
		this.subs = subs;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	
	

	}


