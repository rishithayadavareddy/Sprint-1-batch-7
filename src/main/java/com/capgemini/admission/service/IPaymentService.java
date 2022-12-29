package com.capgemini.admission.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.admission.dto.PaymentDTO;
import com.capgemini.admission.entity.Payment;

public interface IPaymentService {
	public PaymentDTO savePayment(PaymentDTO paymentDTO);

	public PaymentDTO updatePayment(PaymentDTO paymentDTO);

	public boolean deletePayment(PaymentDTO paymentDTO);
	public PaymentDTO getByPaymentId(Integer paymentId);

	public PaymentDTO getPaymentDetailsbyApplicationId(Integer applicationId);


	public List<PaymentDTO> viewAllPaymentDetails();
	

}
