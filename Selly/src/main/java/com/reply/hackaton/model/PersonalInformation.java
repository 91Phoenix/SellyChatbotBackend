package com.reply.hackaton.model;

import java.time.LocalDate;

public class PersonalInformation {
	private String email;
	private LocalDate birth_date;
	private String address;
	private String city;
	private String telephon;
	private Geneder gender;
	private String name;
	private String surname;
	
	public PersonalInformation(String email, LocalDate birth_date, String address, String city, String telephon,
			Geneder gender, String name, String surname) {
		super();
		this.email = email;
		this.birth_date = birth_date;
		this.address = address;
		this.city = city;
		this.telephon = telephon;
		this.gender = gender;
		this.name = name;
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephon() {
		return telephon;
	}
	public void setTelephon(String telephon) {
		this.telephon = telephon;
	}
	public Geneder getGender() {
		return gender;
	}
	public void setGender(Geneder gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	

}
