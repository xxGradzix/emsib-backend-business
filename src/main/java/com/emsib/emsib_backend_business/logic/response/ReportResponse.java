package com.emsib.emsib_backend_business.logic.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {

    private String periodStart;
    private String periodEnd;
    private Summary summary;
    private String generatedBy;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Summary {
        private double mean;
        private double max;
        private double min;

        @JsonProperty("std_dev") // Maps the JSON "std_dev" to this Java field
        private double stdDev;
    }
}
