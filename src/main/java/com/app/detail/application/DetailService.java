package com.app.detail.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;
import com.app.detail.domain.IDetailRepository;
import com.app.detail.domain.IDetailService;
import com.app.detail.domain.Detail;

@Service
public class DetailService implements IDetailService {

    private final IDetailRepository detailRepository;

    public DetailService(IDetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    @Override
    public Detail findById(Long id) {
        return detailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Detail not found with ID: " + id));
    }

    @Override
    @Transactional
    public Detail save(Detail detail) {
        return detailRepository.save(detail);
    }

    @Override
    @Transactional
    public Detail update(Detail detail, Long id) {
        Detail existingDetail = findById(id);
        existingDetail.setPedidoId(detail.getPedidoId());
        existingDetail.setProductoId(detail.getProductoId());
        existingDetail.setCantidad(detail.getCantidad());
        existingDetail.setPrecioUnitario(detail.getPrecioUnitario());
        existingDetail.setSubtotal(detail.getSubtotal());
        return detailRepository.save(existingDetail);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Detail detail = findById(id);
        detailRepository.delete(detail);
    }
}
