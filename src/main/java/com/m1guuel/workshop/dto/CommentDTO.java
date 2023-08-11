package com.m1guuel.workshop.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable{
	private String text;
	private Date date;
	private author aut;
	
	public CommentDTO() {
	}
	
	public CommentDTO(String text, Date date, author autho) {
		this.text = text;
		this.date = date;
		this.aut = autho;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public author getAuthor() {
		return aut;
	}
	public void setAuthor(author author) {
		this.aut = author;
	} 
	

}
