package com.anis.java_engineering_notes.unit_test.invoice;

import lombok.Data;

@Data
public class Invoice {
	private Long id;
	private String customerName;
	private double amount;

	public Invoice() {
	}

	public Invoice(Long id, String customerName, double amount) {
		this.id = id;
		this.customerName = customerName;
		this.amount = amount;
	}
}
