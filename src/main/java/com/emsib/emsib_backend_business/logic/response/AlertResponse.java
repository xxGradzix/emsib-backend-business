package com.emsib.emsib_backend_business.logic.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AlertResponse {
    @JsonProperty("_id") // This maps the JSON "_id" to this field
    private String id;
    
    private String deviceId;
    private String type;
    private String message;
    private String timestamp; // Using String for now to avoid date parsing hangs
    private String severity;
    private boolean resolved;
}
