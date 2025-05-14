package com.app.payment.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

    @Override
    @NonNull
    List<Payment> findAll();

    @Override
    @NonNull
    Optional<Payment> findById(@NonNull Long paymentId);

    @Override
    @NonNull
    <S extends Payment> S save(@NonNull S payment);

    @Override
    boolean existsById(@NonNull Long paymentId);

    @Override
    void deleteById(@NonNull Long paymentId);

    // Optional: find all payments for a specific order
    List<Payment> findByOrderId(@NonNull Long orderId);
}
