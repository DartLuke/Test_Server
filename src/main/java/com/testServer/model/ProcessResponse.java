package com.testServer.model;

public class ProcessResponse {

    String NodeId;
    String CommandId;
    String SessionId;
    String ResponseBody;

    public ProcessResponse(String nodeId, String commandId, String sessionId, String responseBody) {
        NodeId = nodeId;
        CommandId = commandId;
        SessionId = sessionId;
        ResponseBody = responseBody;
    }

    public ProcessResponse() {
    }

    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    public String getCommandId() {
        return CommandId;
    }

    public void setCommandId(String commandId) {
        CommandId = commandId;
    }

    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public String getResponseBody() {
        return ResponseBody;
    }

    public void setResponseBody(String responseBody) {
        ResponseBody = responseBody;
    }
}
