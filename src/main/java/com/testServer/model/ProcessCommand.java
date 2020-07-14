package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessCommand {
    String CommandType;
    String CommandBody;
    String CommandId;
    String CallbackUrl;
    String NodeId;
    String SessionId;

  @JsonProperty("CommandType")
    public String getCommandType() {
        return CommandType;
    }

    @JsonProperty("CommandBody")
    public String getCommandBody() {
        return CommandBody;
    }

    @JsonProperty("CommandId")
    public String getCommandId() {
        return CommandId;
    }

    @JsonProperty("CallbackUrl")
    public String getCallbackUrl() {
        return CallbackUrl;
    }
    @JsonProperty("NodeId")
    public String getNodeId() {
        return NodeId;
    }
    @JsonProperty("SessionId")
    public String getSessionId() {
        return SessionId;
    }

    public ProcessCommand() {
    }

    @Override
    public String toString() {
        return "ProcessCommand{" +
                "CommandType='" + CommandType + '\'' +
                ", CommandBody='" + CommandBody + '\'' +
                ", CommandId='" + CommandId + '\'' +
                ", CallbackUrl='" + CallbackUrl + '\'' +
                ", NodeId='" + NodeId + '\'' +
                ", SessionId='" + SessionId + '\'' +
                '}';
    }

    public void setCommandType(String commandType) {
        CommandType = commandType;
    }

    public void setCommandBody(String commandBody) {
        CommandBody = commandBody;
    }

    public void setCommandId(String commandId) {
        CommandId = commandId;
    }

    public void setCallbackUrl(String callbackUrl) {
        CallbackUrl = callbackUrl;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }

    public ProcessCommand(String commandType, String commandBody, String commandId, String callbackUrl, String nodeId, String sessionId) {
        CommandType = commandType;
        CommandBody = commandBody;
        CommandId = commandId;
        CallbackUrl = callbackUrl;
        NodeId = nodeId;
        SessionId = sessionId;
    }


}
