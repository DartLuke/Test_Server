package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProcessPayment {

    private RoutingNode[] routingNode;
    private String CallbackUrl; 		        // process command url
    private String PaymentRequest;	        // json body
    private String NodeId;           		// request reference identification
    private String Route;
@JsonIgnore
private int counter=-1;


    public RoutingNode[] getRoutingNode() {
        return routingNode;
    }

    public void setRoutingNode(RoutingNode[] routingNode) {
        this.routingNode = routingNode;
    }

    public String getCallbackUrl() {
        return CallbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        CallbackUrl = callbackUrl;
    }

    public String getPaymentRequest() {
        return PaymentRequest;
    }

    public void setPaymentRequest(String paymentRequest) {
        PaymentRequest = paymentRequest;
    }

    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    public String getRoute() {
        return Route;
    }

    public void setRoute(String route) {
        Route = route;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public ProcessPayment() {
    }

    public ProcessPayment(RoutingNode[] routingNode, String callbackUrl, String paymentRequest, String nodeId, String route, int counter) {
        this.routingNode = routingNode;
        CallbackUrl = callbackUrl;
        PaymentRequest = paymentRequest;
        NodeId = nodeId;
        Route = route;
        this.counter = counter;
    }

    //**************************************************************************************
    public void counterPlus()
    {
        counter++;
    }

    public boolean isEndOfArray()
    {
        return !(counter<routingNode.length);
    }

    public String getNodeFromArray()
    {
        return routingNode[counter].getNodeId();
    }
}
