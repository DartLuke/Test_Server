package com.testServer.model;

public class RoutingNode {

    private String NodeId;
    private String Address;

    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

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
