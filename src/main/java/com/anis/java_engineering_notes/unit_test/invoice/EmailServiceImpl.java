package com.anis.java_engineering_notes.unit_test.invoice;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
	@Override
	public void sendConfirmation(Invoice invoice) {
		System.out.println("Sending email to " + invoice.getCustomerName());
	}
}
