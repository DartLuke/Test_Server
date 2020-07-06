package com.testServer.model;

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

    public String getServiceType() {
        return ServiceType;
    }

    public String getCommodityType() {
        return CommodityType;
    }

    public String getAmount() {
        return Amount;
    }
}
