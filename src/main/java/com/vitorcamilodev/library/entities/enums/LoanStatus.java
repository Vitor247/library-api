package com.vitorcamilodev.library.entities.enums;

public enum LoanStatus {

	ACTIVE(1),
	RETURNED(2),
	OVERDUE(3);
	
	private int code;
	
	private LoanStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static LoanStatus valueOf(int code) {
		for(LoanStatus value: LoanStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid loan status code");
	}
	
}