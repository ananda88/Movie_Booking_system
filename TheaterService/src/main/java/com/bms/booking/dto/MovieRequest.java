package com.bms.booking.dto;

public class MovieRequest {
	
	private Long id;
	
	private String name;
	
	private String genere;
	
	public MovieRequest() {
		// TODO Auto-generated constructor stub
	}
	
	

	public MovieRequest(Long id, String name, String genere) {
		super();
		this.id = id;
		this.name = name;
		this.genere = genere;
	}



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

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	

}
