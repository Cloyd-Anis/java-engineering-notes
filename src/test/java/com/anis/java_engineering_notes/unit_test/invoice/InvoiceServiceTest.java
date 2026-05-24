package com.anis.java_engineering_notes.unit_test.invoice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceTest {

	@Mock
	InvoiceRepository invoiceRepository;

	@Mock
	EmailService emailService;

	@InjectMocks
	InvoiceService invoiceService;


	@Test
	void shouldReturnInvoiceWhenFound() {
		// Arrange
		Invoice expected = new Invoice(1L, "Cloyd", 90000);
		when(invoiceRepository.findById(1L)).thenReturn(Optional.of(expected));

		// Act
		Invoice result = invoiceService.getInvoice(1L);

		// Assert
		assertEquals(expected, result);
		verify(invoiceRepository).findById(1L);
	}

	@Test
	void shouldThrowRuntimeExceptionWhenInvoiceNotFound() {
		when(invoiceRepository.findById(1L)).thenReturn(Optional.empty());
		Assertions.assertThrows(RuntimeException.class, () -> invoiceService.getInvoice(1L));
	}

	@Test
	void shouldCallEmailServiceExactlyOnce() {
		// Arrange
		Invoice invoice = new Invoice(1L, "Cloyd", 90000);
		when(invoiceRepository.findById(1L)).thenReturn(Optional.of(invoice));

		// Act
		invoiceService.processAndNotify(1L);

		// Assert
		verify(emailService, times(1)).sendConfirmation(invoice);
	}
}
