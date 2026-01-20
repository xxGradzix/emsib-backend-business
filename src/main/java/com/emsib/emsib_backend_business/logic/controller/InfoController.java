package com.emsib.emsib_backend_business.logic.controller;

import com.emsib.emsib_backend_business.logic.response.AlertResponse;
import com.emsib.emsib_backend_business.logic.response.ReportResponse;
import com.emsib.emsib_backend_business.mockprocessing.MockAlertResponse;
import com.emsib.emsib_backend_business.mockprocessing.MockProcessingController;
import com.emsib.emsib_backend_business.mockprocessing.MockReportResponse;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/info")
public class InfoController {
    private final RestClient restClient;

    // Spring injects the value from properties here
    public InfoController(@Value("${external.service.url}") String baseUrl) {
        this.restClient = RestClient.create(baseUrl);
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<ReportResponse> getReport(@PathVariable String id) {
        return restClient.get()
            .uri("/report/{building_id}", id)
            .retrieve()
            .toEntity(ReportResponse.class); // This works for single objects {}
}

    @GetMapping("/alert/{id}")
    public ResponseEntity<List<AlertResponse>> getAlert(@PathVariable String id) {
        return restClient.get()
            .uri("/alerts/{id}", id)
            .retrieve()
            .toEntity(new ParameterizedTypeReference<List<AlertResponse>>() {});
}
}
