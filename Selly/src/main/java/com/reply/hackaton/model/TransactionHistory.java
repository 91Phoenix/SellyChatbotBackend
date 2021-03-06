package com.reply.hackaton.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionHistory {
	
	private String PAN;
	private double amount;
	private boolean e_comm;
	private String merchant_ID;
	private String merchant_name;
	private String city;
	private String postaCode;
	private boolean domestic;
	private boolean c_less;
	@Id
	private String transaction_ID;
	private LocalDate date;
	private LocalTime time;
	private int prod_cat;
	private String readableCategory;	
	public TransactionHistory(){}
	
	public TransactionHistory(String pAN, double amount, boolean e_comm, String merchant_ID, String merchant_name,
			String city, String postaCode, boolean domestic, boolean c_less, String transaction_ID, LocalDate date,LocalTime time, int prod_cat,String readableCategory) {
		super();
		this.PAN = pAN;
		this.amount = amount;
		this.e_comm = e_comm;
		this.merchant_ID = merchant_ID;
		this.merchant_name = merchant_name;
		this.city = city;
		this.postaCode = postaCode;
		this.domestic = domestic;
		this.c_less = c_less;
		this.transaction_ID = transaction_ID;
		this.prod_cat = prod_cat;
		this.date=date;
		this.readableCategory=readableCategory;
		this.time=time;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		this.PAN = pAN;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isE_comm() {
		return e_comm;
	}

	public void setE_comm(boolean e_comm) {
		this.e_comm = e_comm;
	}

	public String getMerchant_ID() {
		return merchant_ID;
	}

	public void setMerchant_ID(String merchant_ID) {
		this.merchant_ID = merchant_ID;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostaCode() {
		return postaCode;
	}

	public void setPostaCode(String postaCode) {
		this.postaCode = postaCode;
	}

	public boolean isDomestic() {
		return domestic;
	}

	public void setDomestic(boolean domestic) {
		this.domestic = domestic;
	}

	public boolean isC_less() {
		return c_less;
	}

	public void setC_less(boolean c_less) {
		this.c_less = c_less;
	}

	public String getTransaction_ID() {
		return transaction_ID;
	}

	public void setTransaction_ID(String transaction_ID) {
		this.transaction_ID = transaction_ID;
	}

	public int getProd_cat() {
		return prod_cat;
	}

	public void setProd_cat(int prod_cat) {
		this.prod_cat = prod_cat;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getReadableCategory() {
		return readableCategory;
	}

	public void setReadableCategory(String readableCategory) {
		this.readableCategory = readableCategory;
	}

	@Override
	public String toString() {
		return "TransactionHistory [PAN=" + PAN + ", amount=" + amount + ", e_comm=" + e_comm + ", merchant_ID="
				+ merchant_ID + ", merchant_name=" + merchant_name + ", city=" + city + ", postaCode=" + postaCode
				+ ", domestic=" + domestic + ", c_less=" + c_less + ", transaction_ID=" + transaction_ID + ", date="
				+ date + ", time=" + time + ", prod_cat=" + prod_cat + ", readableCategory=" + readableCategory + "]";
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	
}
