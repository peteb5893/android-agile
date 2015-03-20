package com.aptitudeguru.dashboard;

public class SituationTable {

	int _situationid;
	int _scenarioid;
	String _situationtext;
	String _optionA;
	String _optionB;
	String _optionC;
	String _optionD;
	
	
	public SituationTable() {
		
	}
	
	public SituationTable(int situationid, int scenarioid, String situationtext,
			String optionA, String optionB, String optionC, String optionD) {
		
		this._situationid = situationid;
		this._scenarioid = scenarioid;
		this._situationtext = get_situationtext();
		this._optionA = get_optionA();
		this._optionB = get_optionB();
		this._optionC = get_optionC();
		this._optionD = get_optionD();
	}
	
	public int get_situationid() {
		return _situationid;
	}

	public void set_situationid(int _situationid) {
		this._situationid = _situationid;
	}

	public int get_scenarioid() {
		return _scenarioid;
	}

	public void set_scenarioid(int _scenarioid) {
		this._scenarioid = _scenarioid;
	}

	public String get_situationtext() {
		return _situationtext;
	}

	public void set_situationtext(String _situationtext) {
		this._situationtext = _situationtext;
	}

	public String get_optionA() {
		return _optionA;
	}

	public void set_optionA(String _optionA) {
		this._optionA = _optionA;
	}

	public String get_optionB() {
		return _optionB;
	}

	public void set_optionB(String _optionB) {
		this._optionB = _optionB;
	}

	public String get_optionC() {
		return _optionC;
	}

	public void set_optionC(String _optionC) {
		this._optionC = _optionC;
	}

	public String get_optionD() {
		return _optionD;
	}

	public void set_optionD(String _optionD) {
		this._optionD = _optionD;
	}

	
	
}
