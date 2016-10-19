package com.lining.struts2;

public class book {
	private String isbn;
	private String title;
	private String authorid;
	private String publisher;
	private String publishdata;
	private String price;
	
	public String author;
	
	book(){}
	book(String authorid, String title,
		 String publisher, String publishdata,
		 String price, String isbn	){
		this.isbn = isbn;
		this.title = title;
		this.authorid = authorid;
		this.publisher = publisher;
		this.publishdata = publishdata;
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishdata() {
		return publishdata;
	}

	public void setPublishdata(String publishdata) {
		this.publishdata = publishdata;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
