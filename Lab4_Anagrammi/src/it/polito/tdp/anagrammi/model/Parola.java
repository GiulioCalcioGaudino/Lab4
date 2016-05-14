package it.polito.tdp.anagrammi.model;

public class Parola {

	private String parola;
	private Boolean corretta;
	
	public Parola(String parola, Boolean corretta) {
		this.parola = parola;
		this.corretta = corretta;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public Boolean getCorretta() {
		return corretta;
	}

	public void setCorretta(Boolean corretta) {
		this.corretta = corretta;
	}
	
	
	
}
