package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCommand {

    private String NodeId;
    private String CommandId;
    private String SessionId;
    private String ResponseBody;

    public ResponseCommand(String nodeId, String commandId, String sessionId, String responseBody) {
        NodeId = nodeId;
        CommandId = commandId;
        SessionId = sessionId;
        ResponseBody = responseBody;
    }

    public ResponseCommand() {
    }

    public ResponseCommand(ProcessCommand processCommand) {
        this.NodeId = processCommand.getNodeId();
        this.CommandId = processCommand.getCommandId();
        this.SessionId = processCommand.getSessionId();
        this.ResponseBody = processCommand.getCommandBody();
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

    @JsonProperty("SessionId")
    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    @JsonProperty("CommandResponse")
    public String getResponseBody() {
        return ResponseBody;
    }

    public void setResponseBody(String responseBody) {
        ResponseBody = responseBody;
    }
}
