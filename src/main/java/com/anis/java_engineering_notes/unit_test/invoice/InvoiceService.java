package com.anis.java_engineering_notes.unit_test.invoice;

import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

	private final InvoiceRepository invoiceRepository;
	private final EmailService emailService;

	public InvoiceService(InvoiceRepository invoiceRepository,
			EmailService emailService) {
		this.invoiceRepository = invoiceRepository;
		this.emailService = emailService;
	}

	public Invoice getInvoice(Long id) {
		return invoiceRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Invoice not found"));
	}

	public void processAndNotify(Long id) {
		Invoice invoice = getInvoice(id);
		emailService.sendConfirmation(invoice);
	}
}

