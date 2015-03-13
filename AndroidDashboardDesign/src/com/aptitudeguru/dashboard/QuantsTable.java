package com.aptitudeguru.dashboard;

import java.util.Currency;
import java.util.Locale;

public class QuantsTable {

	
	int _quantsid;
	String _quantsques;
	String _quantscat;
	String _option1;
	String _option2;
	String _option3;
	String _option4;
	String _sol;

	Locale locale = Locale.getDefault();
	Currency localCurrency = Currency.getInstance(locale);
	String currencySymbol = localCurrency.getSymbol(locale);
	
	public QuantsTable() {

	}

	
	public QuantsTable(int quantssid, String quantsques, String quantscat,
			String option1, String option2, String option3, String option4,
			String sol) {
		this._quantsid = quantssid;
		this._quantsques = getLocalQues(quantsques);
		this._quantscat = quantscat;
		this._option1 = getLocalQues(option1);
		this._option2 = getLocalQues(option2);
		this._option3 = getLocalQues(option3);
		this._option4 = getLocalQues(option4);
		this._sol = sol;
	}

	public QuantsTable(String quantsques, String quantscat, String option1,
			String option2, String option3, String option4, String sol) {

		this._quantsques = getLocalQues(quantsques);
		this._quantscat = quantscat;
		this._option1 = getLocalQues(option1);
		this._option2 = getLocalQues(option2);
		this._option3 = getLocalQues(option3);
		this._option4 = getLocalQues(option4);
		this._sol = sol;
	}

	
	public int getID() {
		return this._quantsid;
	}


	public void setID(int quantsid) {
		this._quantsid = quantsid;
	}


	public String getQues() {
		return this._quantsques;
	}

	
	public void setQues(String quantsques) {
		String lQuest = getLocalQues(quantsques);
		this._quantsques = lQuest;
	}
	
	public String getLocalQues(String nonLocal){
		
		String localisedQuestion = nonLocal.replace("cachemoney.", currencySymbol);
		localisedQuestion = localisedQuestion.replace("cachemoney", currencySymbol);
		return localisedQuestion;
	}

	
	public String getCat() {
		return this._quantscat;
	}

	
	public void setCat(String quantscat) {
		this._quantscat = quantscat;
	}

	
	public String getOption1() {
		return this._option1;
	}

	public String getOption2() {
		return this._option2;
	}

	public String getOption3() {
		return this._option3;
	}

	public String getOption4() {
		return this._option4;
	}

	public String getSol() {
		return this._sol;
	}

	public void setSol(String sol) {
		this._sol = sol;
	}

	
	public void setOption1(String option1) {
		String lQuest = getLocalQues(option1);
		this._option1 = lQuest;
	}

	public void setOption2(String option2) {
		String lQuest = getLocalQues(option2);
		this._option2 = lQuest;
	}

	public void setOption3(String option3) {
		String lQuest = getLocalQues(option3);
		this._option3 = lQuest;
	}

	public void setOption4(String option4) {
		String lQuest = getLocalQues(option4);
		this._option4 = lQuest;
	}

}
