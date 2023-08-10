package com.m1guuel.workshop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.m1guuel.workshop.dto.author;

@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Date data;
	private String title;
	private String body;
	private author autho;

	public Post() {
	}

	public Post(String id, Date date, String title, String body,author user) {
		this.id = id;
		this.data = date;
		this.title = title;
		this.body = body;
		this.autho = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public author getAutho() {
		return autho;
	}

	public void setAutho(author autho) {
		this.autho = autho;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}


}
