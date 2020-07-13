package com.testServer.model;

public class PaymentRequest {
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

    String ServiceSessionId;


}
