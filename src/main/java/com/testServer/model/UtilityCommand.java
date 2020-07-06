package com.testServer.model;

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

    public int getCommandType() {
        return CommandType;
    }

    public void setCommandType(int commandType) {
        CommandType = commandType;
    }

    public String getCommandBody() {
        return CommandBody;
    }

    public void setCommandBody(String commandBody) {
        CommandBody = commandBody;
    }

    public String getCallbackUrl() {
        return CallbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        CallbackUrl = callbackUrl;
    }

    public String getCommandId() {
        return CommandId;
    }

    public void setCommandId(String commandId) {
        CommandId = commandId;
    }

    public String getNodeId() {
        return NodeId;
    }

    public void setNodeId(String nodeId) {
        NodeId = nodeId;
    }

    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }
}

