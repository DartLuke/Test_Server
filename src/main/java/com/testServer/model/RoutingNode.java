package com.testServer.model;

import com.TestData.CheckList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RoutingNode {

    private String NodeId;
    private String Address;

    @JsonProperty("NodeId")
    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    @JsonProperty("Address")
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public RoutingNode() {
    }

    public RoutingNode(String nodeId, String address) {
        NodeId = nodeId;
        Address = address;
    }

    @JsonIgnore
    private CheckList checkList=new CheckList();

    @JsonIgnore
    public CheckList getCheckList() {
        return checkList;
    }

    @JsonIgnore
    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }
}
