package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRequest {
    String ServiceSessionId;


    @JsonProperty("ServiceSessionId")
    public String getServiceSessionId() {
        return ServiceSessionId;
    }

    public void setServiceSessionId(String serviceSessionId) {
        ServiceSessionId = serviceSessionId;
    }

    public PaymentRequest() {
    }

    public PaymentRequest(String serviceSessionId) {
        ServiceSessionId = serviceSessionId;
    }




}
