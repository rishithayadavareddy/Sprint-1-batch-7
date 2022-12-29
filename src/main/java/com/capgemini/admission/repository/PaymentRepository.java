package com.capgemini.admission.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.dto.PaymentDTO;
import com.capgemini.admission.entity.Payment;
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {

	Optional<Payment> findByApplicationId(Integer applicationId);

	PaymentDTO getByPaymentId(int paymentId);
}
