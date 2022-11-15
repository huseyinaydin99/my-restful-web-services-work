package com.huseyinaydin;

public class UnvalidatedException extends Exception {

	private String hata;
	
	public UnvalidatedException(String arg0) {
		super(arg0);
		this.hata = arg0;
		// TODO Auto-generated constructor stub
	}
	
}
