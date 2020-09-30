package com.testServer.model;

import com.TestData.CheckList;
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

    @JsonIgnore
    private CheckList checkList=new CheckList();;


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

    @JsonIgnore
    public void counterPlus() {
        counter++;
    }

    @JsonIgnore
    public boolean isEndOfArray() {
        return !(counter < Route.length);
    }

    @JsonIgnore
    public CheckList getCheckList() {
        return checkList;
    }

    @JsonIgnore
    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }

    @JsonIgnore
    public void setCheckListProcessPaymentCallBack(boolean isDone, int i) {
        if (i == -1) {
            checkList.setProcessPaymentCallBack(isDone);
        } else Route[i].getCheckList().setProcessPaymentCallBack(isDone);
    }

    @JsonIgnore
    public void setCheckListProcessPaymentCallBack(String url) {
        if (counter == -1) {
            checkList.setProcessPaymentCallBack(url);
        } else Route[counter].getCheckList().setProcessPaymentCallBack(url);
    }


    @JsonIgnore
    public void setCheckListProcessCommandCallBack(String url, String nodeId) {
       int counter=findNodebyId(nodeId);

        if (counter == -1) {
            checkList.setProcessCommandCallBack(url);
        } else Route[counter].getCheckList().setProcessCommandCallBack(url);
    }

    @JsonIgnore
    public void setCheckListProcessCommandCallBack(boolean isDone, String nodeId) {
        int counter=findNodebyId(nodeId);

        if (counter == -1) {
            checkList.setProcessCommandCallBack(isDone);
        } else Route[counter].getCheckList().setProcessCommandCallBack(isDone);
    }


    @JsonIgnore
    public void setCheckListProcessCommand(String nodeId)
    {
        int counter=findNodebyId(nodeId);

        if (counter == -1) {
            checkList.setProcessCommand(true);
        } else Route[counter].getCheckList().setProcessCommand(true);
    }

    public void setCheckListProcessResponse(String nodeId) {

        int counter=findNodebyId(nodeId);

        if (counter == -1) {
            checkList.setProcessResponse(true);
        } else Route[counter].getCheckList().setProcessResponse(true);

    }

    public int findNodebyId(String id) {
        if (NodeId.equals(id)) return -1;
        else
            for (int i = 0; i < Route.length; i++) {
                if (Route[i].getNodeId().equals(id)) return i;
            }
        return -2;
    }

    public void setChecklistCompleteCommand(String url, boolean isDone)
    {
        checkList.setCompleteCommand(url, isDone);
    }

    @JsonIgnore
    public boolean isRouteNode() {
        return counter == -1;
    }

    @JsonIgnore
    public String getMyNodeId() {

        if (counter == -1) {
            return NodeId;
        }
        if (isEndOfArray()) return null;
        else
            return Route[counter].getNodeId();
    }


}
