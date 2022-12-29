package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admission.dto.PaymentDTO;
import com.capgemini.admission.entity.Payment;
import com.capgemini.admission.exception.PaymentNotFoundException;
import com.capgemini.admission.repository.PaymentRepository;
import com.capgemini.admission.service.IPaymentService;

@Service
public class IPaymentServiceImpl implements IPaymentService {
	@Autowired
	private PaymentRepository repository;

	@Override
	public PaymentDTO savePayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		repository.save(payment);
		return paymentDTO;
	}

	@Override
	public PaymentDTO updatePayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		repository.save(payment);
		return paymentDTO;

	}

	@Override
	public boolean deletePayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDTO, payment);
		repository.delete(payment);
		return true;
	}

	@Override
	public PaymentDTO getPaymentDetailsbyApplicationId(Integer applicationId) {
		// TODO Auto-generated method stub
		Optional<Payment> payment = repository.findByApplicationId(applicationId);
		if (payment.isPresent()) {
			PaymentDTO dto = new PaymentDTO();
			BeanUtils.copyProperties(payment.get(), dto);
			return dto;
		}
		throw new PaymentNotFoundException("Payment with id" + applicationId + "doesn't exist");
		
	}

	@Override
	public List<PaymentDTO> viewAllPaymentDetails() {
		// TODO Auto-generated method stub
		Iterable<Payment>list = repository.findAll();		
		List<PaymentDTO>dtos=new ArrayList<>();
		for(Payment payment:list) {
		PaymentDTO dto=new PaymentDTO();
		BeanUtils.copyProperties(payment, dto);
		dtos.add(dto);
		}
		return dtos;

}

	@Override
	public PaymentDTO getByPaymentId(Integer paymentId) {
		// TODO Auto-generated method stub
		Optional<Payment>payment = repository.findById(paymentId);
		if (payment.isPresent()) {
			PaymentDTO dto = new PaymentDTO();
			BeanUtils.copyProperties(payment, dto);
			return dto;
		
	}
		throw new PaymentNotFoundException("Payment with id" + paymentId + "doesn't exist");
		
}

	

}