package com.emsib.emsib_backend_business.mockprocessing;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/mock/processing")
public class MockProcessingController {
    @GetMapping("/health")
    public String getHealth() {
        return "Status: OK";
    }

    @GetMapping("/report")
    public ResponseEntity<MockReportResponse> getReport(String id) {
        MockReportResponse m = new MockReportResponse();
        return ResponseEntity.ok(m);
    }

    @GetMapping("/alert")
    public ResponseEntity<MockAlertResponse> getAlert(String id) {
        MockAlertResponse m = new MockAlertResponse();
        return ResponseEntity.ok(m);
    }

    @GetMapping("/summary")
    public String getSummary(String id) {
        return "Processing Module: You got a summary for a building id " + id;
    }
}
