package com.testServer.model;

public class ProcessCommand {
    String CommandType;
    String CommandBody;
    String CommandId;
    String CallbackUrl;
    String NodeId;
    String SessionId;

    public String getCommandType() {
        return CommandType;
    }

    public String getCommandBody() {
        return CommandBody;
    }

    public String getCommandId() {
        return CommandId;
    }

    public String getCallbackUrl() {
        return CallbackUrl;
    }

    public String getNodeId() {
        return NodeId;
    }

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
