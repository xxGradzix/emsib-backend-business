package com.emsib.emsib_backend_business.mocksecurity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MockAuthResponse {
    private String token = "THEORETICALMOCKTOKEN";
}
