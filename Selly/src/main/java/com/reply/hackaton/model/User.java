package com.reply.hackaton.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	public String getGeoFencing() {
		return geoFencing;
	}

	public void setGeoFencing(String geoFencing) {
		this.geoFencing = geoFencing;
	}

	@Id
	private String PAN;
	private LocalDate expirationDate;
	
	private int affinity;
	private String type;
	private int product;
	private String scheme;
	private int CAP;
	private String area;
	private int plafond;
	private String fiscalCode;
	private boolean SMS_alert;
	private boolean push_alert;
	private boolean threeDS;
	private boolean mysi_pay;
	private boolean ioSi;
	private boolean newsletter;
	private String email;
	private LocalDate birth_date;
	private String address;
	private String city;
	private String telephon;
	private Geneder gender;
	private String name;
	private String surname;
	private String geoFencing;

	public User() {
	}

	public User(String pAN, LocalDate expirationDate, int affinity, String type, int product, String scheme, int cAP,
			String area, int plafond, String fiscalCode, boolean sMS_alert, boolean push_alert, boolean threeDS,
			boolean mysi_pay, boolean ioSi, boolean newsletter, String email, LocalDate birth_date, String address,
			String city, String telephon, Geneder gender, String surname, String name, String geoFencing) {
		super();
		PAN = pAN;
		this.expirationDate = expirationDate;
		this.geoFencing = geoFencing;
		this.affinity = affinity;
		this.type = type;
		this.product = product;
		this.scheme = scheme;
		CAP = cAP;
		this.area = area;
		this.plafond = plafond;
		this.fiscalCode = fiscalCode;
		SMS_alert = sMS_alert;
		this.push_alert = push_alert;
		this.threeDS = threeDS;
		this.mysi_pay = mysi_pay;
		this.ioSi = ioSi;
		this.newsletter = newsletter;
		this.email = email;
		this.birth_date = birth_date;
		this.address = address;
		this.city = city;
		this.telephon = telephon;
		this.gender = gender;
		this.name = name;
		this.surname = surname;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getAffinity() {
		return affinity;
	}

	public void setAffinity(int affinity) {
		this.affinity = affinity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public int getCAP() {
		return CAP;
	}

	public void setCAP(int cAP) {
		CAP = cAP;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPlafond() {
		return plafond;
	}

	public void setPlafond(int plafond) {
		this.plafond = plafond;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public boolean isSMS_alert() {
		return SMS_alert;
	}

	public void setSMS_alert(boolean sMS_alert) {
		SMS_alert = sMS_alert;
	}

	public boolean isPush_alert() {
		return push_alert;
	}

	public void setPush_alert(boolean push_alert) {
		this.push_alert = push_alert;
	}

	public boolean isThreeDS() {
		return threeDS;
	}

	public void setThreeDS(boolean threeDS) {
		this.threeDS = threeDS;
	}

	public boolean isMysi_pay() {
		return mysi_pay;
	}

	public void setMysi_pay(boolean mysi_pay) {
		this.mysi_pay = mysi_pay;
	}

	public boolean isIoSi() {
		return ioSi;
	}

	public void setIoSi(boolean ioSi) {
		this.ioSi = ioSi;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
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

	@Override
	public String toString() {
		return "User [PAN=" + PAN + ", expirationDate=" + expirationDate + ", affinity=" + affinity + ", type=" + type
				+ ", product=" + product + ", scheme=" + scheme + ", CAP=" + CAP + ", area=" + area + ", plafond="
				+ plafond + ", fiscalCode=" + fiscalCode + ", SMS_alert=" + SMS_alert + ", push_alert=" + push_alert
				+ ", threeDS=" + threeDS + ", mysi_pay=" + mysi_pay + ", ioSi=" + ioSi + ", newsletter=" + newsletter
				+ ", email=" + email + ", birth_date=" + birth_date + ", address=" + address + ", city=" + city
				+ ", telephon=" + telephon + ", gender=" + gender + ", name=" + name + ", surname=" + surname + "]";
	}

}