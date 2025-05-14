package com.app.detail.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.detail.domain.IDetailService;
import com.app.detail.domain.Detail;

@RestController
@RequestMapping("/api/details")
public class DetailController {

    private final IDetailService detailService;

    public DetailController(IDetailService detailService) {
        this.detailService = detailService;
    }

    // Get all details
    @GetMapping
    public ResponseEntity<List<Detail>> getAllDetails() {
        List<Detail> details = detailService.findAll();
        return ResponseEntity.ok(details);
    }

    // Get detail by ID
    @GetMapping("/{id}")
    public ResponseEntity<Detail> getDetailById(@PathVariable Long id) {
        Detail detail = detailService.findById(id);
        return ResponseEntity.ok(detail);
    }

    // Create detail
    @PostMapping
    public ResponseEntity<Detail> createDetail(@RequestBody Detail detail) {
        Detail newDetail = detailService.save(detail);
        return ResponseEntity.ok(newDetail);
    }

    // Update detail
    @PutMapping("/{id}")
    public ResponseEntity<Detail> updateDetail(@PathVariable Long id, @RequestBody Detail detail) {
        Detail updatedDetail = detailService.update(detail, id);
        return ResponseEntity.ok(updatedDetail);
    }

    // Delete detail
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetail(@PathVariable Long id) {
        detailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

