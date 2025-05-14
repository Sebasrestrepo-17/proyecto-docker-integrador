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

    // Search for a detail by PedidoID
    Optional<Detail> findByPedidoId(Long pedidoId);

    // Search for a detail by ProductoID
    Optional<Detail> findByProductoId(Long productoId);

    // Check if a PedidoID exists
    boolean existsByPedidoId(Long pedidoId);

    // Check if a ProductoID exists
    boolean existsByProductoId(Long productoId);
}
