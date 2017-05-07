package com.reply.hackaton.model;

import java.time.LocalDate;

public class User {
	
	private String PAN;
	private LocalDate  expirationDate;
	private int affinity;
	private String type;
	private int product;
	private char scheme;
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
	private PersonalInformation personalInformation;
	
	public User(String pAN, LocalDate expirationDate, int affinity, String type, int product, char scheme, int cAP,
			String area, int plafond, String fiscalCode, boolean sMS_alert, boolean push_alert, boolean threeDS,
			boolean mysi_pay, boolean ioSi, boolean newsletter, PersonalInformation personalInformation) {
		super();
		this.PAN = pAN;
		this.expirationDate = expirationDate;
		this.affinity = affinity;
		this.type = type;
		this.product = product;
		this.scheme = scheme;
		this.CAP = cAP;
		this.area = area;
		this.plafond = plafond;
		this.fiscalCode = fiscalCode;
		this.SMS_alert = sMS_alert;
		this.push_alert = push_alert;
		this.threeDS = threeDS;
		this.mysi_pay = mysi_pay;
		this.ioSi = ioSi;
		this.newsletter = newsletter;
		this.personalInformation = personalInformation;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		this.PAN = pAN;
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

	public char getScheme() {
		return scheme;
	}

	public void setScheme(char scheme) {
		this.scheme = scheme;
	}

	public int getCAP() {
		return CAP;
	}

	public void setCAP(int cAP) {
		this.CAP = cAP;
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
		this.SMS_alert = sMS_alert;
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

	public PersonalInformation getPersonalInformation() {
		return personalInformation;
	}

	public void setPersonalInformation(PersonalInformation personalInformation) {
		this.personalInformation = personalInformation;
	}
	
	

}