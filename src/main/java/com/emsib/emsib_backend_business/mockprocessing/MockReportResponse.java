package com.emsib.emsib_backend_business.mockprocessing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MockReportResponse {
    private String periodStart = "01.01.2026";
    private String periodEnd = "10.10.2026";
    private String summary = "This is just a mock summary";
    private String generateBy = "system";
}
