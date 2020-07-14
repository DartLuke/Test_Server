package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

   @JsonProperty("NodeId")
    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }
    @JsonProperty("CommandId")
    public String getCommandId() {
        return CommandId;
    }

    public void setCommandId(String commandId) {
        CommandId = commandId;
    }

    @JsonProperty("CommandId")
    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    @JsonProperty("ResponseBody")
    public String getResponseBody() {
        return ResponseBody;
    }

    public void setResponseBody(String responseBody) {
        ResponseBody = responseBody;
    }
}
