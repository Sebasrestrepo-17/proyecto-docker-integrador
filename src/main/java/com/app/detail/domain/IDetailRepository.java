package com.app.detail.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailRepository extends JpaRepository<Detail, Long> {

    // Get all details (already provided by JpaRepository)
    @Override
    @NonNull
    List<Detail> findAll();

    // Search detail by ID (already provided by JpaRepository)
    @Override
    @NonNull
    Optional<Detail> findById(@NonNull Long id);

    // Save a detail (already provided by JpaRepository)
    @Override
    @NonNull
    <S extends Detail> S save(@NonNull S detail);

    // Check if a detail with a specific ID exists (already provided by JpaRepository)
    @Override
    boolean existsById(@NonNull Long id);

    // Delete detail by ID (already provided by JpaRepository)
    @Override
    void deleteById(@NonNull Long id);

    // Additional application-specific methods:

    // Search for a detail by orderId
    Optional<Detail> findByOrderId(Long orderId);

    // Search for a detail by productId
    Optional<Detail> findByProductId(Long productId);

    // Check if an orderId exists
    boolean existsByOrderId(Long orderId);

    // Check if a productId exists
    boolean existsByProductId(Long productId);
}

