package com.app.payment.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.payment.domain.IPaymentRepository;
import com.app.payment.domain.IPaymentService;
import com.app.payment.domain.Payment;

@Service
public class PaymentService implements IPaymentService {

    private final IPaymentRepository paymentRepository;

    public PaymentService(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with ID: " + id));
    }

    @Override
    @Transactional
    public Payment save(Payment user) {
        if (paymentRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("email registred: " + user.getEmail());
        }
        return paymentRepository.save(user);
    }

    @Override
    @Transactional
    public Payment update(Payment user, Long id) {
        Payment existingUser = findById(id);
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return paymentRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Payment user = findById(id);
        paymentRepository.delete(user);
    }
}
