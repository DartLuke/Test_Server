package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UtilityCommand {

    private int CommandType;
    private String CommandBody;
    private String CallbackUrl;
    private String CommandId;
    private String NodeId;
    private String SessionId;

    public UtilityCommand() {
    }

    public UtilityCommand(int commandType, String commandBody, String callbackUrl, String commandId, String nodeId, String sessionId) {
        CommandType = commandType;
        CommandBody = commandBody;
        CallbackUrl = callbackUrl;
        CommandId = commandId;
        NodeId = nodeId;
        SessionId = sessionId;
    }

    @JsonProperty("CommandType")
    public int getCommandType() {
        return CommandType;
    }

    public void setCommandType(int commandType) {
        CommandType = commandType;
    }

    @JsonProperty("CommandBody")
    public String getCommandBody() {
        return CommandBody;
    }

    public void setCommandBody(String commandBody) {
        CommandBody = commandBody;
    }

    @JsonProperty("CallbackUrl")
    public String getCallbackUrl() {
        return CallbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        CallbackUrl = callbackUrl;
    }

    @JsonProperty("CommandId")
    public String getCommandId() {
        return CommandId;
    }

    public void setCommandId(String commandId) {
        CommandId = commandId;
    }

    @JsonProperty("NodeId")
    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    @JsonProperty("SessionId")
    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }
}

