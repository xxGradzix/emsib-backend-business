package com.emsib.emsib_backend_business.mockprocessing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MockAlertResponse {
    private String id = "1";
    private String deviceId = "2";
    private String timestamp = "Here will be a timestamp from Processing Module";
}
