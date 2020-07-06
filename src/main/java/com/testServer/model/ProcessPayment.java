package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProcessPayment {

    private RoutingNode[] Route;
    private String CallbackUrl; 		        // process command url
    private PaymentRequest PaymentRequest;	        // json body
    private String NodeId;           		// request reference identification

@JsonIgnore
private int counter=-1;


    public RoutingNode[] Route() {
        return Route;
    }

    public void setRoute(RoutingNode[] routingNode) {
        this.Route = routingNode;
    }

    public String getCallbackUrl() {
        return CallbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        CallbackUrl = callbackUrl;
    }

    public PaymentRequest getPaymentRequest() {
        return PaymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        PaymentRequest = paymentRequest;
    }

    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ProcessPayment() {
    }

    public ProcessPayment(RoutingNode[] Route, String callbackUrl, PaymentRequest paymentRequest, String nodeId, String route, int counter) {
        this.Route = Route;
        CallbackUrl = callbackUrl;
        PaymentRequest = paymentRequest;
        NodeId = nodeId;
        this.counter = counter;
    }

    //**************************************************************************************
    public void counterPlus()
    {
        counter++;
    }

    public boolean isEndOfArray()
    {
        return !(counter<Route.length);
    }

    public String getNodeFromArray()
    {
        return Route[counter].getNodeId();
    }
}
