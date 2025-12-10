package com.emsib.emsib_backend_business.logic.controller;

import com.emsib.emsib_backend_business.mockprocessing.MockAlertResponse;
import com.emsib.emsib_backend_business.mockprocessing.MockProcessingController;
import com.emsib.emsib_backend_business.mockprocessing.MockReportResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/info")
public class InfoController {
    private MockProcessingController m;

    @GetMapping("/report/{id}")
    public ResponseEntity<MockReportResponse> getReport(@PathVariable String id) {
        return m.getReport(id);
    }

    @GetMapping("/alert/{id}")
    public ResponseEntity<MockAlertResponse> getAlert(@PathVariable String id) {
        return m.getAlert(id);
    }

    @GetMapping("/summary/{id}")
    public String getSummary(@PathVariable String id) {
        return m.getSummary(id);
    }
}
