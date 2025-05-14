package com.app.detail.domain;

import java.util.List;

public interface IDetailService {
    
    List<Detail> findAll();

    Detail findById(Long id);

    Detail save(Detail detail);

    Detail update(Detail detail, Long id);

    void deleteById(Long id);
}
