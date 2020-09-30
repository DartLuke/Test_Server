package com.singleton;

import com.TestData.CheckList;
import com.testServer.model.ProcessPayment;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    private static Singleton instance;
    //private String GUID;
    private Map<String, ProcessPayment> processPaymentMap = new HashMap<>();
    private Map<String, Boolean> processPaymentCheck = new HashMap<>();
private boolean testEnabled;

    public boolean isTestEnabled() {
        return testEnabled;
    }

    public void setTestEnabled(boolean testEnabled) {
        this.testEnabled = testEnabled;
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void checkProcessPayment(String GUID) {
        processPaymentCheck.put(GUID, true);
    }

    public boolean isAllchecked() {
        return !processPaymentCheck.containsValue(false);
    }

    public void setGUID(String GUID) {
        processPaymentMap.put(GUID, new ProcessPayment());
        processPaymentCheck.put(GUID, false);

    }

    public void setProcessPaymentMap(ProcessPayment processPayment) {


            CheckList checkList = processPaymentMap.get(processPayment.getPaymentRequest().getServiceSessionId()).getCheckList();
        processPayment.setCheckList(checkList);

        processPaymentMap.put(processPayment.getPaymentRequest().getServiceSessionId(), processPayment);

    }

    public boolean isProcessPaymentMapEmpty() {
        return processPaymentMap.isEmpty();
    }

    public ProcessPayment getProcessPayment(String GUID) {
        return processPaymentMap.get(GUID);
    }

    ProcessPayment processPayment;

    public ProcessPayment getProcessPayment() {
        return processPayment;
    }

    public Map<String, ProcessPayment> getProcessPaymentMap() {
        return processPaymentMap;
    }

    public void setProcessPayment(ProcessPayment processPayment) {
        this.processPayment = processPayment;
    }
}
