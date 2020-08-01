package com.testServer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompleteCommand {

    private int Status;
    private String SessionId;

    public CompleteCommand() {
    }

    public CompleteCommand(int status,  String sessionId) {
         Status = status;
        SessionId = sessionId;
    }

    @JsonProperty("Status")
    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    @JsonProperty("SessionId")
    public String getSessionId() {
        return SessionId;
    }

    public void setSessionId(String sessionId) {
        SessionId = sessionId;
    }
}

