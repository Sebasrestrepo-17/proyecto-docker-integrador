package com.app.payment.domain;

import java.util.List;

public interface IPaymentService {

    List<Payment> findAll();

    Payment findById(Long paymentId);

    Payment save(Payment payment);

    Payment update(Payment payment, Long paymentId);

    void deleteById(Long paymentId);
}

