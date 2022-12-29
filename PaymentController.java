package com.capgemini.admission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.admission.dto.PaymentDTO;
import com.capgemini.admission.exception.PaymentNotFoundException;
import com.capgemini.admission.service.IApplicationService;
import com.capgemini.admission.service.IPaymentService;

@RestController
@RequestMapping(("/api/payment"))
public class PaymentController {
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private IApplicationService applicationService;
	@PostMapping
	public ResponseEntity<PaymentDTO>addPayment(@RequestBody PaymentDTO paymentDTO){
	
			PaymentDTO payment=paymentService.savePayment(paymentDTO);
			return ResponseEntity.ok(payment);

	}
	@GetMapping("/{paymentId}")
	public ResponseEntity<PaymentDTO>getPaymentById(@PathVariable int paymentId){
		PaymentDTO paymentDTO=paymentService.getByPaymentId(paymentId);
		return new ResponseEntity<PaymentDTO>(paymentDTO,HttpStatus.FOUND);
		
	}
	@PutMapping
	public ResponseEntity<PaymentDTO>updatePayment(@RequestBody PaymentDTO paymentDTO){
		
			PaymentDTO payment=paymentService.updatePayment(paymentDTO);
			return ResponseEntity.ok(payment);
			
		
	}
	@DeleteMapping("/{paymentId}")
	public ResponseEntity<Boolean>deletePaymentById(@PathVariable Integer paymentId){
		PaymentDTO paymentDTO=paymentService.getByPaymentId(paymentId);
		if(paymentDTO!=null) {
			paymentService.deletePayment(paymentDTO);
			return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
	}
		throw new PaymentNotFoundException("Payment with id"+paymentId+"doesn't exist");
	}
	@GetMapping
	public ResponseEntity<List<PaymentDTO>>getAllPaymentDetails(){
		List<PaymentDTO>list=paymentService.viewAllPaymentDetails();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/application/{paymentId}")
	public ResponseEntity<PaymentDTO>getPaymentByApplication(@PathVariable Integer paymentId){
		PaymentDTO payment=paymentService.getPaymentDetailsbyApplicationId(paymentId);
		return ResponseEntity.ok(payment);
	}
	
	
	
	

}
