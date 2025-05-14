package com.app.detail.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.detail.domain.IDetailRepository;
import com.app.detail.domain.Detail;

@Component
public class DetailDatasource {

    private final IDetailRepository detailRepository;

    public DetailDatasource(IDetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public List<Detail> findAll() {
        return detailRepository.findAll();
    }

    public Optional<Detail> findById(Long id) {
        return detailRepository.findById(id);
    }

    public Detail save(Detail detail) {
        return detailRepository.save(detail);
    }

    public Optional<Detail> update(Detail detail, Long id) {
        return detailRepository.findById(id).map(existingDetail -> {
            existingDetail.setPedidoId(detail.getPedidoId());
            existingDetail.setProductoId(detail.getProductoId());
            existingDetail.setCantidad(detail.getCantidad());
            existingDetail.setPrecioUnitario(detail.getPrecioUnitario());
            existingDetail.setSubtotal(detail.getSubtotal());
            return detailRepository.save(existingDetail);
        });
    }

    public boolean deleteById(Long id) {
        if (detailRepository.existsById(id)) {
            detailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
