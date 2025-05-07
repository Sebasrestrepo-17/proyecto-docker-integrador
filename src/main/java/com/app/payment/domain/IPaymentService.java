package com.app.payment.domain;

import java.util.List;

public interface IPaymentService {
    
    List<Payment> findAll();

    Payment findById(Long id);

    Payment save(Payment user);

    Payment update(Payment user, Long id);

    void deleteById(Long id);
}
