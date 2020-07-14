package com.testServer.model;

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
}
