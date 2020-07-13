package com.singleton;

import com.testServer.model.ProcessPayment;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    private static Singleton instance;
    //private String GUID;
    private Map<String,ProcessPayment> processPaymentMap= new HashMap<>();
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void setGUID(String GUID) {
       processPaymentMap.put(GUID,null);

    }

    public void setProcessPaymentMap(ProcessPayment processPayment) {
       processPaymentMap.put(processPayment.getPaymentRequest().getServiceSessionId(),processPayment);

    }

    public ProcessPayment getProcessPayment(String GUID) {
        return processPaymentMap.get(GUID);
    }

    ProcessPayment processPayment;

    public ProcessPayment getProcessPayment() {
        return processPayment;
    }

    public void setProcessPayment(ProcessPayment processPayment) {
        this.processPayment = processPayment;
    }
}
