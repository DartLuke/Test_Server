package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePaymentInfo {
    String ServiceType;
    String CommodityType;
    String Amount;

    public CreatePaymentInfo() {
    }

    public CreatePaymentInfo(String serviceType, String commodityType, String amount) {
        ServiceType = serviceType;
        CommodityType = commodityType;
        Amount = amount;
    }

    @JsonProperty("ServiceType")
    public String getServiceType() {
        return ServiceType;
    }

    @JsonProperty("CommodityType")
    public String getCommodityType() {
        return CommodityType;
    }

    @JsonProperty("Amount")
    public String getAmount() {
        return Amount;
    }
}
