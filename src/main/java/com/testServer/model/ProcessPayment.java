package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessPayment {

    private RoutingNode[] Route;
    private String CallbackUrl;                // process command url
    private PaymentRequest PaymentRequest;            // json body
    private String NodeId;                // request reference identification
    private String StatusCallbackUrl;

    @JsonProperty("StatusCallbackUrl")
    public String getStatusCallbackUrl() {
        return StatusCallbackUrl;
    }

    public void setStatusCallbackUrl(String statusCallbackUrl) {
        StatusCallbackUrl = statusCallbackUrl;
    }



    @JsonIgnore
    private int counter = -1;


    @JsonProperty("Route")
    public RoutingNode[] getRoute() {
        return Route;
    }

    public RoutingNode[] Route() {
        return Route;
    }

    public void setRoute(RoutingNode[] routingNode) {
        this.Route = routingNode;
    }

    @JsonProperty("CallbackUrl")
    public String getCallbackUrl() {
        return CallbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        CallbackUrl = callbackUrl;
    }

    @JsonProperty("PaymentRequest")
    public PaymentRequest getPaymentRequest() {
        return PaymentRequest;
    }

    public void setPaymentRequest(PaymentRequest paymentRequest) {
        PaymentRequest = paymentRequest;
    }

    @JsonProperty("NodeId")
    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    @JsonIgnore
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ProcessPayment() {
    }

    public ProcessPayment(RoutingNode[] route, String callbackUrl, com.testServer.model.PaymentRequest paymentRequest, String nodeId) {
        Route = route;
        CallbackUrl = callbackUrl;
        PaymentRequest = paymentRequest;
        NodeId = nodeId;
    }

    //**************************************************************************************
    @JsonIgnore
    public void counterPlus() {
        counter++;
    }

    @JsonIgnore
    public boolean isEndOfArray() {
        return !(counter < Route.length);
    }

    @JsonIgnore
    public String getMyNode() {

        if (counter==-1) {
            return NodeId;
        }
        if(isEndOfArray()) return null;
        else
        return Route[counter].getNodeId();
    }
}
